package com.lagou.mapper;

import com.lagou.domain.Department;

import java.util.List;

public interface DeptMapper {


    public Department findById(int deptId);

    public List<Department> findAll();
}
