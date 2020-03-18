package com.rednavis.maas.maasdata.serivce;

import com.rednavis.maas.maasdata.BookPage;
import com.rednavis.maas.maasdata.dto.Book;
import java.util.List;

public interface BookService {

  Book insert(Book book);

  Book save(Book book);

  List<Book> findAll(BookPage bookPage);

  void delete(Book book);
}
