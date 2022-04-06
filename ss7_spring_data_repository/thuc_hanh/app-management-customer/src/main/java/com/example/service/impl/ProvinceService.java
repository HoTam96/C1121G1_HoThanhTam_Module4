package com.example.service.impl;

import com.example.model.Province;
import com.example.repository.IProvinceRepository;
import com.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceService iCustomerService;
    @Autowired
    IProvinceRepository iCustomerRepository;


    @Override
    public List<Province> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        iCustomerRepository.save(province);

    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);

    }
}
