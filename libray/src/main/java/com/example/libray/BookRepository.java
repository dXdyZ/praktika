package com.example.libray;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByName(String name);
    List<Book> findAllByAuthor(String author);
    List<Book> findAllByDate(Date date);
    Optional<Book> findByNameAndAuthor(String name, String author);
}
