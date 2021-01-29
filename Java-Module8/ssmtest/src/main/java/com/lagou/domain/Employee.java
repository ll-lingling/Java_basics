package com.lagou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {


    private Integer id;
    private String empName;
    private Integer deptId;
    private String jobName;
    private Date joinDate;
    private String telephone;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", jobName='" + jobName + '\'' +
                ", joinDate=" + joinDate +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
