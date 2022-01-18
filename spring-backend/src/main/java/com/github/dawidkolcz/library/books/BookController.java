package com.github.dawidkolcz.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    List<Book> readAll() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    Book readBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(new EmptyBook());
    }

    @DeleteMapping("/book/{id}")
    void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
