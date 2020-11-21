package com.bigdatalearn.answer1;

/*
 * 使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
 * <p>
 * 其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。
 */

/* 基于学生信息管理系统增加以下两个功能：

            a.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。

            b.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
*/

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {

        List arr;
        String filePath = "D:/code/big_data_learn/Java-Module4/src/com/bigdatalearn/answer1/student.txt";
        File txt = new File(filePath);
        if (txt.exists()) {
            // 如果文件存在则读取
            arr = Studentintput.readList(filePath);
            System.out.println(arr);
        } else {
            arr = new ArrayList();
        }
        while (true) {
            //用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查找学生");
            System.out.println("5 查看所有学生");
            System.out.println("6 退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            int line = sc.nextInt();

            switch (line) {
                case 1:
                    arr = StudentAdd.studentAdd(arr);
                    break;
                case 2:
                    arr = StudentRemove.studentRemove(arr);
                    break;
                case 3:
                    arr = StudentPut.studentPut(arr);
                    break;
                case 4:
                    StudentFind.studentFind(arr);
                    break;
                case 5:
                    StudentAll.studentAll(arr);
                    break;
                case 6:
                    System.out.println("正在退出系统...");
                    StudentOutput.writeList(arr, filePath);
                    return;
                default:
                    break;

            }

        }
    }
}
