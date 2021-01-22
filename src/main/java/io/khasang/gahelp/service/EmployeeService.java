package io.khasang.gahelp.service;

import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * service for adding Employee
     *
     * @param employee for adding
     * @return  added Employee
     * */
    Employee add(Employee employee);

    /**
     * service for geting Employee by Id
     * @param id - Employee id
     * @return specific Employee by id
     * */
    EmployeeDto getById(long id);

    /**
     * service to get all Employees
     * @return Employees list
     * */
    List<Employee> getAll();

    /**
     * service to delete Employee
     * @param id - id Employee to delete
     * @return Employee deleted
     * */
    Employee delete(long id);

    /**
     * service to update Employee
     * @return updated Employee
     * @param employee - specific Employee for the update
     * */
    Employee update(Employee employee);
}
