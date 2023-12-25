package com.kuma.fastfood.service;

import com.kuma.fastfood.dto.model.Auth;
import com.kuma.fastfood.dto.model.Order;

import java.util.List;

public interface AuthService {
    public Auth save(Auth auth);
    public List<Auth> findAll();
    public void deleteById(Long id);
    public Auth findById(Long id);
}
