package com.rednavis.maas.bpmnservice.config;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.impl.AbstractCamundaConfiguration;
import org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class CamundaConfiguration extends AbstractCamundaConfiguration {

  @Value("${processes.path}")
  private String processesFolder;

  private final ApplicationContext applicationContext;

  @Override
  public void preInit(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
    super.preInit(springProcessEngineConfiguration);
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      URL processesFolderUrl = classLoader.getResource(processesFolder);
      Resource[] resources = applicationContext.getResources("file:" + processesFolderUrl.getPath() + "/*.bpmn");
      springProcessEngineConfiguration.setDeploymentResources(resources);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }

    List<ProcessEnginePlugin> plugins = new ArrayList<>(springProcessEngineConfiguration.getProcessEnginePlugins());
    plugins.add(new ConnectProcessEnginePlugin());
    plugins.add(new SpinProcessEnginePlugin());
    springProcessEngineConfiguration.setProcessEnginePlugins(plugins);
  }
}
