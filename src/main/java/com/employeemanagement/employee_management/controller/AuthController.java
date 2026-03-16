package com.employeemanagement.employee_management.controller;

import com.employeemanagement.employee_management.Dto.Logindto;
import com.employeemanagement.employee_management.Dto.Loginresponsedto;
import com.employeemanagement.employee_management.model.Employee;
import com.employeemanagement.employee_management.Service.userloginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private userloginService loginService;

    @PostMapping("/login")

    public Loginresponsedto login(@RequestBody Logindto request) {

        Employee employee = loginService.login(request);

        Loginresponsedto response = new Loginresponsedto();
        response.setemployeeId(employee.getEmployeeId());
        response.setrole("USER"); // temporary
        response.setAccesstoken("dummy_token");

        return response;
    }
}