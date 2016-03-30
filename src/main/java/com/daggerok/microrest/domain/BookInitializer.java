package com.daggerok.microrest.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookInitializer implements CommandLineRunner {

    @Autowired
    BookRepository repo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        repo.save(Arrays.asList("max, bax, fax".split(", ")).stream()
                                                            .map(this::from)
                                                            .collect(Collectors.toList()));

        repo.findAllBy().map(Book::toString).map("\n\t"::concat).forEach(log::info);
    }
    
    private Book from(String name)  {
        return new Book().setAuthor(name).setTitle(name);
    }
}
