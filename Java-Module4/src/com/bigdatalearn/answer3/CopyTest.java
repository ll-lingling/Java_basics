package com.bigdatalearn.answer3;

import com.bigdatalearn.answer2.CreateFile;

/*  使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。

 */
public class CopyTest {
    public static void main(String[] args) {
        CreateFile.createFoldersAndFiles();
        CopyFilders.copyFilders("D:/code/big_data_learn/com", "D:/code/big_data_learn/comcopy/");

    }

}
