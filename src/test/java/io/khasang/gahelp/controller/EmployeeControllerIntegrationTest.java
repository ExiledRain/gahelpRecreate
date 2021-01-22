package io.khasang.gahelp.controller;

import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Car;
import io.khasang.gahelp.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class EmployeeControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/employee";
    private static final String ADD = "/add";
    private static final String ALL = "/all";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";

    @Test
    public void testHomePage() throws Exception {
        AppController controller = new AppController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("status"));
    }

    @Test
    public void checkEmployeeAdd() {
        Employee risak = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<EmployeeDto> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                EmployeeDto.class,
                risak.getId()
        );
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EmployeeDto receivedEmployee = responseEntity.getBody();
        Assert.assertNotNull(receivedEmployee);
    }

    @Test
    public void checkAllEmployees() {
        createEmployee();
        createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Employee>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                }
        );
        List<Employee> employees = responseEntity.getBody();
        Assert.assertNotNull(employees);
    }

    private Employee createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();
        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        RestTemplate restTemplate = new RestTemplate();
        Employee createdEmployee = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Employee.class).getBody();

        Assert.assertNotNull(createdEmployee);
        Assert.assertEquals("Jack", createdEmployee.getName());
        return createdEmployee;
    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Jack");
        employee.setTitle("The Captain");

        Car vaz = new Car();
        vaz.setModel("VAZ");
        vaz.setYear(LocalDate.of(2017, Month.APRIL,12));

        Car bmw = new Car();
        bmw.setModel("BMW");
        bmw.setYear(LocalDate.of(2005,Month.FEBRUARY,20));

        List<Car> cars = new ArrayList<>();
        cars.add(vaz);
        cars.add(bmw);

        employee.setCarList(cars);
        return employee;
    }

}
