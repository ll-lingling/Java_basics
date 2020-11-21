package com.bigdatalearn.answer1;

import java.util.List;
import java.util.Scanner;

public class StudentFind {
    public static void studentFind(List arr) {
        System.out.println("1 根据学号查找");
        System.out.println("2 根据姓名查找");
        System.out.println("3 退出");

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                findSid(arr);
                break;
            case 2:
                findName(arr);
                break;
            case 3:
                break;

        }
    }

    private static void findSid(List arr) {
        System.out.print("请输入要查询学生的id：");
        Scanner sc = new Scanner(System.in);
        Integer sid = sc.nextInt();
        for (int i = 0; i < arr.size(); i++) {

            Student s = (Student) arr.get(i);
            if (s.getSid().equals(sid)) {
                System.out.println("该学生的信息: 学号:" + s.getSid() + "年龄：" + s.getAge() + "姓名：" + s.getName());
                break;
            } else {
                System.out.println("系统中不存在此学生信息！！！！");
                break;
            }
        }
    }

    private static void findName(List arr) {
        System.out.print("请输入要查询学生的id：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for (int i = 0; i < arr.size(); i++) {

            Student s = (Student) arr.get(i);
            if (s.getName().equals(name)) {
                System.out.println("该学生的信息: 学号:" + s.getSid() + "年龄：" + s.getAge() + "姓名：" + s.getName());
                break;
            } else {
                System.out.println("系统中不存在此学生信息！！！！");
                break;
            }
        }
    }
}
