package com.example.java.book.dao.impl;

import com.example.java.book.mapper.BookMapper;
import com.example.java.book.model.Book;
import com.example.java.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book Dao实现类
 *
 * @author GenYu
 * @date 2019/01/30
 */
@Service
public class BookDaoImpl implements BookDao {
    @Autowired()
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBook(){
        return bookMapper.findAllBook();
    }

    @Override
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

    @Override
    public int updataBook(Book book){
        return bookMapper.updataBook(book);
    }

    @Override
    public Book findBookByNumber(String number){
        return bookMapper.findBookByNumber(number);
    }

    @Override
    public int deleteBook(String number){
        return bookMapper.deleteBook(number);
    }

}
