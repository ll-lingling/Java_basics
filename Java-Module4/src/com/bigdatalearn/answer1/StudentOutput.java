package com.bigdatalearn.answer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentOutput {
    public static void writeList(List arr,String filePath) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(arr);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }


    }
}
