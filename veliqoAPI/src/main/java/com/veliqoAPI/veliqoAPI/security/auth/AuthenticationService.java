package com.veliqoAPI.veliqoAPI.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veliqoAPI.veliqoAPI.security.config.JwtService;
import com.veliqoAPI.veliqoAPI.security.token.TokenRepository;
import com.veliqoAPI.veliqoAPI.security.token.TokenType;
import com.veliqoAPI.veliqoAPI.security.user.User;
import com.veliqoAPI.veliqoAPI.security.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import  com.veliqoAPI.veliqoAPI.security.token.Token;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
  @Autowired
  private  UserRepository repository;
  @Autowired
  private  TokenRepository tokenRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtService jwtService;
  @Autowired
  private  AuthenticationManager authenticationManager;



  public User register(RegisterRequest request) {
User user = new User(request.getName(), request.getDob(), request.getIdNumber(), request.getContact(), request.getCity(), request.getGender(), request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getRole());
    return repository.save(user);

  }



  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );

    User user = repository.findByEmail(request.getEmail())
        .orElseThrow();

    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
//    return AuthenticationResponse.builder()
//        .accessToken(jwtToken)
//            .refreshToken(refreshToken)
//        .build();

     // return ResponseEntity.ok(new JwtResponse(jwtToken, request.getEmail()));

    return new AuthenticationResponse(jwtToken,request.getEmail());
  }

  private void saveUserToken(User user, String jwtToken) {
    Token token = new Token(jwtToken,TokenType.BEARER,false,false,user);
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = this.repository.findByEmail(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        var accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        var authResponse = new AuthenticationResponse(accessToken,refreshToken);
//        var authResponse = AuthenticationResponse.builder()
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
//                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
