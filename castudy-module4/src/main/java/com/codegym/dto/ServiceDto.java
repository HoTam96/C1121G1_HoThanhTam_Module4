package com.codegym.dto;

import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import com.codegym.service.IFacilityService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.Column;
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
    @Pattern(regexp = "^$|(([1-9](\\.?[0-9]+)?)|0\\.[1-9]+)",message = "diện tích sử dụng phải là số")
    private String serviceCost;
    @Pattern(regexp = "^(^$|([0]*[1-9][0-9]*)|[1-9][0-9]*$)",message = "chi phí phải là số")
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOther;
    @NotBlank(message = "không để trống")
    @Pattern(regexp = "^$|(([1-9](\\.?[0-9]+)?)|0\\.[1-9]+)")
    private String poolArea;
    @NotNull(message = "không được để trống")
    @Pattern(regexp = "^(^$|([0]*[1-9][0-9]*)|[1-9][0-9]*$)", message = "số tầng phải là số dương")
    private String numberFloor;
    private RentType rentType;
    private ServiceType serviceType;
    private String freeService;
    private IFacilityService iFacilityService;

    public ServiceDto() {
    }

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

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
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

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
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
