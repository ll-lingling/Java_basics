package com.bigdatalearn.answer1;

import java.util.List;
import java.util.Scanner;

// 学生添加类
public class StudentAdd {

    public static List studentAdd(List arr) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();

        System.out.println("请输入学号");
        int sid = sc.nextInt();


        System.out.println("请输入姓名");
        String name = sc.next();

        System.out.println("请输入年龄");
        int age = sc.nextInt();

        try {
            stu.setSid(sid);
        } catch (IdException e) {
            e.printStackTrace();
        }
        stu.setName(name);
        try {
            stu.setAge(age);
        } catch (AgeException e) {
            e.printStackTrace();
        }
        arr.add(stu);
        System.out.println(arr);


        return arr;
    }

}
