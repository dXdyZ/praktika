package com.example.libray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) throws Exception {
        try {
            getByNameAndAuthor(book.getName(), book.getAuthor());
        } catch (NullPointerException e) {
            bookRepository.save(book);
        }
    }

    public Iterable<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getByIdBook(Long id) {
        return bookRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Book getByName(String name) {
        return bookRepository.findByName(name).orElseThrow(NullPointerException::new);
    }

    public List<Book> getAllByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> getAllByDate(String date) {
        Date dateMap = Book.mapStringInDate(date);
        return bookRepository.findAllByDate(dateMap);
    }

    public Book getByNameAndAuthor(String name, String author) {
        return bookRepository.findByNameAndAuthor(name, author).orElseThrow(NullPointerException::new);
    }
}
