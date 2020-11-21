package com.bigdatalearn.answer3;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyFilders {
    public static void copyFilders(String oldPath, String newPath) {
        File oldFilders = new File(oldPath);
        File newFilders = new File(newPath);

        if (!oldFilders.exists()) {
            System.out.println("复制的文件夹不存在");
            return;
        }
        if (!newFilders.exists()) {
            newFilders.mkdirs();
            System.out.println(newPath + "复制成功");

        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //遍历被拷贝的目录
        for (File f : oldFilders.listFiles()) {

            // 向线程池提交任务
            executorService.submit(() -> {
                if (f.isFile()) {
                    // 复制文件
                    CopyFile.copyFile(f.getAbsolutePath(), newFilders.getAbsolutePath() + "/" + f.getName());
                } else {
                    // 如果是目录，则进行递归
                    CopyFilders.copyFilders(f.getAbsolutePath(), newFilders.getAbsolutePath() + "/" + f.getName());
                }
                return null;
            });
        }
        // 关闭线程池
        executorService.shutdown();
    }
}
