package com.kuma.book.repository;

import com.kuma.book.dto.model.Auth;
import com.kuma.book.dto.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
   @Query("SELECT b from Book b inner join b.auths  a where a.id = :authId")
   List<Book> findAllByAuthId(Long  authId);
//
   @Query("select bo from Book bo where bo.income = (SELECT max(b.income) FROM Book b)")
   List<Book> findHighestSold();
//
   @Query(" SELECT b FROM Book b where b.stock = (select min(bo.stock) from Book bo)")
   List<Book> findLowStock();
//
   @Query("select b.sold from Book b where b.name = :name")
   Long findBookByName(String name);
//
   @Query("select b.auths from Book b where b.sold = (select max(bo.sold) from Book bo)")
   List<Auth> findBookByAuthHighestSold();

   @Query("select sum(b.income) from Book b")
   Double getSum();
}
