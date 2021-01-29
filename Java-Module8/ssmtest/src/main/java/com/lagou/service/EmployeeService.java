package com.lagou.service;

import com.lagou.dao.EmployeeDao;
import com.lagou.domain.Employee;

import java.util.List;

public interface EmployeeService{

    public List<Employee> findAllEmployee();

    public void addEmployee(Employee employee);

    public void deleteById(int[] id);
}
