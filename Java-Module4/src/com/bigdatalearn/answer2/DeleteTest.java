package com.bigdatalearn.answer2;

/*
 * 实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 * */

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DeleteTest {
    public static void deleteAll(String path) {
        // 需要删除的目录
        File folders = new File(path);
        // 如果目录不存在则返回
        if (!folders.exists()) {
            System.out.println("目录不存在");
            return;
        }
        // 如果目录为空，则直接删除，并返回
        if (0 == folders.length()) {
            folders.delete();
            System.out.println(folders.getName() + "被删除了！");
            return;
        }
        // 遍历目录的内容
        for (File f : folders.listFiles()) {
            if (f.isFile()) {
                // 如果是文件则直接删除
                f.delete();
                System.out.println(f.getName() + "被删除了！");
            } else {
                // 如果是目录，则递归处理
                deleteAll(f.getAbsolutePath());
            }
        }
        // 删除目录自身
        folders.delete();
        System.out.println(folders.getName() + "被删除了！");
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
        deleteAll("./com");
    }
}
