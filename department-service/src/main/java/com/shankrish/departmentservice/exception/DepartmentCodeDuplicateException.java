package com.shankrish.departmentservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class DepartmentCodeDuplicateException extends RuntimeException {
    private final String deptCode;
    public DepartmentCodeDuplicateException(String deptCode) {
        super(String.format("A department with code %s already exists", deptCode));
        this.deptCode = deptCode;
    }

}
