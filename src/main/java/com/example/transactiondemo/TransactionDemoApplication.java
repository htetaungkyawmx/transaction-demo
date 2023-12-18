package com.example.transactiondemo;

import com.example.transactiondemo.dao.EmployeeDao;
import com.example.transactiondemo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionDemoApplication {

    private final EmployeeDao employeeDao;
    @Bean
    public ApplicationRunner runner() {

        return r ->{
            List.of(
                    new Employee("john","Doe","john@gmail.com","55-555-55",3000),
                    new Employee("Charles","Leo","leo@gmail.com","44-545-45",2500),
                    new Employee("MX","updike","mx@gmail.com","33-535-35",2000),
                    new Employee("Peter","Thomas","peter@gmail.com","22-525-25",1500),
                    new Employee("Shale","More","more@gmail.com","11-515-15",1000)

            ).forEach(employeeDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionDemoApplication.class, args);
    }

}
