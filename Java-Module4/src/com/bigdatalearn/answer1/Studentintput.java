package com.bigdatalearn.answer1;

import java.io.*;
import java.util.List;

public class Studentintput {
    @SuppressWarnings("unchecked")
    public static List<Student> readList() {
        ObjectInputStream in = null;
        List<Student> arr = null;

        try {
            in = new ObjectInputStream(new FileInputStream("./com.bigdatalearn.answer1/student.txt"));
            Object obj = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return arr;
    }
}
