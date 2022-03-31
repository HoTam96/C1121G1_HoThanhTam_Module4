package com.email.service.impl;

import com.email.model.Email;
import com.email.service.IEmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    private static List<Email> emailList = new ArrayList<>();

    static {

        Email email1 = new Email("Englisst", 10, false, "thu");
        Email email2 = new Email("Vietnamess", 10, false, "tam");
        Email email3 = new Email("japanese", 10, false, "tuan");
        Email email4 = new Email("chinese", 10, false, "viet");
        emailList.add(email1);
        emailList.add(email2);
        emailList.add(email3);
        emailList.add(email4);
    }


    @Override
    public List<Email> getListAll() {
        return emailList;
    }

    @Override
    public void update(Email email) {
        emailList.add(email);
    }
}
