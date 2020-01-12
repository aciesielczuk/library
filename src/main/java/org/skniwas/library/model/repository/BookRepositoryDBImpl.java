package org.skniwas.library.model.repository;

import org.hibernate.Session;
import org.skniwas.library.model.Book;
import org.skniwas.library.utils.HibernateUtil;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile("prod")
public class BookRepositoryDBImpl implements BookRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public void addBook(String name, String title, boolean availability) {
        var transaction = session.beginTransaction();
        Book book = new Book(name, title, availability);
        try {
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void addBook(Book book) {
        var transaction = session.beginTransaction();
        try {
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deleteBook(int id) {
        var transaction = session.beginTransaction();
        session.delete(session.get(Book.class, id));
        transaction.commit();
    }

    @Override
    public Book getBook(int id) {
        var transaction = session.beginTransaction();
        Book result = session.get(Book.class, id);
        transaction.commit();
        return result;
    }

    @Override
    public Collection<Book> getAllBooks() {
        var transaction = session.beginTransaction();
        List<Book> result = session.createQuery("from Book", Book.class).getResultList();
        transaction.commit();
        return result;
    }

    @Override
    public void build() {

    }

    @Override
    public Collection<Book> search(SearchCriteria searchCriteria) {
        List<Book> filteredList = new ArrayList<>();
        if (searchCriteria.getSearchBy().equals("author")) {
            filteredList = filterByAuthor(searchCriteria);
        } else if (searchCriteria.getSearchBy().equals("title")) {
            filteredList = filterByTitle(searchCriteria);
        }
        return filteredList;
    }

    private List<Book> filterByAuthor(SearchCriteria searchCriteria) {
        List<Book> books = (List<Book>) getAllBooks();
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(searchCriteria.getQuery()))
                .collect(Collectors.toList());
    }

    private List<Book> filterByTitle(SearchCriteria searchCriteria) {
        List<Book> books = (List<Book>) getAllBooks();
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(searchCriteria.getQuery()))
                .collect(Collectors.toList());
    }

}
