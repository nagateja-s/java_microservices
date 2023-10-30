package com.microservices.departmentservices.service.impl;

import com.microservices.departmentservices.dto.DepartmentDto;
import com.microservices.departmentservices.entity.Department;
import com.microservices.departmentservices.repository.DepartmentRepo;
import com.microservices.departmentservices.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDep = departmentRepo.save(department);

        DepartmentDto savedDepDto = new DepartmentDto(
                savedDep.getId(),
                savedDep.getDepartmentName(),
                savedDep.getDepartmentDescription(),
                savedDep.getDepartmentCode()
        );

        return savedDepDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department =  departmentRepo.findByDepartmentCode(departmentCode);
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
}
