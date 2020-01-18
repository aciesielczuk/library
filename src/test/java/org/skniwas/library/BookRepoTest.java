package org.skniwas.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skniwas.library.model.Book;
import org.skniwas.library.model.repository.BookRepositoryImpl;
import org.skniwas.library.utils.SearchCriteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepoTest {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @BeforeEach
    public void setUp() {
        bookRepository.build();
    }

    @Test
    public void searchTestByAuthor() {
        // Given
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(new Book("Martin", "Clean Code", true));
        expectedList.add(new Book("Martin", "Clean Architecture", true));

        // When
        Collection<Book> resultList = bookRepository.search(new SearchCriteria("Martin", "author"));

        // Then
        assertEquals(expectedList.toString(), resultList.toString());
    }


    @Test
    public void searchTestByTitle() {
        // Given
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(new Book("Horstmann", "Core Java", true));

        // When
        Collection<Book> resultList = bookRepository.search(new SearchCriteria("Core Java", "title"));

        // Then
        assertEquals(expectedList.toString(), resultList.toString());
    }

}
