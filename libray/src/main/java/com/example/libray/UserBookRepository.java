package com.example.libray;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookRepository extends CrudRepository<UserBook, Long> {
    List<UserBook> findAllByUsers_Username(String username);
    List<UserBook> findAllByBooks_NameAndBooks_Author(String name, String author);
}
