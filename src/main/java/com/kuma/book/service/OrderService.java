package com.kuma.book.service;

import com.kuma.book.dto.model.Order;

import java.util.List;

public interface OrderService {
    public Order save(Order order);
    public List<Order> findAll();
    public void deleteById(Long id);
    public Order findById(Long id);
}
