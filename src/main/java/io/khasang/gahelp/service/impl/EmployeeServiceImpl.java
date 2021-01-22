package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.EmployeeDao;
import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Employee;
import io.khasang.gahelp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeDto employeeDto;

    @Override
    public Employee add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public EmployeeDto getById(long id) {
        return employeeDto.getEmployeeDto(employeeDao.getById(id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee delete(long id) {
        return employeeDao.delete(employeeDao.getById(id));
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }
}
