package com.employeemanagement.employee_management.service;

import com.employeemanagement.employee_management.Repository.employeeRepository;
import com.employeemanagement.employee_management.model.Employee;
import com.employeemanagement.employee_management.Dto.Logindto;

import org.echocat.jomon.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class userloginService {

    @Autowired

    private EmployeeRepository repo;

    // edge case 1: null values

    public void barriercheck(Logindto request) {

        if (request == null || request.getemail() == null || request.getpassword() == null ||
                request.getemail().isBlank() || request.getpassword().isBlank()) {

            throw new IllegalArgumentException("feilds cannt be null");

        }

        // case 2: logic now to verify if the email and password exist or not

        Employee user = repo.findByEmail(request.getEmail());

    }

}