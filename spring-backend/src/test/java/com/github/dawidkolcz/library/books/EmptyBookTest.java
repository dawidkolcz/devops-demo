package com.github.dawidkolcz.library.books;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * I know that we should not test trivial things, but I need some units test for this demo.
 *
 * @author DawidKolcz
 */

@Test(groups = "units")
public class EmptyBookTest {
    public void testCreateEmptyBook() {
        // Given
        Book expected = ExpectedBookResults.expectedEmptyBook();

        // When
        EmptyBook actual = new EmptyBook();

        // Then
        assertEquals(actual, expected, "Empty book should be empty.");
    }
}
