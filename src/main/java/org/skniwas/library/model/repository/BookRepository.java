package org.skniwas.library.model.repository;

import org.skniwas.library.model.Book;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Repository
public interface BookRepository {

    void addBook (String name, String title, boolean availability);

    void addBook(Book book);

    void deleteBook (int id);

    Book getBook (int id);

    Collection<Book> getAllBooks();

    void build ();

    List<Book> search(SearchCriteria searchCriteria);

}

