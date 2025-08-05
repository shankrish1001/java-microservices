package com.shankrish.departmentservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String code;
}
