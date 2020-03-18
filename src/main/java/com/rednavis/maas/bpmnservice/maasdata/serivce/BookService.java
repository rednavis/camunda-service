package com.rednavis.maas.bpmnservice.maasdata.serivce;

import com.rednavis.maas.bpmnservice.maasdata.BookPage;
import com.rednavis.maas.bpmnservice.maasdata.dto.Book;
import java.util.List;

public interface BookService {

  Book insert(Book book);

  Book save(Book book);

  List<Book> findAll(BookPage bookPage);

  void delete(Book book);
}
