package com.rednavis.maas.bpmnservice.service;

import java.util.List;
import java.util.Map;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CamundaProcessService {

  private final RuntimeService runtimeService;
  private final RepositoryService repositoryService;

  public List<ProcessDefinition> getAllProcesses() {
    return repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionKey().asc().latestVersion().list();
  }

  public ProcessInstance startProcessInstance(String processDefinitionId) {
    return runtimeService.startProcessInstanceById(processDefinitionId);
  }

  public ProcessInstance startProcessInstanceWithVariables(String processDefinitionId, Map<String, Object> variables) {
    return runtimeService.startProcessInstanceById(processDefinitionId, variables);
  }

}
