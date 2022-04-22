package com.codegym.service;

import com.codegym.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findByAllContract();

    void save(Contract contract);
}
