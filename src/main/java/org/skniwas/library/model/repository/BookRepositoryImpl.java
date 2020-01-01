package org.skniwas.library.model.repository;

import org.skniwas.library.model.Book;
import org.skniwas.library.utils.IdGenerator;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private Map<Integer, Book> books = new HashMap<>();

    public BookRepositoryImpl() {
    }

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
    public Collection<Book> search(SearchCriteria searchCriteria) {
        ArrayList<Book> filteredList = new ArrayList<>();
        if (searchCriteria.getSearchBy().equals("author"))
            filteredList = (ArrayList<Book>) books.values()
                    .stream()
                    .filter(b -> b.getAuthor().equalsIgnoreCase(searchCriteria.getQuery()))
                    .collect(Collectors.toList());
        else if (searchCriteria.getSearchBy().equals("title"))
            filteredList = (ArrayList<Book>) books.values()
                    .stream()
                    .filter(b -> b.getTitle().equalsIgnoreCase(searchCriteria.getQuery()))
                    .collect(Collectors.toList());
        return filteredList;
    }

    @PostConstruct
    public void build() {
        addBook("Martin", "Clean Code", true);
        addBook("Walls", "Spring in action", true);
        addBook("Horstmann", "Core Java", true);
        addBook("Eckel", "Thinking in Java", true);
        addBook("Martin", "Clean Architecture", true);
    }


}
