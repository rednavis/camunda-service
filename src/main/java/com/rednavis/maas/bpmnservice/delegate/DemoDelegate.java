package com.rednavis.maas.bpmnservice.delegate;

import java.util.Map;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import com.rednavis.maas.bpmnservice.maasdata.dto.Book;
import com.rednavis.maas.bpmnservice.maasdata.serivce.BookService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DemoDelegate implements JavaDelegate {

  private final BookService bookService;

  @Override
  public void execute(DelegateExecution execution) {
    Map<String, Object> variables = execution.getVariables();
    for (String key : variables.keySet()) {
      if (key.equals("bookId")) {
        String bookId = (String) variables.get(key);
        Book book = bookService.findById(bookId);
        execution.setVariable("book", book.toString());
      }
    }
  }
}
