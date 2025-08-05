package com.shankrish.departmentservice.controller;

import com.shankrish.departmentservice.payload.DepartmentDTO;
import com.shankrish.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDept(@Validated @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{deptCode}")
    public ResponseEntity<DepartmentDTO> readDept(@PathVariable String deptCode) {
        return new ResponseEntity<>(departmentService.readDepartment(deptCode), HttpStatus.OK);
    }

    @GetMapping("/dept-id/{deptId}")
    public ResponseEntity<DepartmentDTO> readDept(@PathVariable Long deptId) {
        return new ResponseEntity<>(departmentService.readDeptById(deptId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> readAllDept() {
        return new ResponseEntity<>(departmentService.findAllDepartment(), HttpStatus.OK);
    }

    @PutMapping("/{deptCode}")
    public ResponseEntity<DepartmentDTO> updateDept(@PathVariable String deptCode, @RequestBody DepartmentDTO departmentDTO) {
        try {
            return ResponseEntity.ok(departmentService.updateDepartment(deptCode, departmentDTO));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{deptCode}")
    public ResponseEntity<Void> deleteDept(@PathVariable String deptCode) {
        departmentService.deleteDepartment(deptCode);
        return ResponseEntity.noContent().build();
    }

}
