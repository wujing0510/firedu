package org.firedu.controller;

import org.firedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findById")
    public String findById(@RequestParam("id") String id, Model model){

        model.addAttribute("book", bookService.findById(id));

        System.out.println("hello wrold323");

        return "book/detail";
    }

}
