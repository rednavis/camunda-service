package com.rednavis.maas.bpmnservice.maasdata;

import com.rednavis.maas.bpmnservice.maasdata.dto.Book;
import com.rednavis.maas.bpmnservice.maasdata.serivce.BookService;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
//@Produces(MediaType.APPLICATION_JSON_VALUE)
//@Consumes(MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping("/insert")
  public @ResponseBody
  Book insert(@RequestBody Book book) {
    return bookService.insert(book);
  }

  @PostMapping("/save")
  public @ResponseBody
  Book save(@RequestBody Book book) {
    return bookService.save(book);
  }

  @PostMapping("/findAll")
  public @ResponseBody
  List<Book> findAll(@RequestBody BookPage bookPage) {
    log.info("findAll post [bookPage: {}]", bookPage);
    return bookService.findAll(bookPage);
  }

  @GetMapping("/findAll")
  public @ResponseBody
  List<Book> findAllGet(@RequestBody BookPage bookPage) {
    log.info("findAll get [bookPage: {}]", bookPage);
    return bookService.findAll(bookPage);
  }

  @PostMapping("/delete")
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody Book book) {
    bookService.delete(book);
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
    BookPage bookPage = new BookPage();
    bookPage.setPage(2);
    bookPage.setSize(5);
    log.info("findAll get [bookPage: {}]", bookPage);
    return bookService.findAll(bookPage);
  }

  @Data
  class StringResponse {

    private String response;
  }
}