package io.khasang.gahelp.config;

import io.khasang.gahelp.dao.EmployeeDao;
import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.dao.impl.EmployeeDaoImpl;
import io.khasang.gahelp.dao.impl.HorseDaoImpl;
import io.khasang.gahelp.entity.Employee;
import io.khasang.gahelp.entity.Horse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public HorseDao horseDao() {
        return new HorseDaoImpl(Horse.class);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }
}
