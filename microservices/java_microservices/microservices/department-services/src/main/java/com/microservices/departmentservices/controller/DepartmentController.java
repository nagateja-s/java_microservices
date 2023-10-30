package com.microservices.departmentservices.controller;

import com.microservices.departmentservices.dto.DepartmentDto;
import com.microservices.departmentservices.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/getDep/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
    }
}
