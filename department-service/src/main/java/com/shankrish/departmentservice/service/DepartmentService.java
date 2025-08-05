package com.shankrish.departmentservice.service;

import com.shankrish.departmentservice.payload.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO deparmentDTO);
    DepartmentDTO readDepartment(String deptCode);
    DepartmentDTO readDeptById(Long deptId);
    List<DepartmentDTO> findAllDepartment();
    DepartmentDTO updateDepartment(String deptCode, DepartmentDTO departmentDTO);
    void deleteDepartment(String deptCode);
}
