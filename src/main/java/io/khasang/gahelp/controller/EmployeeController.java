package io.khasang.gahelp.controller;

import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Employee;
import io.khasang.gahelp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public EmployeeDto getEmployeeById(@PathVariable("id") long id) {
        return employeeService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Employee deleteEmployee(@PathVariable("id") long id) {
        return employeeService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Employee updateById(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
