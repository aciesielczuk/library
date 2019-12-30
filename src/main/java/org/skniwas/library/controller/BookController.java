package org.skniwas.library.controller;


import org.skniwas.library.model.Book;
import org.skniwas.library.service.BookService;
import org.skniwas.library.utils.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getBook(@RequestParam int id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "book.html";
    }


    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "books.html";
    }


    @PostMapping(value = "/books")
    public String saveBook(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.toString());
            }
            return "bookform.html";
        } else {
            bookService.saveBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping("/newbook")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "bookform.html";
    }

    @RequestMapping(value = "/book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public List<Book> search(SearchCriteria searchCriteria) {
//        return bookService.search(searchCriteria);
//    }

    @GetMapping()
    public List<Book> search(SearchCriteria searchCriteria) {
        return bookService.search(searchCriteria);
    }


    @RequestMapping("/search")
    public String searchBooks(Model model, SearchCriteria searchCriteria) {
        model.addAttribute("search", searchCriteria);
        return "search.html";
    }


}
