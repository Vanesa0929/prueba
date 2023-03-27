package com.prueba.microservicio.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EM_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EM_ID_PK")
    private Long id;

    @Column(name = "EM_EMPLOYEE_NAME")
    private String employee_name;

    @Column(name = "EM_EMPLOYEE_SALARY")
    private int employee_salary;

    @Column(name = "EM_EMPLOYEE_AGE")
    private int employee_age;

    @Column(name = "EM_PROFILE_IMAGE")
    private String profile_image;


}
