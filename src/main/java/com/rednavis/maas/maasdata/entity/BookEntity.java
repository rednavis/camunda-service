package com.rednavis.maas.maasdata.entity;

import com.rednavis.maas.maasdata.BookStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("book")
public class BookEntity {

  @Id
  private Long id;
  private String title;
  private String author;
  private int pageCount;
  private String isbn;
  private int publishYear;
  private BookStatus status;
}
