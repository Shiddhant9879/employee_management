package com.employeemanagement.employee_management.Service;

import com.employeemanagement.employee_management.Repository.EmployeeLifecycleRepository;
import com.employeemanagement.employee_management.model.EmployeeLifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LifecycleValidationService {

    @Autowired
    private employeeLifecycleRepository repo;

    public void validateEmployeeLifecycle(Long employeeId) {

        // Edge case validation
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }

        // Repository lookup
        Optional<EmployeeLifecycle> optionalEmployee = repo.findByEmployeeId(employeeId);

        if (optionalEmployee.isEmpty()) {
            throw new IllegalArgumentException("Employee lifecycle record not found");
        }

        EmployeeLifecycle lifecycle = optionalEmployee.get();
        String status = lifecycle.getLifecycleStatus();

        // Allow only ACTIVE employees
        if ("ACTIVE".equals(status)) {
            return;
        }

        // Other lifecycle cases
        if ("TERMINATED".equals(status)) {
            throw new IllegalStateException("Employee has been terminated");
        }

        if ("SUSPENDED".equals(status)) {
            throw new IllegalStateException("Employee has been suspended");
        }

        if ("ON_LEAVE".equals(status)) {
            throw new IllegalStateException("Employee is currently on leave");
        }

        // Unknown status safety check
        throw new IllegalStateException("Invalid lifecycle status");
    }
}