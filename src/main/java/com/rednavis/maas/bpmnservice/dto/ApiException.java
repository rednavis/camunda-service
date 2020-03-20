package com.rednavis.maas.bpmnservice.dto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public class ApiException {
  LocalDateTime timestamp;
  int status;
  String error;
  List<String> messages;

  public ApiException(HttpStatus status, String... messages) {
    this.timestamp = LocalDateTime.now();
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.messages = Arrays.asList(messages);
  }
}
