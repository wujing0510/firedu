package org.firedu.service.fallback;

import org.firedu.entity.BookVo;
import org.firedu.service.BookService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookServiceFallback implements BookService {

    @Override
    public BookVo findById(String id) {
        BookVo bookVo = new BookVo();
        bookVo.setId(id);
        bookVo.setName("error");
        return null;
    }

    @Override
    public List<BookVo> findByIds(String ids) {

        BookVo bookVo = new BookVo();
        bookVo.setId(ids);
        bookVo.setName("error");

        List<BookVo> books = new ArrayList(1);
        books.add(bookVo);

        return books;
    }
}
