package com.bigdatalearn.answer2;

/*
 * 实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 * */

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DeleteTest {
    public static void deleteAll(File file) {
        File[] filesArray = file.listFiles();
        // 如果目录不存在则返回

        for (File tf : filesArray) {
            String name = tf.getName();
            // 判断是否为文件或是空目录，若是则直接删除
            if (tf.isFile()||tf.list().length > 0) {
                System.out.println(name);
                tf.delete();
            }
            // 若是非空目录递归
            if (tf.isDirectory()) {
                deleteAll(tf);
            }
        }
        file.delete();

    }

    public static void main(String[] args) {
        // 创建测试目录
        CreateFile.createFoldersAndFiles();
        try {
            // 暂停一会，以便查看创建的目录
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 删除
        deleteAll(new File("D:/code/big_data_learn/com"));
    }
}
