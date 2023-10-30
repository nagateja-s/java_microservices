package com.microservices.departmentservices.service;

import com.microservices.departmentservices.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);
}
