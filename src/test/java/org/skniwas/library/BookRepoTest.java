package org.skniwas.library;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skniwas.library.model.Book;
import org.skniwas.library.model.repository.BookRepositoryImpl;
import org.skniwas.library.service.BookService;
import org.skniwas.library.utils.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

public class BookRepoTest {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Test
    public void searchTestByAuthor() {
        List<Book> expectedList = new ArrayList<>();
        bookRepository.build();
        expectedList.add(new Book("Martin", "Clean Code", true));
        expectedList.add(new Book("Martin", "Clean Architecture", true));

        Assertions.assertEquals(expectedList.toString(), bookRepository.search(new SearchCriteria("Martin", "author")).toString());
    }


    @Test
    public void searchTestByTitle() {
        List<Book> expectedList = new ArrayList<>();
        bookRepository.build();
        expectedList.add(new Book("Horstmann", "Core Java", true));

        Assertions.assertEquals(expectedList.toString(), bookRepository.search(new SearchCriteria("Core Java", "title")).toString());
    }


}
