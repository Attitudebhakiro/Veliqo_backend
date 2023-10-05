package com.veliqoAPI.veliqoAPI.security.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import com.veliqoAPI.veliqoAPI.security.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

  @Pattern(regexp="^((\\w+ )*\\w+)?$",message="Name can only have letters")
  @NotNull(message = "Name is required")
  private String name;
  @NotNull(message = "Date of Birth is required")
  private String dob;
  @Pattern(regexp="^[A-Z0-9-]*$",message="ID can only have letters, numbers, ‘-‘")
  @NotNull(message = "ID Number is required")
  private String idNumber;
  @NotNull(message = "Phone number is required")
  private String contact;
  @NotEmpty(message = "City is required")
  private String city;
  @NotEmpty(message = "Gender is required")
  private String gender;
  @NotNull(message = "Email is required")
  @Email
  private String email;
  @NotNull(message = "Password is required")
  private String password;
  @NotNull(message = "Role is required")
  private Role role;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
