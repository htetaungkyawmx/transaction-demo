package com.example.transactiondemo.dao;

import com.example.transactiondemo.entity.Employee;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeJdbcClient {

    private JdbcClient jdbcClient;
    public EmployeeJdbcClient(DataSource dataSource){
        this.jdbcClient=JdbcClient.create(dataSource);
    }

    public List<Employee> findAllEmployee(){
        return jdbcClient.sql("select * from employee")
                .query(Employee.class)
                .list();
    }

    public void createEmployee(Employee employee){
        jdbcClient.sql("insert into employee(first_name,last_name,email,phone_number,salary)" +
                "values(?,?,?,?,?)")
        .params(List.of(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getSalary()
        ))
                .update();

    }

}
