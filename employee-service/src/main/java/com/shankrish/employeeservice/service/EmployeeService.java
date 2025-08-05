package com.shankrish.employeeservice.service;

import com.shankrish.employeeservice.dto.DepartmentDTO;
import com.shankrish.employeeservice.dto.EmployeeDTO;
import com.shankrish.employeeservice.model.Employee;
import com.shankrish.employeeservice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository,
                           RestTemplate restTemplate,
                           ModelMapper modelMapper ) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee read(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public EmployeeDTO readEmpDto(Long id) {
        Employee employee = read(id);
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        DepartmentDTO departmentDTO = restTemplate.getForObject(
                "http://localhost:8081/api/v1/department/dept-id/" + employee.getDeptId(),
                DepartmentDTO.class);

        employeeDTO.setDepartment(departmentDTO);
        return employeeDTO;
    }

    public Employee update(Long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setDeptId(employee.getDeptId());
        return employeeRepository.save(employee1);
    }

    public void delete(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }

}
