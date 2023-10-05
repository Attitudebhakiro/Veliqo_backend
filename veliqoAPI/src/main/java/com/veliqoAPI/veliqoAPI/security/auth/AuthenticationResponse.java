package com.veliqoAPI.veliqoAPI.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.veliqoAPI.veliqoAPI.security.response.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("email")
  private String email;

  public AuthenticationResponse(String accessToken, String email) {
    this.accessToken = accessToken;
    this.email = email;
  }
}
