package com.kuma.fastfood.service;

import com.kuma.fastfood.dto.model.Auth;
import com.kuma.fastfood.dto.model.Customer;
import com.kuma.fastfood.dto.model.Order;

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
