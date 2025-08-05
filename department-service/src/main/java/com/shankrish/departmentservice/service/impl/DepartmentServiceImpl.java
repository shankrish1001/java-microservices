package com.shankrish.departmentservice.service.impl;

import com.shankrish.departmentservice.entity.Department;
import com.shankrish.departmentservice.exception.DepartmentCodeDuplicateException;
import com.shankrish.departmentservice.exception.ResourceNotFoundException;
import com.shankrish.departmentservice.mapper.DepartmentMapper;
import com.shankrish.departmentservice.payload.DepartmentDTO;
import com.shankrish.departmentservice.repository.DepartmentRepository;
import com.shankrish.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private final String deptStr = "department";
    private final String codeStr = "code";

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO deparmentDTO) {
        Department department = DepartmentMapper.toDepartment(deparmentDTO);

        if (departmentRepository.findByDeptCode(department.getDeptCode()).isPresent()) {
            throw new DepartmentCodeDuplicateException(department.getDeptCode());
        }
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.toDepartmentDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO readDepartment(String deptCode) {
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new ResourceNotFoundException(deptStr, codeStr, deptCode));

        return DepartmentMapper.toDepartmentDTO(department);
    }

    @Override
    public DepartmentDTO readDeptById(Long deptId) {
        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException(deptStr, codeStr, deptId));

        return DepartmentMapper.toDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> findAllDepartment() {
        return departmentRepository.findAll().stream()
                .map(DepartmentMapper::toDepartmentDTO)
                .toList();
    }

    @Override
    public DepartmentDTO updateDepartment(String deptCode, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new ResourceNotFoundException(deptStr, codeStr, deptCode));
        department.setDeptName(departmentDTO.getDeptName());
        department.setDeptDesc(departmentDTO.getDeptDesc());
        department.setDeptCode(departmentDTO.getDeptCode());
        departmentRepository.save(department);

        return DepartmentMapper.toDepartmentDTO(department);
    }

    @Override
    public void deleteDepartment(String deptCode) {
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new ResourceNotFoundException(deptStr, codeStr, deptCode));
        departmentRepository.delete(department);
    }

}
