package com.employeemanagement.employee_management.Service;

import com.employeemanagement.employee_management.Repository.employeeRepository;
import com.employeemanagement.employee_management.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityValidationService {

    @Autowired
    private employeeRepository employeeRepository;

    public Employee validateEmployee(String email) {

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee does not exist");
        }

        return employeeOptional.get();
    }
}