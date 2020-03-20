package com.rednavis.maas.bpmnservice.controller;

import com.rednavis.maas.bpmnservice.service.CamundaProcessService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.rest.dto.repository.ProcessDefinitionDto;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CamundaProcessController {

  private final CamundaProcessService camundaProcessService;

  @GetMapping("/test")
  public ProcessInstanceDto test(@RequestParam(defaultValue = "default") String param) {
    List<ProcessDefinition> allProcesses = camundaProcessService.getAllProcesses();
    ProcessDefinition processDefinition = allProcesses.get(0);
    Map<String, Object> params = new HashMap<>();
    params.put("stringParameter", param);
    return ProcessInstanceDto.fromProcessInstance(camundaProcessService.startProcessInstanceWithVariables(processDefinition.getId(), params));
  }

  @GetMapping("/processes")
  public List<ProcessDefinitionDto> getProcesses() {
    return camundaProcessService.getAllProcesses().stream().map(ProcessDefinitionDto::fromProcessDefinition).collect(Collectors.toList());
  }

  @PostMapping("/process/{id}")
  public ProcessInstanceDto startProcess(@PathVariable String id, @RequestBody(required = false) Map<String, Object> params) {
    return ProcessInstanceDto.fromProcessInstance(camundaProcessService.startProcessInstanceWithVariables(id, params));
  }

}
