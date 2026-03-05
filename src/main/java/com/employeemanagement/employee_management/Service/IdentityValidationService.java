package com.employeemanagement.employee_management.Service;

import org.springframework.stereotype.*;

@Service
public class IdentityValidationService {

    public void validateemployeeIdentity(Long EmployeeId) {

        if (EmployeeId == null) {

            throw new IllegalArgumentException("Employee Id cannot be null");

        }

        System.out.println("Employee Id is valid:" + EmployeeId);
    }

}