package com.kuma.fastfood.repository;

import com.kuma.fastfood.dto.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth,Long> {


}
