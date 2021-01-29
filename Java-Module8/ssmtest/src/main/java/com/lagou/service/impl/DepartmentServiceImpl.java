package com.lagou.service.impl;

import com.lagou.dao.DepartmentDao;
import com.lagou.domain.Department;
import com.lagou.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAllDepartment() {
        List<Department> allDepartment = departmentDao.findAllDepartment();
        return allDepartment;
    }

    @Override
    public Department findDepartmentById(int id) {
        Department department = departmentDao.findDepartmentById(id);
        return department;
    }
}
