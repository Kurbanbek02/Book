package com.kuma.book.service.impl;

import com.kuma.book.dto.model.Order;
import com.kuma.book.repository.OrderRepository;
import com.kuma.book.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Transactional
    public Order save(Order order){
        return repository.save(order);
    }
    public List<Order> findAll(){
        return repository.findAll();
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Order findById(Long id){
        return repository.findById(id).get();
    }
}
