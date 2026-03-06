package com.employeemanagement.employee_management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "role_assignments")
public class RoleAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleAssignmentId;

    private Long employeeId;

    private String roleName;

    private Long assignedBy;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean isActive;

    // Getters

    public Long getRoleAssignmentId() {
        return roleAssignmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getRoleName() {
        return roleName;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    // Setters

    public void setRoleAssignmentId(Long roleAssignmentId) {
        this.roleAssignmentId = roleAssignmentId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}