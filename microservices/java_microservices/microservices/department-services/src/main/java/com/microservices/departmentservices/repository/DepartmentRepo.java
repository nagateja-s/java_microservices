package com.microservices.departmentservices.repository;

import com.microservices.departmentservices.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
