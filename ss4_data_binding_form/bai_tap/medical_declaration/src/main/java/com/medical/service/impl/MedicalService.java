package com.medical.service.impl;

import com.medical.model.MedicalDeclaration;
import com.medical.service.IMedicalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    private static List<MedicalDeclaration> list = new ArrayList<>();


    @Override
    public List<MedicalDeclaration> getAllList() {
        return list;
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        Integer id = (int) (1000 * Math.random());
        medicalDeclaration.setId(id);
        list.add(medicalDeclaration);

    }
}
