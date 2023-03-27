package com.prueba.microservicio.employee.service.impl;

import com.prueba.microservicio.employee.converter.EmployeeConverter;

import com.prueba.microservicio.employee.dto.EmployeeDTO;
import com.prueba.microservicio.employee.exception.BadRequestException;
import com.prueba.microservicio.employee.model.EmployeeModel;
import com.prueba.microservicio.employee.repository.EmployeeRepository;
import com.prueba.microservicio.employee.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

    @Autowired
    @Qualifier("clientRepository")
    private EmployeeRepository employeeRepository;

    @Autowired
    @Qualifier("clientConverter")
    private EmployeeConverter employeeConverter;
    @Override
    public EmployeeModel getByClientId(long id) {
        var employee = employeeRepository.getByEmployeeId(id);
        return new EmployeeModel(employee);
    }

    @Override
    public Long verifyClient(EmployeeDTO clientDTO) {

        if (clientDTO.getId() == null) {
            var message = "Error while find client ,an client id is required {}, {}";
            log.error(message, HttpStatus.NOT_FOUND);
            throw new BadRequestException(message);
        }
        var client = employeeRepository.getByEmployeeId(clientDTO.getId());
        return client.getId();
    }

}
