package com.veliqoAPI.veliqoAPI.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.veliqoAPI.veliqoAPI.security.user.Permission.*;
import static com.veliqoAPI.veliqoAPI.security.user.Role.ADMIN;
import static com.veliqoAPI.veliqoAPI.security.user.Role.APPLICANT;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
  @Autowired
  private JwtAuthenticationFilter jwtAuthFilter;
  @Autowired
  private AuthenticationProvider authenticationProvider;
  @Autowired
  private LogoutHandler logoutHandler;


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(
                "/register","/authenticate","/applicant/**","/admin/**","/profile/**",
                "/v2/api-docs",
                "/v3/api-docs",
                "/v3/api-docs/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/swagger-ui.html"
        )
          .permitAll()

        .requestMatchers("/applicant/**").hasAnyRole(APPLICANT.name())
        .requestMatchers(GET, "/applicant/**").hasAnyAuthority(APPLICANT_READ.name())
        .requestMatchers(POST, "/applicant/**").hasAnyAuthority(APPLICANT_CREATE.name())

        .requestMatchers("/admin/**").hasRole(ADMIN.name())
        .requestMatchers(GET, "/admin/**").hasAuthority(ADMIN_READ.name())
        .requestMatchers(POST, "/admin/**").hasAuthority(ADMIN_CREATE.name())
        .requestMatchers(PUT, "/admin/**").hasAuthority(ADMIN_UPDATE.name())
        .requestMatchers(DELETE, "/admin/**").hasAuthority(ADMIN_DELETE.name())

        .requestMatchers("/profile/**").hasAnyRole(ADMIN.name(), APPLICANT.name())
        .requestMatchers(GET, "/profile/**").hasAnyAuthority(ADMIN_READ.name(), APPLICANT_READ.name())

        .anyRequest()
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }
}
