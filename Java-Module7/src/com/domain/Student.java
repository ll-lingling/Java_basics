package com.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private int id; // 学号
    private String name;  // 姓名
    private String password; // 密码
    private int sex;      // 性别 0男  1女
    private String birthday;  // 出生日期
    private int disabled;  // 禁用 0否 1是
    private int deleted;   // 删除 0否 1是

    public Student() {
    }

    public Student(int id, String name, String password, int sex, String birthday, int disabled, int deleted) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.disabled = disabled;
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}