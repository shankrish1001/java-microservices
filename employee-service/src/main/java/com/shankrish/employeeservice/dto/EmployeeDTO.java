package com.shankrish.employeeservice.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long empId;
    private String name;
    private String email;
    private DepartmentDTO department;
}
