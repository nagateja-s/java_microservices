package com.microservices.employeeservices.service;

import com.microservices.employeeservices.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("api/departments/getDep/{departmentCode}")
    DepartmentDto getDepartmentById(@PathVariable String departmentCode);
}
