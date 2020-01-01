package org.skniwas.library.service;


import org.skniwas.library.model.Book;
import org.skniwas.library.model.repository.BookRepository;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    public BookService() {
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.getAllBooks());
    }

    public void saveBook(Book book) {
        bookRepository.addBook(book);
    }

    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    public Collection<Book> search(SearchCriteria searchCriteria) {
        return bookRepository.search(searchCriteria);
    }


}
