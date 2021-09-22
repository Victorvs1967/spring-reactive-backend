package com.vvs.springreactivebackend.service;

import com.vvs.springreactivebackend.entity.dto.UserDto;
import com.vvs.springreactivebackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Mono<UserDto> getUser(String email) {
    return userRepository.findUserByEmail(email)
    .map(UserMapper.INSTANCE::toDTO)
    .switchIfEmpty(Mono.error(UserNotFoundException::new));
  }
  
}
