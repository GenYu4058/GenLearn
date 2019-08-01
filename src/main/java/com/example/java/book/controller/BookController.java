package com.example.java.book.controller;

import com.example.java.book.dao.BookDao;
import com.example.java.book.model.Book;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Book Controller类
 *
 * @author GenYu
 * @date 2019/01/30
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/getallbook", method = RequestMethod.POST)
    public List<Book> findAllBook(){
        return bookDao.findAllBook();
    }

    @RequestMapping(value = "/getBookByTime", method = RequestMethod.POST)
    public JSONObject getBookByTime(
            @RequestBody JSONObject jsonBody){
        String bookType = jsonBody.getString("bookType");

        String timeStirng = jsonBody.getString("time");


        JSONObject json = new JSONObject();
        json.put("bookType",bookType);
        json.put("time",timeStirng);
        List<Book> list = bookDao.findAllBook();
        json.put("book",list);

        return json;
    }

}

