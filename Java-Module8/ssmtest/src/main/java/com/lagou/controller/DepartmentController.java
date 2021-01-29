package com.lagou.controller;


import com.lagou.domain.Department;
import com.lagou.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentService service;

    /*
        find all department
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Department> findAll() {
        List<Department> allDepartment = service.findAllDepartment();
        for (Department department : allDepartment) {
            System.out.println(department);
        }
        return allDepartment;
    }

}
