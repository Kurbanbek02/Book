package com.kuma.book.service.impl;

import com.kuma.book.dto.model.Auth;
import com.kuma.book.repository.AuthRepository;
import com.kuma.book.service.AuthService;
import lombok.RequiredArgsConstructor;
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
