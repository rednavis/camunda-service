package com.rednavis.maas.bpmnservice.delegate;

import java.util.Map;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DemoDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    Map<String, Object> variables = execution.getVariables();
    for (String key : variables.keySet()) {
      if (variables.get(key).equals("default")) {
        execution.setVariable(key, "modified");
      }
    }
  }
}
