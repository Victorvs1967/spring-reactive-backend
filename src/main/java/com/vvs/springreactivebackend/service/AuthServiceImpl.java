package com.vvs.springreactivebackend.service;

import com.vvs.springreactivebackend.entity.dto.ResponseDto;
import com.vvs.springreactivebackend.entity.dto.UserDto;
import com.vvs.springreactivebackend.repository.UserRepository;
import com.vvs.springreactivebackend.security.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private UserRepository userRepository;
  @Autowired PasswordEncoder passwordEncoder;
  @Autowired
  private JWTUtil jwtUtil;
  
  @Override
  public Mono<UserDto> signup(UserDto userDto) {
    return isUserExist(userDto.getEmail())
      .filter(userExist -> !userExist)
      .switchIfEmpty(Mono.error(UserAlreadyExistException::new))
      .map(aBoolean -> userDto)
      .map(UserMapper.INSTANCE::fromDTO)
      .doOnNext(user -> user.setPassword(passwordEncoder.encode(user.getPassword())))
      .flatMap(userRepository::save)
      .map(UserMapper.INSTANCE::toDTO);
  }

  @Override
  public Mono<ResponseDto> login(String email, String password) {
    return userRepository.findByEmail(email)
      .filter(userDetails -> passwordEncoder.matches(password, userDetails.getPassword()))
      .map(userDetails -> jwtUtil.generateToken(userDetails))
      .map(token -> ResponseDto.builder().data(token).build())
      .switchIfEmpty(Mono.error(WronCredentialException::new));
  }

  private Mono<Boolean> isUserExist(String email) {
    return userRepository.findByEmail(email)
      .map(user -> true)
      .switchIfEmpty(Mono.just(false));
  }
  
}
