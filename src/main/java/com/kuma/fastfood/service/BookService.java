package com.kuma.fastfood.service;

import com.kuma.fastfood.dto.model.Auth;
import com.kuma.fastfood.dto.model.Book;
import com.kuma.fastfood.dto.model.Customer;
import com.kuma.fastfood.dto.model.Order;

import java.util.List;

public interface BookService {
    Book save(Book book);
     List<Book> findAll();
     void deleteById(Long id);
     Book findById(Long id);
     List<Book> findAllByAuthId(Long id);
     Long findHighestSold();

     Book findLowStock();
     Long findBookByName(String name);
     List<Auth> findBookByAuthHighestSold();

     Double getSum();
}
