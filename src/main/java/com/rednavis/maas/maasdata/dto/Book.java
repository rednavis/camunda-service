package com.rednavis.maas.maasdata.dto;

import com.rednavis.maas.maasdata.BookStatus;
import lombok.Data;

@Data
public class Book {

  private Long id;
  private String title;
  private String author;
  private int pageCount;
  private String isbn;
  private int publishYear;
  private BookStatus status;
}
