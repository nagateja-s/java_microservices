package com.microservices.employeeservices.service;

import com.microservices.employeeservices.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long id);
}
