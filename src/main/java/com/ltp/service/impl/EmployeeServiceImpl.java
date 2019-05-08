package com.ltp.service.impl;

import com.ltp.entities.Employee;
import com.ltp.mapper.EmployeeMapper;
import com.ltp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    //将查询结果缓存起来
    @Cacheable(value = "emp")
    public Employee get(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    @Override
    public int delete(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(Employee employee) {
        return employeeMapper.insert(employee);
    }
}
