package com.bigdatalearn.answer4;

import java.io.Serializable;

// 1.创建用户
public class User implements Serializable {

    private static final long serialVersionUID = -1824680268018157913L;
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        setName(name);
        setPassword(password);

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
