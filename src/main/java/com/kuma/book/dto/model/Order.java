package com.kuma.book.dto.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zakaz")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double sumOfPrice = 0d;


    @CreatedDate
    private LocalDateTime createOfDate = LocalDateTime.now();

    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany(mappedBy = "orders",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public void  addBook(Book book){
        if (books == null) {
            books = new ArrayList<>();
        }
        this.books.add(book);
        book.addOrder(this);
    }

    public void addCustomer(Customer customer,Double price){
       this.customer = customer;
       this.sumOfPrice = price;
       customer.addOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sumOfPrice=" + sumOfPrice +
                ", createOfDate=" + createOfDate +
                ", customer=" + customer +
                '}';
    }
}
