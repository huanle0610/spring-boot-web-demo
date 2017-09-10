package org.parami.ygds.repository;

import org.parami.ygds.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer> {
}
