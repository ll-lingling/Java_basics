package com.bigdatalearn.answer1;

import java.util.List;
import java.util.Scanner;

public class StudentRemove {
    public static List studentRemove(List arr) {

        System.out.println("请输入要删除学生的id：");
        Scanner sc = new Scanner(System.in);

        Integer sid = sc.nextInt();

        for (int i = 0; i < arr.size(); i++) {
            Student s = (Student) arr.get(i);
            if (s.getSid().equals(sid)) {
                arr.remove(s);
                break;
            } else {
                System.out.println("集合中不存在此元素！！！！");
            }
        }
        return arr;
    }
}
