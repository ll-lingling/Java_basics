package com.bigdatalearn.answer1;

import java.util.List;
import java.util.Scanner;

public class StudentPut {

    public static List studentPut(List arr) {
        System.out.println("请输入要修改学生的id：");
        Scanner sc = new Scanner(System.in);
        int sid = sc.nextInt();
        for (int i = 0; i < arr.size(); i++) {
            Student s = (Student) arr.get(i);
            if (s.getSid().equals(sid)) {
                System.out.println("请输入要修改的学号 :");
                try {
                    s.setSid(sc.nextInt());
                } catch (IdException e) {
                    e.printStackTrace();
                }
                System.out.println("请输入要修改的年龄:");
                try {
                    s.setAge(sc.nextInt());
                } catch (AgeException e) {
                    e.printStackTrace();
                }
                System.out.println("请输入要修改的姓名 :");
                s.setName(sc.next());
            } else {
                System.out.println("系统中不存在此学生信息！！！！");

            }
        }
        return arr;
    }
}
