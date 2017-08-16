package org.firedu.service;

import org.firedu.entity.Book;
import org.firedu.service.bookparser.BookParser;
import org.firedu.service.bookparser.ShiJingParser;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Wu Jing
 * @date 2017-08-10 22:37:31
 */

@Service
public class BookService {
    public Book parseBook() {
        BookParser parser = new ShiJingParser();
        return parser.doParse("/Users/wujing/Desktop/图书/Shi Jing - Yi Ming");
    }

}
