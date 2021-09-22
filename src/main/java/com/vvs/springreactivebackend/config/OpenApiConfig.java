package com.vvs.springreactivebackend.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
  info = @Info(
    title = "Spring Reactive Backend",
    version = "v1",
    description = "This documentation app provides REST APIs",
    contact = @Contact(
      email = "victorsmirnov67@gmail.com"
    )
  ),
  servers = {
    @Server(
      url = "http://localhost:3030",
      description = "Spring Reactive API (Local)"
    )
  }
)
@SecurityScheme(
  name = "bearerAuth",
  type = SecuritySchemeType.HTTP,
  bearerFormat = "JWT",
  scheme = "bearer"
)
@Configuration
public class OpenApiConfig {
  // Type in the url in browser
  // http://localhost:9090/webjars/swagger-ui/index.html?url=http://localhost:9090/v3/api-docs
}
