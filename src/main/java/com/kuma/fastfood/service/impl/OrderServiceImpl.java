package com.kuma.fastfood.service.impl;

import com.kuma.fastfood.dto.model.Book;
import com.kuma.fastfood.dto.model.Order;
import com.kuma.fastfood.repository.OrderRepository;
import com.kuma.fastfood.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
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
