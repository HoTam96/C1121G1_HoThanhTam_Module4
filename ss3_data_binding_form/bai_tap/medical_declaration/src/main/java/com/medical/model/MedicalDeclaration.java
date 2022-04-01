package com.medical.model;

public class MedicalDeclaration {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String id_card;
    private String travelInformation;
    private String vehicleNumber;
    private Integer seatingNumber;
    private String startDate;
    private String endDate;
    private String description;
    private String address;
    private String phoneNumber;
    private String email;

    public MedicalDeclaration(Integer id, String name, String dateOfBirth, String gender, String nationality, String id_card, String travelInformation, String vehicleNumber, Integer seatingNumber, String startDate, String endDate, String description, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.id_card = id_card;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seatingNumber = seatingNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public MedicalDeclaration() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Integer getSeatingNumber() {
        return seatingNumber;
    }

    public void setSeatingNumber(Integer seatingNumber) {
        this.seatingNumber = seatingNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
