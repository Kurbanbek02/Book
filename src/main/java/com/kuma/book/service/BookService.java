package com.kuma.book.service;

import com.kuma.book.dto.model.Auth;
import com.kuma.book.dto.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
     List<Book> findAll();
     void deleteById(Long id);
     Book findById(Long id);
     List<Book> findAllByAuthId(Long id);
     List<Book> findHighestSold();

     List<Book> findLowStock();
     Long findBookByName(String name);
     List<Auth> findBookByAuthHighestSold();

     Double getSum();
}
