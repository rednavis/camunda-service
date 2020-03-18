package com.rednavis.maas.bpmnservice.maasdata.repository;

import com.rednavis.maas.bpmnservice.maasdata.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookEntity, String> {

}
