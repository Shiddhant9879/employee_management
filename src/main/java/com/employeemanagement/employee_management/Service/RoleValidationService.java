package com.employeemanagement.employee_management.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class RoleValidationService {

  public void validateRole(Long employeeId, String requiredRole) {

    // 1️⃣ Basic validation
    if (employeeId == null || employeeId <= 0) {
      throw new IllegalArgumentException("Invalid employee ID");
    }

    if (requiredRole == null || requiredRole.isBlank()) {
      throw new IllegalArgumentException("Required role cannot be null or empty");
    }

    // 2️⃣ Temporary simulation of role assignment
    String assignedRole = "ADMIN";
    boolean isActive = true;
    LocalDate startDate = LocalDate.of(2024, 1, 1);
    LocalDate endDate = null; // ongoing role

    LocalDate today = LocalDate.now();

    // 3️⃣ Role existence check
    if (!assignedRole.equalsIgnoreCase(requiredRole)) {
      throw new IllegalStateException(
          "Employee does not have required role: " + requiredRole);
    }

    // 4️⃣ Active flag check
    if (!isActive) {
      throw new IllegalStateException("Role assignment is not active");
    }

    // 5️⃣ Time window validation
    if (startDate == null) {
      throw new IllegalStateException("Start date cannot be null");
    }

    if (today.isBefore(startDate)) {
      throw new IllegalStateException("Role not yet active");
    }

    if (endDate != null && today.isAfter(endDate)) {
      throw new IllegalStateException("Role assignment expired");
    }

    System.out.println("Role validation successful for employee ID " + employeeId);
  }
}