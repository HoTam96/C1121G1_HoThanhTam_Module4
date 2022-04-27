package com.codegym.service;

public interface ICustomerUsedServiceDto {
    int getId();
    String getName();
    String getCustomerCode();
    String getContractCode();
    String getServiceName();
    int getServiceId();
    String getServiceCode();
    String getAttachServiceName();
    int getQuantity();
    String getUnit();
    double getTotalPayment();

}
