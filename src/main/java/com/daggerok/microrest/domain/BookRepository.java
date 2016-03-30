package com.daggerok.microrest.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Stream<Book> findAllByAuthor(String author);

    Stream<Book> findAllByTitle(String title);

    Stream<Book> findAllBy();
}
