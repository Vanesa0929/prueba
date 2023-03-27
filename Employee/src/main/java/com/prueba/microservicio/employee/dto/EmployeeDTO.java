package com.prueba.microservicio.employee.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class EmployeeDTO {

    private Long id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;

}


