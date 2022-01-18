package com.github.dawidkolcz.library.books;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

@Test(groups = "units")
public class BookControllerTest {
    BookRepository mockedRepository = Mockito.mock(BookRepository.class);
    BookController bookController = new BookController(mockedRepository);

    @Test
    public void testShouldReturnAllBooks() {
        // Given
        List<Book> expected = ExpectedBookResults.expectedList();

        // When
        Mockito.when(mockedRepository.findAll()).thenReturn(expected);
        List<Book> actual = bookController.readAll();

        // Then
        assertEquals(actual, expected, "List of books differs.");
    }

    @Test
    public void testShouldCreateNewBook() {
        // Given
        Book expected = ExpectedBookResults.expectedBook();

        // When
        Mockito.when(mockedRepository.save(Mockito.any())).thenReturn(expected);
        Book actual = bookController.createBook(new Book(1L, "Book", true));

        // Then
        assertEquals(actual, expected, "Books differ when creating new Book.");
    }

    @Test
    public void testShouldGetBookById() {
        // Given
        Book expected = ExpectedBookResults.expectedBook();

        // When
        Mockito.when(mockedRepository.findById(1L)).thenReturn(
                Optional.of(expected).stream().findFirst());
        Book actual = bookController.readBookById(1L);

        // Then
        assertEquals(actual, expected, "Books differ when returning by ID.");
    }
}
