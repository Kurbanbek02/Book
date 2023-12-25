package com.kuma.book.dto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy="customer",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();


    public void addOrder(Order order){
        if (orders == null) {
            orders = new ArrayList<>();
        }
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
