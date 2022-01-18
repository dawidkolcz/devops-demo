package com.github.dawidkolcz.library.books;

import java.util.ArrayList;
import java.util.List;

public class ExpectedBookResults {
    public static List<Book> expectedList() {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Book book = new Book(Integer.toUnsignedLong(i),
                    String.format("Book %1$d", i),
                    true);
            books.add(book);
        }
        return books;
    }

    public static Book expectedBook() {
        return new Book(10L, "Book", true);
    }

    public static EmptyBook expectedEmptyBook() {
        return new EmptyBook();
    }
}
