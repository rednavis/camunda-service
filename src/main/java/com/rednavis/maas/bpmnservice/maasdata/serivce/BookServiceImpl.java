package com.rednavis.maas.bpmnservice.maasdata.serivce;

import static com.rednavis.maas.bpmnservice.maasdata.mapper.MapperProvider.BOOK_MAPPER;

import com.rednavis.maas.bpmnservice.maasdata.dto.Book;
import com.rednavis.maas.bpmnservice.maasdata.entity.BookEntity;
import com.rednavis.maas.bpmnservice.maasdata.repository.BookRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  @Override
  public Book insert(Book book) {
    BookEntity bookEntity = BOOK_MAPPER.dtoToEntity(book);
    bookEntity = bookRepository.insert(bookEntity);
    return BOOK_MAPPER.entityToDto(bookEntity);
  }

  @Override
  public Book save(Book book) {
    BookEntity bookEntity = BOOK_MAPPER.dtoToEntity(book);
    bookEntity = bookRepository.save(bookEntity);
    return BOOK_MAPPER.entityToDto(bookEntity);
  }

  @Override
  public List<Book> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<BookEntity> bookEntityPage = bookRepository.findAll(pageable);
    List<BookEntity> bookEntityList = Lists.newArrayList(bookEntityPage.iterator());
    return BOOK_MAPPER.listEntityToListDto(bookEntityList);
  }

  @Override
  public long count() {
    return bookRepository.count();
  }

  @Override
  public void deleteById(String bookId) {
    bookRepository.deleteById(bookId);
  }
}
