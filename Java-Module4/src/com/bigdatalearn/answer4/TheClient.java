package com.bigdatalearn.answer4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// 4创建客户端
public class TheClient {
    public static void main(String[] args) {
        Socket s = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            // 连接服务
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接成功");
            // 创建UserMessage对象
            UserMessage userMessage = new UserMessage("check", new User("admin", "123456"));
            // 创建对象输出流
            out = new ObjectOutputStream(s.getOutputStream());
            // 发出对象
            out.writeObject(userMessage);
            // 创建对象输入流
            in = new ObjectInputStream(s.getInputStream());
            // 获取服务端返回的UserMessage对象
            userMessage = (UserMessage) in.readObject();
            // 打印结果
            if ("success".equals(userMessage.getType())) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登陆失败");
            }
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
            if (null != out) {
                try {
                    out.close();
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
        }

    }
}
