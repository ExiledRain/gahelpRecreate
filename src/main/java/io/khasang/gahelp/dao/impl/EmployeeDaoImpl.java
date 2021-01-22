package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.EmployeeDao;
import io.khasang.gahelp.entity.Employee;

public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }
}
