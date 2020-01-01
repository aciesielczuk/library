package org.skniwas.library.model.repository;

import org.skniwas.library.model.Book;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository {

    void addBook(String name, String title, boolean availability);

    void addBook(Book book);

    void deleteBook(int id);

    Book getBook(int id);

    Collection<Book> getAllBooks();

    void build();

    Collection<Book> search(SearchCriteria searchCriteria);

}

