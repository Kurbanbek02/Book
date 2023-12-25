package com.kuma.fastfood.repository;

import com.kuma.fastfood.dto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

  @Query(" SELECT max(c.amountOfPurchases) FROM Customer c")
  Long findHighestAmountOfPurchases();
  @Query("select c from Customer c where c.amountOfPurchases = (select max (cu.amountOfPurchases)from Customer cu)")
  Optional<Customer> getHighestSold();
}
