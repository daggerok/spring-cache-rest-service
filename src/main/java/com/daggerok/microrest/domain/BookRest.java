package com.daggerok.microrest.domain;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CacheConfig(cacheNames = {"books"}) // 2
public class BookRest {
    @Autowired
    BookRepository repo;

    @Cacheable
    @RequestMapping("/") // 2
    public Collection<Book> get() {
        log.info("getting all...");
        return repo.findAll();
    }

    @Cacheable
    @RequestMapping("/{id}") // 2
    public Book get(@PathVariable("id") Long id) {
        log.info("getting one {}", id);
        return repo.findOne(id);
    }

    @Cacheable
    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody Book book) {
        return repo.save(book).id;
    }

    @CachePut(key = "#book.id")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id, @RequestBody Book book) {
        repo.save(book);
    }

    @CacheEvict
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        repo.delete(id);
    }
}
