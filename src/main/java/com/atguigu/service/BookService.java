package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author linzihao
 * @create 2022-10-30-19:47
 */
@Service
public class BookService {

    // @Qualifier("bookDao2")
    // @Autowired(required = false)
    // @Resource(name = "bookDao")
    private BookDao bookDao2;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao2 +
                '}';
    }

    private void print(){
        System.out.println(bookDao2);
    }

}
