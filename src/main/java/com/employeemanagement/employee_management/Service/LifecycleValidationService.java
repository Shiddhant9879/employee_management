package com.employeemanagement.employee_management.service;

import com.employeemanagement.employee_management.repository.EmployeeLifecycleRepository;
import com.employeemanagement.employee_management.model.EmployeeLifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LifecycleValidationService {

    @Autowired
    private EmployeeLifecycleRepository repo;

    public void validateEmployeeLifecycle(Long employeeId) {

        // edge case validation
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }

        // repository lookup
        Optional<EmployeeLifecycle> optionalEmployee = repo.findByEmployeeId(employeeId);

        if (optionalEmployee.isEmpty()) {
            throw new IllegalArgumentException("Employee lifecycle record not found");
        }

        EmployeeLifecycle lifecycle = optionalEmployee.get();

        // lifecycle rule
        if (!"ACTIVE".equals(lifecycle.getLifecycleStatus())) {
            throw new IllegalStateException("Employee is not active");
        }
    }
}