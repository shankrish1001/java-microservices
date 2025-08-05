package com.shankrish.departmentservice.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DepartmentDTO {
    private Long deptId;
    @NotEmpty(message = "A department must have a name and it cannot be empty")
    private String deptName;
    @NotEmpty(message = "A department must have a description and it cannot be empty")
    private String deptDesc;
    @NotEmpty(message = "A department must have a code and it cannot be empty")
    private String deptCode;
}
