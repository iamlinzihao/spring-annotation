package com.atguigu.controller;

import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author linzihao
 * @create 2022-10-30-19:46
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
