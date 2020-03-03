package com.rednavis.maas.bpmnservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rednavis.maas.bpmnservice.service.CamundaProcessService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CamundaProcessController {

  private final CamundaProcessService camundaProcessService;

  @GetMapping("/test")
  public @ResponseBody ProcessInstance test(@RequestParam(defaultValue = "default") String param) {
    List<ProcessDefinition> allProcesses = camundaProcessService.getAllProcesses();
    ProcessDefinition processDefinition = allProcesses.get(0);
    Map<String, Object> params = new HashMap<>();
    params.put("stringParameter", param);
    return camundaProcessService.startProcessInstanceWithVariables(processDefinition.getId(), params);
  }
}
