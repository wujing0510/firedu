package org.firedu.web;

import org.apache.commons.lang.StringUtils;
import org.firedu.entity.Book;
import org.firedu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @RequestMapping("/findById")
    public Book findById(@RequestParam("id") String id) {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book[" + id + "]");
        return book;
    }

    @RequestMapping("/findByIds")
    public List<Book> findByIds(@RequestParam("ids") String ids) {

        Assert.hasText(ids, "params[ids] cannot be empty!");

        List<Book> books = bookRepository.findAll();

        return books;
    }
}
