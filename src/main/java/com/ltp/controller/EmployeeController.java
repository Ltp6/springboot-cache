package com.ltp.controller;

import com.ltp.entities.Employee;
import com.ltp.mapper.EmployeeDao;
import com.ltp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/emp/get/{id}")
    public Employee get(@PathVariable(value = "id") Integer id) {
        return employeeService.get(id);
    }

    @GetMapping(value = "/emp/list")
    public List<Employee> list() {
        return employeeService.list();
    }
}
