package com.rednavis.maas.maasdata.serivce;

import com.rednavis.maas.maasdata.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
}
