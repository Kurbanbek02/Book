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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price = 0D;
    private Long stock = 0L;
    private Long sold = 0L;
    private Double income = 0.0;



    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Auth> auths = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(
            name = "Book_Order",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private List<Order> orders = new ArrayList<>();

    public void addStock(Long stock){
        this.stock += stock;
    }
    public void addAuth(Auth auth){
        if (auths == null) {
            this.auths = new ArrayList<>();
        }
        this.auths.add(auth);
        auth.addBook(this);
    }

    public void addOrder(Order order){
        if (orders == null) {
            this.orders = new ArrayList<>();
        }
        this.stock--;
        this.sold++;
        this.income += this.price;
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sold=" + sold +
                ", income=" + income +
                '}';
    }
}
