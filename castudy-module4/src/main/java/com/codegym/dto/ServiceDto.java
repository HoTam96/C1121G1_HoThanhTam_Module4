package com.codegym.dto;

import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import com.codegym.service.IFacilityService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ServiceDto implements Validator {

    private Integer id;
    @NotBlank(message = "mã dịch vụ không được để trống")
    @Pattern(regexp = "^$|((HO-)[0-9]{4})")
    private String serviceCode;
    @NotBlank(message = "tên dịch vụ không được để trống")
    private String name;
    private Integer ServiceArea;
    @NotNull(message = "không được để trống")
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOther;
    private Double poolArea;
//    @NotNull(message = "không được để trống")
//    @Pattern(regexp = "^(^$|([0]*[1-9][0-9]*)|[1-9][0-9]*$)")
    private Integer numberFloor;
    private RentType rentType;
    private ServiceType serviceType;
    private String freeService;
    private IFacilityService iFacilityService;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServiceArea() {
        return ServiceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        ServiceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public IFacilityService getiFacilityService() {
        return iFacilityService;
    }

    public void setiFacilityService(IFacilityService iFacilityService) {
        this.iFacilityService = iFacilityService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        List<Service>serviceList = iFacilityService.findByAllService();
        for (Service element: serviceList) {
            if (element.getServiceCode().equals(serviceDto.serviceCode)){
                errors.rejectValue("serviceCode","service.code","mã dịch vụ đã tồn tại");
            }
        }


    }
}
