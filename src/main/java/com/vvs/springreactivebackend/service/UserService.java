package com.vvs.springreactivebackend.service;

import com.vvs.springreactivebackend.entity.dto.UserDto;

import reactor.core.publisher.Mono;

public interface UserService {
  Mono<UserDto> getUser(String email);
}
