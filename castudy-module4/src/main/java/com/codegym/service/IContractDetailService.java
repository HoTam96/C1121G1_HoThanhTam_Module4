package com.codegym.service;

import com.codegym.controller.ContractDetailController;
import com.codegym.model.detail.AttachService;
import com.codegym.model.detail.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAllContractDetail();

    List<AttachService> finAllAttachService();

    void save(ContractDetail contractDetail);

    ContractDetail findById(Integer id);

}
