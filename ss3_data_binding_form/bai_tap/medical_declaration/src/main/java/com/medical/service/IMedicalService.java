package com.medical.service;

import com.medical.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalService {
    List<MedicalDeclaration>getAllList();
    void update(MedicalDeclaration medicalDeclaration);

}
