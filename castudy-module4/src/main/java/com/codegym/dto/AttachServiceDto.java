package com.codegym.dto;

import javax.validation.constraints.NotNull;

public class AttachServiceDto {

    private Integer id;
    @NotNull
    private String attachServiceName;
    @NotNull
    private Double attachServiceCost;
    @NotNull
    private String unit;

    private String status;

    public AttachServiceDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
