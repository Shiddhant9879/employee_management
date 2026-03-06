package com.employeemanagement.employee_management.service;

import org.springframework.stereotype.Service;

import com.employeemanagement.employee_management.Dto.Logindto;
import com.employeemanagement.employee_management.Dto.Loginresponsedto;

@Service

public class userloginService {

    public void Login(Logindto request) {

        if (request == null || request.getemail() == null || request.getpassword() == null) {

            throw new IllegalArgumentException("Invalid login request");
        }

        String storedemail = "sidryanite@gmail.com";
        String storedpassword = "123456";

        if (!storedpassword.equals(request.getpassword()) || !storedemail.equals(request.getemail())) {

            throw new IllegalArgumentException("Invalid email or password");

        }
    }

}