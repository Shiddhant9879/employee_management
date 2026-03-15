package com.employeemanagement.employee_management.Service;

import com.employeemanagement.employee_management.Repository.employeeRepository;
import com.employeemanagement.employee_management.model.Employee;
import com.employeemanagement.employee_management.Dto.Logindto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userloginService {

    @Autowired
    private employeeRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee login(Logindto request) {

        // Edge case: null check
        if (request == null ||
                request.getemail() == null ||
                request.getPassword() == null ||
                request.getemail().isBlank() ||
                request.getPassword().isBlank()) {

            throw new IllegalArgumentException("Fields cannot be null or blank");
        }

        // find employee
        Employee employee = repo.findByEmail(request.getemail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // password verification
        if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return employee;
    }
}