package com.codegym.service.impl;

import com.codegym.controller.ContractDetailController;
import com.codegym.model.detail.AttachService;
import com.codegym.model.detail.ContractDetail;
import com.codegym.repository.IAttachRepository;
import com.codegym.repository.IContractDetailRepository;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Autowired
    private IAttachRepository iAttachRepository;

    @Override
    public List<ContractDetail> findAllContractDetail() {
       return iContractDetailRepository.findAll();
    }

    @Override
    public List<AttachService> finAllAttachService() {
        return iAttachRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);

    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContractDetailRepository.findById(id).get();
    }


}
