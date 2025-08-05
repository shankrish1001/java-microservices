package com.shankrish.employeeservice.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
    private Long deptId;
    private String deptName;
    private String deptDesc;
    private String deptCode;
}
