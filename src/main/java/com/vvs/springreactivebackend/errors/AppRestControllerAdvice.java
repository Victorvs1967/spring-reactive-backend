package com.vvs.springreactivebackend.errors;

import com.vvs.springreactivebackend.errors.exception.UserAlreadyExistException;
import com.vvs.springreactivebackend.errors.exception.UserNotFoundException;
import com.vvs.springreactivebackend.errors.exception.WronCredentialException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

import static com.vvs.springreactivebackend.errors.Error.*;

@Log4j2
@RestControllerAdvice
public class AppRestControllerAdvice {
  
  @ExceptionHandler(value = WronCredentialException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public Error wronCredentialException(final WronCredentialException e) {
    return WRONG_CREDENTIALS;
  }

  @ExceptionHandler(value = UserAlreadyExistException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public Error wronCredentialException(final UserAlreadyExistException e) {
    return USER_ALREADY_EXIST;
  }

  @ExceptionHandler(value = UserNotFoundException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public Error wronCredentialException(final UserNotFoundException e) {
    return USER_NOT_FOUND;
  }
}
