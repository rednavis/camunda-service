package com.rednavis.maas.bpmnservice.maasdata.dto;

import com.rednavis.maas.bpmnservice.maasdata.BookStatus;
import lombok.Data;

@Data
public class Book {

  private String id;
  private int count;
  private String title;
  private String author;
  private int pageCount;
  private String isbn;
  private int publishYear;
  private BookStatus status;
}
