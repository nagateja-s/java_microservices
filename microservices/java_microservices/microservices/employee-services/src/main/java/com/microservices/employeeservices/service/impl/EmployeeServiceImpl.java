package com.microservices.employeeservices.service.impl;

import com.microservices.employeeservices.dto.ApiResponseDto;
import com.microservices.employeeservices.dto.DepartmentDto;
import com.microservices.employeeservices.dto.EmployeeDto;
import com.microservices.employeeservices.entity.Employee;
import com.microservices.employeeservices.repository.EmployeeRepo;
import com.microservices.employeeservices.service.ApiClient;
import com.microservices.employeeservices.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    private ApiClient apiClient;
    //private WebClient webClient;
    //private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepo.save(employee);

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
    }

    @Override
    public ApiResponseDto getEmployee(Long id) {

        Employee employee = employeeRepo.findById(id).get();

        /*DepartmentDto departmentDto =  restTemplate.getForObject("http://localhost:8080/api/departments/getDep/"+employee.getDepartmentCode(),
                DepartmentDto.class);*/
       /* DepartmentDto departmentDto =  webClient.get()
                .uri("http://localhost:8080/api/departments/getDep/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
*/
        DepartmentDto departmentDto = apiClient.getDepartmentById(employee.getDepartmentCode());

        EmployeeDto employeeDto =  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return new ApiResponseDto(employeeDto, departmentDto);
    }
}
