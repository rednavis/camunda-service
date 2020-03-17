package com.rednavis.maas.bpmnservice;

import com.rednavis.maas.maasdata.GenerateMockBook;
import com.rednavis.maas.maasdata.MaasDataModule;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Import({MaasDataModule.class})
@SpringBootApplication
public class BpmnServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BpmnServiceApplication.class, args);
  }

  @Component
  @AllArgsConstructor
  class ContextStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    private final GenerateMockBook generateMockBook;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      log.info("Generate mock books!!!");
      generateMockBook.startGenerate();
    }
  }
}
