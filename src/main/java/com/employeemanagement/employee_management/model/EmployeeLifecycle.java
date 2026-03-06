package com.employeemanagement.employee_management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_lifecycle")
public class EmployeeLifecycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lifecycleId;

    private Long employeeId;

    private String lifecycleStatus;

    private Long assignedBy;

    private LocalDate assignedDate;

    // Getters

    public Long getLifecycleId() {
        return lifecycleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    // Setters

    public void setLifecycleId(Long lifecycleId) {
        this.lifecycleId = lifecycleId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }
}