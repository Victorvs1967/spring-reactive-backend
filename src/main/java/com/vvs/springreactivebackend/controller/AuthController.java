package com.vvs.springreactivebackend.controller;

import com.vvs.springreactivebackend.entity.dto.ResponseDto;
import com.vvs.springreactivebackend.entity.dto.UserDto;
import com.vvs.springreactivebackend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {
  
  @Autowired
  private AuthService authService;

  @PostMapping("v1/signup")
  public Mono<UserDto> signup(@RequestBody UserDto userDto) {
    return authService.signup(userDto);
  }

  @GetMapping("vi/login")
  public Mono<ResponseDto> signup(@RequestHeader("email") String email, @RequestHeader("password") String password) {
    return authService.login(email, password);
  }

}
