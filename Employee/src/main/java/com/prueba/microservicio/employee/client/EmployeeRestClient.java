package com.prueba.microservicio.employee.client;

import com.prueba.microservicio.employee.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static com.prueba.microservicio.employee.config.ConfigurationConstants.EMPLOYEE_URL;

@FeignClient(name = "employee", url = EMPLOYEE_URL)
public interface EmployeeRestClient {

    @GetMapping(value = "", consumes = "plain/text")
    EmployeeDTO getEmployeeById(@RequestParam(value = "employee_id") Long id);

}
