package com.email.service;

import com.email.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email>getListAll();
    void update (Email email);
}
