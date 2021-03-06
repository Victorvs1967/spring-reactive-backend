package com.vvs.springreactivebackend.entity.model;

import java.util.Collection;
import java.util.Collections;

import com.vvs.springreactivebackend.entity.enums.UserRoles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document("users")
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
  
  @Id
  private String id;
  private String password;
  private String firstName;
  private String lastName;
  private String phone;
  @Indexed(background = true, unique = true)
  private String email;
  private UserRoles role;
  private boolean active = true;

  public String getFullName() {
    return firstName != null ? firstName.concat(" ").concat(lastName) : "";
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return active;
  }

  @Override
  public boolean isAccountNonLocked() {
    return active;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return active;
  }

  @Override
  public boolean isEnabled() {
    return active;
  }

}
