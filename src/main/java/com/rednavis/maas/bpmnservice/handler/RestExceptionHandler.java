package com.rednavis.maas.bpmnservice.handler;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.exception.NullValueException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.rednavis.maas.bpmnservice.dto.ApiException;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler({ProcessEngineException.class, NullValueException.class})
  public ResponseEntity<Object> handleBpmException(HttpRequest r, ProcessEngineException e) {
    return new ResponseEntity<>(new ApiException(HttpStatus.BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
  }

}
