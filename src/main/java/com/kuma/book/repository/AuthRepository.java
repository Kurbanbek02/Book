package com.kuma.book.repository;

import com.kuma.book.dto.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth,Long> {

}
