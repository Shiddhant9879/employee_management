package com.employeemanagement.employee_management.controller;

import com.employeemanagement.employee_management.Service.IdentityValidationService;
import com.employeemanagement.employee_management.Service.LifecycleValidationService;
import com.employeemanagement.employee_management.Service.RoleValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")

public class employeecontroller {

    @Autowired
    private IdentityValidationService identityService;

    @Autowired
    private LifecycleValidationService lifecycleService;

    @Autowired
    private RoleValidationService roleService;

    @PostMapping("/validate-identity")

    public String validateIdentity(@RequestParam String email) {
        identityService.validateEmployee(email);
        return "Identity validated";
    }

    @PostMapping("/validate-lifecycle")

    public String validateLifecycle(@RequestParam Long employeeId) {
        lifecycleService.validateEmployeeLifecycle(employeeId);
        return "Lifecycle validated";
    }

    @PostMapping("/validate-role")

    public String validateRole(@RequestParam Long employeeId,
            @RequestParam String role) {

        roleService.validateRole(employeeId, role);

        return "Role validated";
    }
}