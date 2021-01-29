package com.lagou.service;

import com.lagou.dao.DepartmentDao;
import com.lagou.domain.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {


    public List<Department> findAllDepartment();

    public Department findDepartmentById(int id);
}
