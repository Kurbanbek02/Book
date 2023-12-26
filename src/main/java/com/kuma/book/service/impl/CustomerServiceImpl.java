package com.kuma.book.service.impl;

import com.kuma.book.dto.model.Customer;
import com.kuma.book.dto.model.Order;
import com.kuma.book.repository.CustomerRepository;
import com.kuma.book.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public Customer save(Customer customer){
        return repository.save(customer);
    }
    public List<Customer> findAll(){
        return repository.findAll();
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Customer findById(Long id){
        return repository.findById(id).get();
    }

   public  List<Customer> findAllBySold(){
        List<Customer> customers = repository.findAll();
       return customers.stream().filter(customer -> customer.getOrders().size()>0).toList();
    }

    public  List<Customer> findAllByNoSold(){
        List<Customer> customers = repository.findAll();
        return customers.stream().filter(customer -> customer.getOrders().size()<=0).toList();
    }

    public Customer getHighestSold(){
        List<Customer> customers = repository.findAll();
        Customer c = new Customer();
        double cMax = 0d;
        for (Customer customer : customers) {
            double sum = 0d;
            for (Order order : customer.getOrders()) {
                   sum +=order.getSumOfPrice();
                }
            if(cMax<sum){
                c = customer;
            }
        }
        return c;
    }
}
