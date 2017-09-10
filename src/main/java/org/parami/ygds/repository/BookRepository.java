package org.parami.ygds.repository;

import org.parami.ygds.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {
}
