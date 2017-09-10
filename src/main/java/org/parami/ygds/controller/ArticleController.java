package org.parami.ygds.controller;

import org.parami.ygds.repository.ArticleRepository;
import org.parami.ygds.entity.ArticleEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping("articles")
    public @ResponseBody Iterable<ArticleEntity> getAllArticles() {
        logger.info("get all article");
        return articleRepository.findAll();
    }

    @GetMapping("article/{id}")
    public @ResponseBody ArticleEntity getArticle(@PathVariable int id) {
        return articleRepository.findOne(id);
    }
}
