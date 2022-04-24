package com.codegym.dto;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Immutable
@Table(name = "customer_use_service")
public class CustomerUsedServiceDto {
    @Id
    private Integer id;
    @NotBlank
    @Column(name = "name")
    private String customerName;
    @NotBlank
    @Column(name = "Customer_code")
    private String CustomerCode;
    @NotBlank
    @Column(name = "contract_code")
    private String contractCode;
    @Column(name = "service_id")
    private Integer serviceId;
    @NotBlank
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "service_code")
    private String serviceCode;
    @NotBlank
    @Column(name = "attach_service_name")
    private String attachServiceName;
    @NotBlank
    @Column(name = "quantity")
    private String quality;
    @NotBlank
    @Column(name = "unit")
    private String unit;
    @NotBlank
    @Column(name = "total_payment")
    private String totalPayment;

    public CustomerUsedServiceDto() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

}
