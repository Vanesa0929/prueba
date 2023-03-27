package com.prueba.microservicio.employee.service;

import com.prueba.microservicio.employee.converter.EmployeeConverter;
import com.prueba.microservicio.employee.dto.EmployeeDTO;
import com.prueba.microservicio.employee.entity.Employee;
import com.prueba.microservicio.employee.model.EmployeeModel;
import com.prueba.microservicio.employee.repository.EmployeeRepository;
import com.prueba.microservicio.employee.service.impl.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeService clientService;

    @Mock
    @Qualifier("clientRepository")
    private EmployeeRepository clientRepository;

    @Mock
    @Qualifier("clientConverter")
    private EmployeeConverter clientConverter;
    EmployeeModel clientModel;
    Employee employee;
    EmployeeDTO employeeDTO;
    List<Employee> employeeList;
    List<EmployeeModel> clientModelList;
    @Before
    public void init() {

        employee = new Employee();
        employee.setId(1L);
        employee.setEmployee_name("Juan Gomez");
        employee.setEmployee_age(24);
        employee.setEmployee_salary(510000);
        employee.setProfile_image("");

        employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmployee_name(employee.getEmployee_name());
        employeeDTO.setEmployee_age(employee.getEmployee_age());
        employeeDTO.setEmployee_salary(employee.getEmployee_salary());
        employeeDTO.setProfile_image(employee.getProfile_image());


        clientModel = new EmployeeModel(employee);

        employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee);
        employeeList.add(employee);

        clientModelList = new ArrayList<>();
        clientModelList.add(new EmployeeModel(employee));
        clientModelList.add(new EmployeeModel(employee));
        clientModelList.add(new EmployeeModel(employee));

        Mockito.when(clientConverter.listConverter(employeeList)).thenReturn(clientModelList);
        Mockito.when(clientRepository.getByEmployeeId(employeeDTO.getId())).thenReturn(employee);

    }

    @Test
    public void whenFindByClientId_shouldReturnClient() {
        EmployeeModel found = clientService.getByClientId(employeeDTO.getId());
        Assertions.assertThat(found).isEqualTo(clientModel);
    }


}
