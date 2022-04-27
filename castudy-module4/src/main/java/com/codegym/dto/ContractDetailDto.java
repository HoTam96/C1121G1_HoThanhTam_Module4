package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.detail.AttachService;

import javax.validation.constraints.NotNull;

public class ContractDetailDto {

    private Integer id;
    @NotNull
    private String quantity;

    private Contract contract;

    private AttachService attachService;

    public ContractDetailDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
