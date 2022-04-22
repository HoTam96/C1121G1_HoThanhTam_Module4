package com.codegym.service;

import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;

import java.util.List;

public interface IFacilityService {
    List<ServiceType> getAll();

    List<RentType> getAllRenType();

    void save(Service service);
    List<Service>findByAllService();
}
