package com.bigdatalearn.answer4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 3.创建服务端
public class TheServer {

    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            // 在8888端口创建服务
            ss = new ServerSocket(8888);
            System.out.println("等待连接");
            // 等待连接
            s = ss.accept();
            // 获取对象输入流
            in = new ObjectInputStream(s.getInputStream());
            // 获取UserMessage对象
            UserMessage userMessage = (UserMessage) in.readObject();
            // 验证对象属性
            if ("admin".equals(userMessage.getUser().getName())
                    && "123456".equals(userMessage.getUser().getPassword())) {
                // 修改对象属性
                userMessage.setType("success");
            } else {
                userMessage.setType("fail");
            }
            System.out.println(userMessage.getType());
            // 获取对象输出流
            out = new ObjectOutputStream(s.getOutputStream());
            // 发出UserMessage对象
            out.writeObject(userMessage);
        } catch (IOException | ClassNotFoundException e) {
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
            }
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
