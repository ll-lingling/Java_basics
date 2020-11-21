package com.bigdatalearn.answer1;

import java.util.Objects;

public class Student {
    private Integer sid;  // 学号
    private String name;  // 姓名
    private Integer age;  // 年龄

    public Student() {
    }

    public Student(Integer sid, String name, Integer age) throws AgeException, IdException {
        this.sid = sid;
        this.name = name;
        this.age = age;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) throws IdException {
        if (sid < 0) {
            throw new IdException("Invalid sid");
        } else {
            this.sid = sid;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) throws AgeException {
        if (age < 0) {
            throw new AgeException("Invalid age");
        } else {
            this.age = age;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) &&
                Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
