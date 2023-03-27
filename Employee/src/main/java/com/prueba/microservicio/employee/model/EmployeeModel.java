package com.prueba.microservicio.employee.model;

import com.prueba.microservicio.employee.entity.Employee;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class EmployeeModel {
    private Long id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;



    public EmployeeModel(Employee employee) {
        this.id = employee.getId();
        this.employee_name = employee.getEmployee_name();
        this.employee_salary = employee.getEmployee_salary();
        this.employee_age = employee.getEmployee_age();
        this.profile_image= employee.getProfile_image();

    }
}
