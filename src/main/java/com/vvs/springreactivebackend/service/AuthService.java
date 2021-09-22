package com.vvs.springreactivebackend.service;

import com.vvs.springreactivebackend.entity.dto.ResponseDto;
import com.vvs.springreactivebackend.entity.dto.UserDto;

import reactor.core.publisher.Mono;

public interface AuthService {
  
  Mono<UserDto> signup(UserDto userDto);
  Mono<ResponseDto> login(String email, String password);
}
