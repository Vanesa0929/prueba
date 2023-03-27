package com.prueba.microservicio.employee.service;

import com.prueba.microservicio.employee.dto.EmployeeDTO;
import com.prueba.microservicio.employee.model.EmployeeModel;
import org.hibernate.service.spi.ServiceException;

public interface IEmployeeService {

    EmployeeModel getByClientId(long projectId);

    Long verifyClient(EmployeeDTO clientDTO);

}
