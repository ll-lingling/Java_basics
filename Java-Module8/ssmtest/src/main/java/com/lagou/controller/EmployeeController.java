package com.lagou.controller;

import com.lagou.domain.Employee;
import com.lagou.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    private EmployeeService service;
    /**
     * find all employee
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Employee> allEmployee = service.findAllEmployee();

        for (Employee employee : allEmployee) {
            System.out.println(employee);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("employeeList",allEmployee);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Employee employee) {
        service.addEmployee(employee);
        return "redirect:/employee/findAll";
    }

    @RequestMapping("/delete")
    public String deleteById(int[] ids) {
        service.deleteById(ids);
        return "redirect:/employee/findAll";
    }
}
