package com.rednavis.maas.bpmnservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(HttpMessageConversionException.class)
  public ResponseEntity<String> handleMapperException() {
    return new ResponseEntity<>("Mapping exception happened but everything is fine", HttpStatus.OK);
  }

}
