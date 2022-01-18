package com.github.dawidkolcz.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Test(groups = "integrations")
@SpringBootTest
public class BookControllerItegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookController bookController;

    @BeforeClass
    public void setupDatabase() throws Exception {
        springTestContextPrepareTestInstance();
        for (Book b :
                ExpectedBookResults.expectedList()) {
            bookRepository.save(b);
        }
    }

    @Test
    public void testShouldReturnAllBooks() {
        // Given
        List<Book> expected = ExpectedBookResults.expectedList();

        // When
        List<Book> actual = bookController.readAll();

        // Then
        assertEquals(actual, expected, "Books differs from database.");
    }

    @Test
    public void testShouldCreateANewBook() {
        // Given
        Book expected = ExpectedBookResults.expectedBook();

        // When
        Book actual = bookController.createBook(expected);

        // Then
        assertEquals(actual, expected, "Book created differ.");

        // Cleanup
        bookController.deleteBook(actual.getId());
    }

    @Test
    public void testShouldGetBookById() {
        // Given
        Book expected = ExpectedBookResults.expectedList().get(0);

        // When
        Book actual = bookController.readBookById(1L);

        // Then
        assertEquals(actual, expected, "Books differ when returning by ID.");
    }

    @Test
    public void testShouldGetEmptyBook(){
        // Given
        Book expected = ExpectedBookResults.expectedEmptyBook();

        // When
        Book actual = bookController.readBookById(0L);

        // Then
        assertEquals(actual, expected, "Should return empty book, when no such ID.");
    }
}
