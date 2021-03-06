package com.ltp.controller;

import com.ltp.entities.Employee;
import com.ltp.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/emp/add")
    public int add(Employee employee) {
        return employeeService.add(employee);
    }

    @DeleteMapping(value = "/emp/delete/{id}")
    public int delete(@PathVariable(value = "id") Integer id) {
        return employeeService.delete(id);
    }

    @PutMapping(value = "emp/update")
    public Employee update(Employee employee) {
        return employeeService.update(employee);
    }

    @GetMapping(value = "/emp/get/{id}")
    public Employee get(@PathVariable(value = "id") Integer id) {
        return employeeService.get(id);
    }

    @GetMapping(value = "/emp/list")
    public List<Employee> list() {
        return employeeService.list();
    }
}
