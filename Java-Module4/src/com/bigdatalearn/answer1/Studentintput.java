package com.bigdatalearn.answer1;

import java.io.*;
import java.util.List;

public class Studentintput {
    @SuppressWarnings("unchecked")
    public static List readList(String filename) {
        ObjectInputStream in = null;
        List arr = null;

        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            Object obj = in.readObject();
            arr = (List)obj;
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
