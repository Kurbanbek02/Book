package com.kuma.book.service.impl;

import com.kuma.book.dto.model.Auth;
import com.kuma.book.dto.model.Book;
import com.kuma.book.repository.BookRepository;
import com.kuma.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public Book save(Book book){
        return repository.save(book);
    }
    public List<Book> findAll(){
        return repository.findAll();
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Book findById(Long id){
        return repository.findById(id).get();
    }

    public List<Book> findAllByAuthId(Long id){
        return repository.findAllByAuthId(id);
    }

    public Long findHighestSold(){
        return repository.findHighestSold();
    }

    public Book findLowStock(){
        return repository.findLowStock().get();
    }

    public Long findBookByName(String name){
        return repository.findBookByName(name);
    }
    public List<Auth> findBookByAuthHighestSold(){

        return repository.findBookByAuthHighestSold();
    }
    public Double getSum(){
        return repository.getSum();
    }
}
