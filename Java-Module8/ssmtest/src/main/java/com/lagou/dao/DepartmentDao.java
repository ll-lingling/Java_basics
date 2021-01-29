package com.lagou.dao;

import com.lagou.domain.Department;

import java.util.List;

public interface DepartmentDao {

    /*
    require all department
    */
    public List<Department> findAllDepartment();

    /*
    require department by id
    */
    public Department findDepartmentById(int id);
}
