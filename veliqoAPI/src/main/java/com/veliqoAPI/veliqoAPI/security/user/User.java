package com.veliqoAPI.veliqoAPI.security.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.veliqoAPI.veliqoAPI.security.token.Token;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
//@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})

public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty(message = "Name is required")
  private String name;

  @NotEmpty(message = "Date of Birth is required")
  private String dob;
  @Pattern(regexp="^[A-Z0-9-]*$",message="ID can only have letters, numbers, ‘-‘")
  @NotEmpty(message = "ID Number is required")
  private String idNumber;
  @NotEmpty(message = "Phone number is required")
  private String contact;
  @NotEmpty(message = "City is required")
  private String city;
  @NotEmpty(message = "Gender is required")
  private String gender;
  @NotEmpty(message = "Email is required")
  @Email
  private String email;
  @NotEmpty(message = "Password is required")
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;
  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  public User(String name, String dob, String idNumber, String contact, String city, String gender, String email, String password, Role role, List<Token> tokens) {
    this.name = name;
    this.dob = dob;
    this.idNumber = idNumber;
    this.contact = contact;
    this.city = city;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.role = role;
    this.tokens = tokens;
  }

  public User(String name, String dob, String idNumber, String contact, String city, String gender, String email, String password, Role role) {
    this.name = name;
    this.dob = dob;
    this.idNumber = idNumber;
    this.contact = contact;
    this.city = city;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.role = role;
  }

public User(){}
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
