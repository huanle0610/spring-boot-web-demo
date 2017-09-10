package org.parami.ygds.controller;

import org.parami.ygds.entity.BookEntity;
import org.parami.ygds.repository.BookRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("books")
    public @ResponseBody Iterable<BookEntity> getAllArticles() {
        logger.info("get all article");
        return bookRepository.findAll();
    }

    @GetMapping("book/{id}")
    public @ResponseBody BookEntity getArticle(@PathVariable int id) {
        return bookRepository.findOne(id);
    }
}
