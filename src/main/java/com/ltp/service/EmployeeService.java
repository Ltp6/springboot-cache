package com.ltp.service;

import com.ltp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee get(Integer id);

    List<Employee> list();

    int delete(Integer id);

    int add(Employee employee);

    Employee update(Employee employee);
}
