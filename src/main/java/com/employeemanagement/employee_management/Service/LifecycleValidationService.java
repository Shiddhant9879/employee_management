package com.employeemanagement.employee_management.service;

import org.springframework.stereotype.Service;

@Service
public class LifecycleValidationService {

    public void validateEmployeeLifecycle(Long EmployeeId) {

        if (EmployeeId == null || EmployeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }

        // Temporary simulation
        String currentState = "ACTIVE";

        if (!"ACTIVE".equals(currentState)) {
            throw new IllegalStateException(
                    "Employee is not in ACTIVE lifecycle state");
        }

        System.out.println("Employee lifecycle is valid for employee ID " + EmployeeId);
    }
}