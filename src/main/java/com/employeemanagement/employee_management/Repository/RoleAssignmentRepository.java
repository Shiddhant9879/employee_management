package com.employeemanagement.employee_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.employeemanagement.employee_management.model.RoleAssignment;

public interface RoleAssignmentRepository extends JpaRepository<RoleAssignment, Long> {

    List<RoleAssignment> findByEmployeeId(Long employeeId);

}