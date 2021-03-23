package com.lagou.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClientDemo {

    FileSystem fs = null;
    Configuration configuration = null;

    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        //1.获取Hadoop集群的configureation对象
        configuration = new Configuration();
//        configuration.set("fs.defaultFS","hdfs://192.168.80.121:9000");
//        configuration.set("fs.defaultFS","hdfs://192.168.80.121:9000");
        //2.根据configuration获取FileSystem对象
        // 配置在集群上运行
        // configuration.set("fs.defaultFS", "hdfs://hdfs://192.168.80.121:9000");
        // FileSystem fs = FileSystem.get(configuration);
        fs = FileSystem.get(new URI("hdfs://192.168.80.121:9000"), configuration, "root");

    }

    @After
    public void destory() throws IOException {
        //4.释放FileSystem对象
        fs.close();
    }

    @Test
    public void testMkdirs() throws URISyntaxException, IOException, InterruptedException {

        //3.使用FileSystem对象创建一个测试目录
        fs.mkdirs(new Path("/api_test2"));

    }

    @Test
    public void testCopyFromLocalFile() throws IOException, InterruptedException, URISyntaxException {

        // 上传文件
        // src ： 源文件目录 本地路径
        // dst ：目标文件目录 hdfs路径
        fs.copyFromLocalFile(new Path("d:/lagou.txt"), new Path("/lagou.txt"));
        // 上传文件到hdfs默认是3个副本，如果需要改变 1. configuration对象中指定dfs.replication新的副本数量；2. 在resources中配置hdfs-site.xml
    }

    @Test
    public void testCopyToLocalFile() throws IOException, InterruptedException, URISyntaxException {

        // 2 执行下载操作
        // boolean delSrc 指是否将原文件删除
        // Path src 指要下载的文件路径
        // Path dst 指将文件下载到的路径
        // boolean useRawLocalFileSystem 是否开启文件校验
        fs.copyToLocalFile(false, new Path("/lagou.txt"), new Path("d:/lagou_copy.txt"), true);

    }

    @Test
    public void testDeleteFile() throws IOException {
        fs.delete(new Path("/api_test2"), true);
    }


    @Test
    public void testListFiles() throws IOException, InterruptedException, URISyntaxException {

        // 得到一个迭代器：装有指定目录下所有文件信息
        RemoteIterator<LocatedFileStatus> remoteIterator = fs.listFiles(new Path("/"), true);
        while (remoteIterator.hasNext()) {
            LocatedFileStatus status = remoteIterator.next();
            // 输出详情
            // 文件名称
            System.out.println(status.getPath().getName());
            // 长度
            System.out.println(status.getLen());
            // 权限
            System.out.println(status.getPermission());
            // 用户
            System.out.println(status.getOwner());
            // 分组
            System.out.println(status.getGroup());
            // 获取存储的块信息
            BlockLocation[] blockLocations = status.getBlockLocations();
            for (BlockLocation blockLocation : blockLocations) {
                // 获取块存储的主机节点
                String[] hosts = blockLocation.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }

            }
            System.out.println("----------------------------------");
        }
    }


    @Test
    public void isFile() throws IOException {
        final FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            final boolean flag = fileStatus.isFile();
            if (flag) {
                System.out.println("文件" + fileStatus.getPath().getName());
            } else {
                System.out.println("文件夹" + fileStatus.getPath().getName());
            }

        }
    }


    // 使用IO流操作HDFS
    // 上传文件：准备输入流读取本地文件，使用hdfs的输出流写数据到hdfs
    @Test
    public void uploadFileIO() throws IOException {
        // 1.读取本地文件的输入流
        FileInputStream inputStream = new FileInputStream(new File("d:/lagou.txt"));
        // 2.准备写数据到hdfs的输出流
        FSDataOutputStream outputStream = fs.create(new Path("/lagou.txt"));
        // 3.输入流数据拷贝到输出流: 数组的到校以及是否关闭流底层 有默认值
        IOUtils.copyBytes(inputStream, outputStream, configuration);
        // 4. 在次关闭流
        IOUtils.closeStream(outputStream);
        IOUtils.closeStream(inputStream);

    }

    // 下载文件
    @Test
    public void downloadFileIO() throws IOException {
        // 1.读取hdfs的输入流
        FSDataInputStream in = fs.open(new Path("/lagou.txt"));
        // 2.本地文件的输出流
        FileOutputStream out = new FileOutputStream(new File("d:/lagou_io.txt"));
        // 3.流的拷贝
        IOUtils.copyBytes(in, out, configuration);
        // 4.再次关闭流
        IOUtils.closeStream(out);
        IOUtils.closeStream(in);
    }


    // seek 定位读取hdfs指定文件：使用io流读取/lagou.txt 文件并把内容输出两次，本质就是读取文件内容两次并输出
    @Test
    public void seekReadFile() throws IOException {
        // 1 创建一个读取hdfs文件的输入流
        FSDataInputStream in = fs.open(new Path("/lagou.txt"));
        // 2 控制台数据：System.out
        // 3 实现流拷贝，输入流 --> 控制台输出
//        IOUtils.copyBytes(in, System.out,configuration);
        IOUtils.copyBytes(in, System.out, 4096, false);
        // 4 再次读取文件
        in.seek(0); // 定位从0偏移量（文件头部）再次读取
        IOUtils.copyBytes(in, System.out, 4096, false);

        // 5 关闭输入流
        IOUtils.closeStream(in);

    }

    @Test
    public void testUploadPacket() throws IOException {
        //1 准备读取本地文件的输入流
        final FileInputStream in = new FileInputStream(new
                File("d:/lagou.txt"));
        //2 准备好写出数据到hdfs的输出流
        final FSDataOutputStream out = fs.create(new Path("/lagou.txt"), new Progressable() {
            public void progress() { //这个progress方法就是每传输64KB（packet）就会执行一次，
                System.out.println("&");
            }
        });
        //3 实现流拷贝
        IOUtils.copyBytes(in, out, configuration); //默认关闭流选项是true，所以会自动关闭
        //4 关流 可以再次关闭也可以不关了
    }
}
