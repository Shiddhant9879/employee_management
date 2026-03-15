package com.employeemanagement.employee_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeemanagement.employee_management.model.EmployeeLifecycle;
import java.util.Optional;

public interface employeeLifecycleRepository extends JpaRepository<EmployeeLifecycle, Long> {

    Optional<EmployeeLifecycle> findByEmployeeId(Long employeeId);

}