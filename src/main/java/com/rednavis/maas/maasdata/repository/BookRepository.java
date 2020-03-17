package com.rednavis.maas.maasdata.repository;

import com.rednavis.maas.maasdata.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookEntity, String> {

}
