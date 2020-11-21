package com.bigdatalearn.answer2;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    // 创建目录
    public static void createFolders(String path) {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
            System.out.println("成功创建目录：" + path);

        }
    }

    // 创建文件
    public static void createFiles(String path, String name) {
        File f = new File(path, name);
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("成功创建文件：" + name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //开始创建测试目录
    public static void createFoldersAndFiles() {
        String[] dirs = new String[]{
                "./com/bigdatalearn/目录1/",
                "./com/bigdatalearn/目录1/目录1.1/",
                "./com/bigdatalearn/目录1/目录1.1/目录1.1.1/",
                "./com/bigdatalearn/目录1/目录1.2/",
                "./com/bigdatalearn/目录1/目录1.2/目录1.2.1/",
                "./com/bigdatalearn/目录1/目录1.2/目录1.2.2/"
        };
        String[] files = new String[]{
                "test1.txt",
                "test1.1.txt",
                "test1.1.1.txt",
                "test1.2.txt",
                "test1.2.1.txt",
                "test1.2.2.txt",
        };
        for (int i = 0; i < 6; i++) {
            createFolders(dirs[i]);

            createFiles(dirs[i], files[i]);
        }

    }


}
