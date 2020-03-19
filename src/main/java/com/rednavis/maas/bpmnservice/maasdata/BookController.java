package com.rednavis.maas.bpmnservice.maasdata;

import com.rednavis.maas.bpmnservice.maasdata.dto.Book;
import com.rednavis.maas.bpmnservice.maasdata.serivce.BookService;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping("/insert")
  public Book insert(@RequestBody Book book) {
    return bookService.insert(book);
  }

  @PutMapping("/save")
  public Book save(@RequestBody Book book) {
    return bookService.save(book);
  }

  @GetMapping("/findAll")
  public List<Book> findAllGet(@RequestParam int page, @RequestParam int size) {
    log.info("findAll get [page: {}, size: {}]", page, size);
    return bookService.findAll(page, size);
  }

  @GetMapping("/count")
  public long count() {
    return bookService.count();
  }

  @DeleteMapping("/delete")
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestParam String bookId) {
    bookService.deleteById(bookId);
  }

  @GetMapping("/test1")
  public @ResponseBody
  StringResponse test1() {
    StringResponse stringResponse = new StringResponse();
    stringResponse.setResponse("Hello World!");
    return stringResponse;
  }

  @GetMapping("/test2")
  public @ResponseBody
  List<Book> findAllGet() {
    return bookService.findAll(2, 5);
  }

  @Data
  class StringResponse {

    private String response;
  }
}