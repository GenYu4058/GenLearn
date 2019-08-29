package com.example.java.book.mapper;

import com.example.java.book.model.Book;

import java.util.List;

/**
 *Book映射数据库接口
 *
 * @author GenYu
 * @date 2019/01/29
 */
public interface BookMapper {

    /**
     * 查找所有book方法
     *
     * @return List<Book>
     */
     List<Book> findAllBook();

    /**
     * 单个Book添加方法
     * @param book 实体
     * @return 添加成功的状态（0/1）
     */
     void addBook(Book book);

    /**
     *单个Book更新方法
     * @param book 实体
     * @return 更新成功的状态（0/1）
     */
     int updataBook(Book book);

    /**
     * 通过book编号查找book
     * @param number book的编号
     * @return book
     */
     Book findBookByNumber(String number);

    /**
     * 通过book编号删除book
     * @param number book编号
     * @return 删除成功的状态（0/1）
     */
     int deleteBook(String number);
}





















