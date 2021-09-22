package com.vvs.springreactivebackend.entity.mapper;

import java.util.Collections;
import java.util.HashSet;

import com.vvs.springreactivebackend.entity.dto.UserDto;
import com.vvs.springreactivebackend.entity.enums.UserRoles;
import com.vvs.springreactivebackend.entity.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Mapper(imports = {HashSet.class, Collections.class, SimpleGrantedAuthority.class, UserRoles.class})
public interface UserMapper {
  
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "password", ignore = true)
  UserDto toDTO(final User user);

  User fromDTO(final UserDto userDto);
}
