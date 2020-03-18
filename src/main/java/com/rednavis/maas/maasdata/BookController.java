package com.rednavis.maas.maasdata;

import com.rednavis.maas.maasdata.dto.Book;
import com.rednavis.maas.maasdata.serivce.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping("/insert")
  public Book insert(@RequestBody Book book) {
    return bookService.insert(book);
  }

  @PostMapping("/save")
  public Book save(@RequestBody Book book) {
    return bookService.save(book);
  }

  @PostMapping("/findAll")
  public List<Book> findAll(@RequestBody BookPage bookPage) {
    return bookService.findAll(bookPage);
  }

  @PostMapping("/delete")
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@RequestBody Book book) {
    bookService.delete(book);
  }
}