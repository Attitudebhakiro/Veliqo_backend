package com.veliqoAPI.veliqoAPI.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.veliqoAPI.veliqoAPI.security.user.Permission.*;


//@RequiredArgsConstructor
public enum Role {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  APPLICANT_READ,
                  APPLICANT_UPDATE,
                  APPLICANT_DELETE,
                  APPLICANT_CREATE
          )
  ),
  APPLICANT(
          Set.of(
                  APPLICANT_READ,
                  APPLICANT_UPDATE,
                  APPLICANT_DELETE,
                  APPLICANT_CREATE
          )
  );

  @Getter
  private final Set<Permission> permissions;

  public Set<Permission> getPermissions() {
    return permissions;
  }

 Role(Set<Permission> permissions) {
    this.permissions = permissions;
  }

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }


}
