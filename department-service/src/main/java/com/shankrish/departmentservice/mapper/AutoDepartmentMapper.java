package com.shankrish.departmentservice.mapper;

import com.shankrish.departmentservice.entity.Department;
import com.shankrish.departmentservice.payload.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper INSTANCE = Mappers.getMapper(AutoDepartmentMapper.class);

    @Mapping(source = "deptId", target = "deptId")
    DepartmentDTO toDepartmentDTO(Department department);

    @Mapping(source = "deptId", target = "deptId")
    Department toDepartmentEntity(DepartmentDTO departmentDTO);

}
