package com.ltp.service.impl;

import com.ltp.entities.Employee;
import com.ltp.mapper.EmployeeMapper;
import com.ltp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    //将方法的结果缓存起来，下次自己从缓存中取数据，不用再次查询数据库
    @Cacheable(key = "#id",sync = true)
    //@Cacheable(keyGenerator = "keyGeneratorMethod")
    public Employee get(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    @Override
    //清除缓存，在方法调用前
    @CacheEvict(key = "#id",beforeInvocation = true)
    public int delete(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int add(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    //保证方法被调用，同时结果被缓存
    @CachePut(key = "#employee.id")
    /*
    * 此时返回值不能为int类型，否则再次查询，缓存更新后的数据会报错：
    * java.lang.ClassCastException
    * */
    public Employee update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
        return employee;
    }
}
