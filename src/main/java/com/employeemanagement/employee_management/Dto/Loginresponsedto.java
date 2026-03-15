package com.employeemanagement.employee_management.Dto;

public class Loginresponsedto {

      private String Accesstoken;
      private Long employeeId;
      private String role;

      public void setAccesstoken(String Accesstoken) {

            this.Accesstoken = Accesstoken;

      }

      public void setemployeeId(Long employeeId) {

            this.employeeId = employeeId;
      }

      public void setrole(String role) {

            this.role = role;
      }

      public String getAccesstoken() {

            return Accesstoken;
      }

      public Long getemployeeId() {

            return employeeId;
      }

      public String getrole() {

            return role;
      }

}