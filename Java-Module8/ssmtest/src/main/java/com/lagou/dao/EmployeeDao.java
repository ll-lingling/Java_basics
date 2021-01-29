package com.lagou.dao;

import com.lagou.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    /*
    require employee list
     */
    public List<Employee> findAllEmployee();

    /*
    add employee
    */
    void addEmployee(Employee employee);

    /**
     * delete by id
     * @param ids
     */
    void deleteEmployeeById(int[] ids);

}
