package com.kuma.fastfood.dto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
            name = "Auth_Book",
            joinColumns = { @JoinColumn(name = "auth_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        if (books == null) {
            books = new ArrayList<>();
        }
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
