package org.skniwas.library.model.repository;

import org.skniwas.library.model.Book;
import org.skniwas.library.utils.IdGenerator;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository{

    private Map<Integer, Book> books = new HashMap<>();

    public BookRepositoryImpl() {}

    @Override
    public void addBook(String name, String title, boolean availability) {
        Book book = new Book(name, title, availability);
        int id = IdGenerator.getUniqueId();
        book.setId(id);
        books.put(id, book);
    }

    @Override
    public void addBook(Book book) {
        int id = IdGenerator.getUniqueId();
        book.setId(id);
        books.put(id, book);
    }

    @Override
    public void deleteBook(int id) {
        books.remove(id);
    }

    @Override
    public Book getBook(int id) {
        return books.get(id);
    }

    @Override
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    @Override
    public List<Book> search(SearchCriteria searchCriteria) {
        Predicate<Book> searchValue = null;
        if (searchCriteria.getSearchBy().equals("author"))
            searchValue = b -> b.getAuthor().equalsIgnoreCase(searchCriteria.getQuery());
        else if (searchCriteria.getSearchBy().equals("title"))
            searchValue = b -> b.getTitle().equalsIgnoreCase(searchCriteria.getQuery());
        return books.values().stream().filter(Objects.requireNonNull(searchValue)).collect(Collectors.toList());
    }


    @PostConstruct
    public void build () {
        addBook("Martin", "Clean Code", true);
        addBook("Walls", "Spring in action", true);
        addBook("Horstmann", "Core Java", true);
        addBook("Eckel", "Thinking in Java", true);
        addBook("Martin", "Clean Architecture", true);
    }


}
