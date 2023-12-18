package com.example.transactiondemo.dao;

import com.example.transactiondemo.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {
     private JdbcTemplate jdbcTemplate;
     public EmployeeDao(DataSource dataSource){
         jdbcTemplate=new JdbcTemplate();
         jdbcTemplate.setDataSource(dataSource);
     }

     public void createEmployee(String firstName,String lastName,String email,String phoneNumber,double salary){
         jdbcTemplate.update("""
insert into employee(first_name,last_name,email,phone_number,salary)
values (?,?,?,?,?)
""",firstName,lastName,email,phoneNumber,salary);

     }

    public void save(Employee employee) {
    }
}
