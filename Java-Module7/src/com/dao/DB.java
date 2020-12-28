package com.dao;


import com.domain.Student;
import com.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DB {
    // 声明一个QueryRunner变量
    private static QueryRunner qr;

    // 静态代码块。初始化qr,抽取到静态代码块，是为了提高效率，不需要每次访问都创建一个qr
    static {
        // 自动创建方式
        qr = new QueryRunner(DruidUtils.getDataSource());
    }

    // 根据id查询信息
    public static Student findById(Map<String, Object> param) {

        String sql = "select * from student where id=?";
        Student student = null;

        try {
            student = qr.query(sql, new BeanHandler<Student>(Student.class), param.get("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // 查询所有用户信息，用户信息列表
    public static List<Student> findAll() {
        String sql = "select * from student";
        List<Student> students = null;

        try {
            // 查询
            students = qr.query(sql, new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // 根据用户名查询用户
    public static Student findByName(Map<String, Object> param) {
        String sql = "select * from student where name=?";
        Student student = null;

        try {
            // 查询
            student = qr.query(sql, new BeanHandler<Student>(Student.class), param.get("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // 添加用户信息
    public static int add(Map<String, Object> param) {
        String sql = "insert into student(name, password, sex, birthday) values(?,?,?,?)";
        int update = 0;
        try {
            // 封装参数
            Object[] params = {param.get("name"), param.get("password"),
                    param.get("sex"), param.get("birthday")};
            // 更新，返回添加成功的条数
            update = qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    // 更新用户信息
    public static int update(Map<String, Object> param) {
        String sql = "update student set name=?, password=?, sex=?, birthday=? where id=?";
        int update = 0;
        try {
            // 封装参数
            Object[] params = {param.get("name"), param.get("password"),
                    param.get("sex"), param.get("birthday")};
            // 更新
            update = qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    // 根据id删除用户
    public static int deleteById(Map<String, Object> param) {
        String sql = "delete from student where id=?";
        int delete = 0;
        try {
            // 更新
            delete = qr.update(sql, param.get("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }
}