package com.employeemanagement.employee_management.Service;

import com.employeemanagement.employee_management.Repository.RoleAssignmentRepository;
import com.employeemanagement.employee_management.model.RoleAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoleValidationService {

  @Autowired
  private RoleAssignmentRepository roleRepo;

  public void validateRole(Long employeeId, String requiredRole) {

    // 1️⃣ Basic validation
    if (employeeId == null || employeeId <= 0) {
      throw new IllegalArgumentException("Invalid employee ID");
    }

    if (requiredRole == null || requiredRole.isBlank()) {
      throw new IllegalArgumentException("Required role cannot be null or empty");
    }

    // 2️⃣ Fetch roles from repository
    List<RoleAssignment> roles = roleRepo.findByEmployeeId(employeeId);

    if (roles.isEmpty()) {
      throw new IllegalStateException("Employee has no role assigned");
    }

    LocalDate today = LocalDate.now();

    // 3️⃣ Validate each role
    for (RoleAssignment role : roles) {

      if (!role.getRoleName().equalsIgnoreCase(requiredRole)) {
        continue;
      }

      if (!role.getIsActive()) {
        continue;
      }

      if (role.getStartDate() != null && today.isBefore(role.getStartDate())) {
        continue;
      }

      if (role.getEndDate() != null && today.isAfter(role.getEndDate())) {
        continue;
      }

      // If all checks pass → role is valid
      return;
    }

    throw new IllegalStateException("Employee does not have a valid role: " + requiredRole);
  }
}