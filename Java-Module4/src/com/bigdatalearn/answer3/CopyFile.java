package com.bigdatalearn.answer3;

import java.io.*;

public class CopyFile {
    public static void copyFile(String oldPath, String newPath) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new BufferedInputStream(new FileInputStream(oldPath));
            out = new BufferedOutputStream((new FileOutputStream(newPath)));
            byte[] arr = new byte[1024];
            int res = 0;
            while ((res = in.read(arr)) != -1) {
                out.write(arr, 0, res);
            }
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

            if (null != in) {
                try {
                    in.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }        }


    }
}
