package com.prueba.microservicio.employee.controller;


import com.prueba.microservicio.employee.model.EmployeeModel;
import com.prueba.microservicio.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("https://dummy.restapiexample.com/api/v1/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private IEmployeeService clientService;

    @GetMapping("")
    public List<EmployeeModel> findByIdEmployee(
            @RequestParam(value = "id", required = false) Long id) {

        List<EmployeeModel> response = new ArrayList<>();

        if (id != null) {
            response.add(clientService.getByClientId(id));
        }

        return response;
    }

}

