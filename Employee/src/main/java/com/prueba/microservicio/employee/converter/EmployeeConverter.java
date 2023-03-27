package com.prueba.microservicio.employee.converter;

import com.prueba.microservicio.employee.entity.Employee;
import com.prueba.microservicio.employee.model.EmployeeModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("clientConverter")
public class EmployeeConverter {
    public List<EmployeeModel> listConverter(List<Employee> projectList) {
        List<EmployeeModel> clientModels = new ArrayList<>();
        projectList.forEach(client -> clientModels.add(new EmployeeModel(client)));
        return clientModels;
    }
}
