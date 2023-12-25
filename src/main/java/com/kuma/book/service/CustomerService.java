package com.kuma.book.service;

import com.kuma.book.dto.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer);
    public List<Customer> findAll();
    public void deleteById(Long id);
    public Customer findById(Long id);

    Long findHighestAmountOfPurchases();

    List<Customer> findAllBySold();
    List<Customer> findAllByNoSold();

    Customer getHighestSold();
}
