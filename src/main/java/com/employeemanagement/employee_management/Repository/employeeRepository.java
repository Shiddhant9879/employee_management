package com.employeemanagement.employee_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.employee_management.model.Employee;
import java.util.Optional;

public interface employeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

}
