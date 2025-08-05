package com.shankrish.departmentservice.mapper;

import com.shankrish.departmentservice.entity.Department;
import com.shankrish.departmentservice.payload.DepartmentDTO;
import org.springframework.beans.BeanUtils;

public class DepartmentMapper {
    public static DepartmentDTO toDepartmentDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentDTO);

        return departmentDTO;
    }

    public static Department toDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);

        return department;
    }

}
