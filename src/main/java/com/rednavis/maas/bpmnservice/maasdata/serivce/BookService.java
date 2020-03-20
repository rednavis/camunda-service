package com.rednavis.maas.bpmnservice.maasdata.serivce;

import com.rednavis.maas.bpmnservice.maasdata.dto.Book;
import java.util.List;

public interface BookService {

  Book insert(Book book);

  Book save(Book book);

  List<Book> findAll(int limit, int offset);

  long count();

  void deleteById(String bookId);

  Book findById(String bookId);
}
