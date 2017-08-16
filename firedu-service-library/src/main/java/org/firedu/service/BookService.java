package org.firedu.service;

import org.firedu.entity.Book;
import org.firedu.repository.BookRepository;
import org.firedu.service.bookparser.BookParser;
import org.firedu.service.bookparser.ShiJingParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @author Wu Jing
 * @date 2017-08-10 22:37:31
 */

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }
    
    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book parseBook() {
        BookParser parser = new ShiJingParser();
        return parser.doParse("/Users/wujing/Desktop/图书/Shi Jing - Yi Ming");
    }

}
