package com.vvs.springreactivebackend.repository;

import com.vvs.springreactivebackend.entity.model.User;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
  
  Mono<UserDetails> findByEmail(final String email);
  Mono<User> findUserByEmail(final String email);
}