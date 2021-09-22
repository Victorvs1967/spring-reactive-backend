package com.vvs.springreactivebackend.entity.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {
  
  private Object data;
}
