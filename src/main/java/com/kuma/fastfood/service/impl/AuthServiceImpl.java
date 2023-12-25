package com.kuma.fastfood.service.impl;

import com.kuma.fastfood.dto.model.Auth;
import com.kuma.fastfood.dto.model.Book;
import com.kuma.fastfood.repository.AuthRepository;
import com.kuma.fastfood.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository repository;

    public Auth save(Auth auth){
        return repository.save(auth);
    }
    public List<Auth> findAll(){
        return repository.findAll();
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Auth findById(Long id){
        return repository.findById(id).get();
    }
}
