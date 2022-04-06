package com.example.service;


import com.example.model.Customer;
import com.example.model.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {

    List<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void delete(Long id);


}
