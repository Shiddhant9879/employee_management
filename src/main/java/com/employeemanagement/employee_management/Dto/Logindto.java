package com.employeemanagement.employee_management.Dto;

public class Logindto {

    private String email;
    private String password;

    public void setemail(String email) {

        this.email = email;
    }

    public void setpassword(String password) {

        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public String getPassword() {

        return password;
    }

}
