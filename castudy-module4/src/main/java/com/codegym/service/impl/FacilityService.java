package com.codegym.service.impl;

import com.codegym.model.service.RentType;
import com.codegym.model.service.ServiceType;
import com.codegym.repository.IFacilityRepository;
import com.codegym.repository.IRenTypeRepository;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Autowired
    private IRenTypeRepository iRenTypeRepository;

    @Override
    public List<ServiceType> getAll() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public List<RentType> getAllRenType() {
        return iRenTypeRepository.findAll();
    }

    @Override
    public void save(com.codegym.model.service.Service service) {
        iFacilityRepository.save(service);
    }

    @Override
    public List<com.codegym.model.service.Service> findByAllService() {
        return iFacilityRepository.findAll();
    }
}
