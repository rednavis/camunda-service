package com.rednavis.maas.bpmnservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class BpmnServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BpmnServiceApplication.class, args);
  }

}
