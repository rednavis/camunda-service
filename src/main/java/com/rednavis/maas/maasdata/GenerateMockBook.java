package com.rednavis.maas.maasdata;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import com.rednavis.maas.maasdata.entity.BookEntity;
import com.rednavis.maas.maasdata.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import net.andreinc.mockneat.MockNeat;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenerateMockBook {

  private final MongoTemplate mongoTemplate;
  private final BookRepository bookRepository;

  public void startGenerate() {
    bookRepository.deleteAll();

    MockNeat mock = MockNeat.threadLocal();
    List<BookEntity> bookEntityList = mock.filler(() -> new BookEntity())
        .setter(BookEntity::setTitle, mock.countries().names())
        .setter(BookEntity::setAuthor, mock.users())
        .setter(BookEntity::setPageCount, mock.ints().range(100, 500))
        .setter(BookEntity::setIsbn, mock.creditCards().names())
        .setter(BookEntity::setPublishYear, mock.localDates().map(localDate -> localDate.getYear()))
        .setter(BookEntity::setStatus, mock.from(BookStatus.class))
        .list(() -> new ArrayList<>(), 100)
        .val();

    MongoCollection<Document> mongoCollection = mongoTemplate.getCollection("book");
    List<WriteModel<Document>> writes = new ArrayList<>();
    MongoConverter converter = mongoTemplate.getConverter();
    for (BookEntity entity : bookEntityList) {
      Document document = new Document();
      converter.write(entity, document);
      WriteModel<Document> writeModel = new InsertOneModel<>(document);
      writes.add(writeModel);
    }
    mongoCollection.bulkWrite(writes);
  }
}
