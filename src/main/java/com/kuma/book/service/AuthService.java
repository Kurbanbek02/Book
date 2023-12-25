package com.kuma.book.service;

import com.kuma.book.dto.model.Auth;

import java.util.List;

public interface AuthService {
    public Auth save(Auth auth);
    public List<Auth> findAll();
    public void deleteById(Long id);
    public Auth findById(Long id);
}
