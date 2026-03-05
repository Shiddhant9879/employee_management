package com.employeemanagement.employee_management.Dto;

public class Loginresponsedto {

      private String Accesstoken;
      private String employeeId;
      private String role;

      public void setAccesstoken(String Accesstoken) {

            this.Accesstoken = Accesstoken;

      }

      public void setemployeeId(String employeeId) {

            this.employeeId = employeeId;
      }

      public void setrole(String role) {

            this.role = role;
      }

      public String getAccesstoken() {

            return Accesstoken;
      }

      public String getemployeeId() {

            return employeeId;
      }

      public String getrole() {

            return role;
      }

}