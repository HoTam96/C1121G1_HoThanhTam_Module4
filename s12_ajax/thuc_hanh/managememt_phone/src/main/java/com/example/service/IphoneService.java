package com.example.service;

import com.example.model.Smartphone;

import java.util.Optional;

public interface IphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);


}
