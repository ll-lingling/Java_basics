package com.lagou.service.impl;

import com.lagou.dao.EmployeeDao;
import com.lagou.domain.Department;
import com.lagou.domain.Employee;
import com.lagou.service.DepartmentService;
import com.lagou.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.findAllEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteById(int[] ids) {
        employeeDao.deleteEmployeeById(ids);
        System.out.println("delete by ids run");
    }
}
