package com.example.libray;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookUserService {
    private final BookService bookService;
    private final UserService userService;
    private final UserBookRepository userBookRepository;

    @Autowired
    public BookUserService(BookService bookService, UserService userService, UserBookRepository userBookRepository) {
        this.bookService = bookService;
        this.userService = userService;
        this.userBookRepository = userBookRepository;
    }

    @Transactional
    public String receiverBook(ReceiverDTO receiverDTO) {
        UserBook userBook = null;
        try {
            userBook = UserBook.builder()
                    .books(bookService.getByNameAndAuthor(receiverDTO.getBookName(), receiverDTO.getAuthor()))
                    .users(userService.getByUsernameAndPhoneNumber(receiverDTO.getUsername(), receiverDTO.getPhoneNumber()))
                    .reservationDate(Book.mapStringInDate(receiverDTO.getReceiverDate()))
                    .recoilDate(Book.mapStringInDate(receiverDTO.getRecoilDate()))
                    .build();
            saveReceiver(userBook);
        } catch (NullPointerException e) {
            return "Произошла ошибка при добавление записи";
        }
        return userBook.toString();
    }

    public List<Book> getByUserNameBook(String username) {
        List<UserBook> userBooks = userBookRepository.findAllByUsers_Username(username);
        List<Book> booksBelongUser = new ArrayList<>();
        userBooks.forEach(x -> {
            booksBelongUser.add(Book.builder()
                            .name(x.getBooks().getName())
                            .author(x.getBooks().getAuthor())
                            .date(x.getBooks().getDate())
                    .build());
        });
        return booksBelongUser;
    }

    public List<ReceiverDTO> getAllReceiver() {
        Iterable<UserBook> iterable = userBookRepository.findAll();
        List<ReceiverDTO> receiverDTOS = new ArrayList<>();
        for (UserBook userBook : iterable) {
            receiverDTOS.add(ReceiverDTO.builder()
                    .username(userBook.getUsers().getUsername())
                    .phoneNumber(userBook.getUsers().getPhoneNumber())
                    .bookName(userBook.getBooks().getName())
                    .author(userBook.getBooks().getAuthor())
                    .receiverDate(String.valueOf(userBook.getReservationDate()))
                    .recoilDate(String.valueOf(userBook.getRecoilDate()))
                    .build());
        }
        return receiverDTOS;
    }

    private void saveReceiver(UserBook userBook) {
        userBookRepository.save(userBook);
    }
}
