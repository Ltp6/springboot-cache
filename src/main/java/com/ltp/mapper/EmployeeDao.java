package com.ltp.mapper;

import com.ltp.entities.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDao {
    Employee queryEmpById(Integer id);

    int addEmp(Employee employee);

    int deleteEmpById(Integer id);

    int updateEmpById(Employee employee);

    List<Employee> queryAllEmp();
}
