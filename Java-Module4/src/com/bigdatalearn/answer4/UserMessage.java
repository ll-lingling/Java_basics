package com.bigdatalearn.answer4;

import java.io.Serializable;

// 2.创建登录信息

public class UserMessage implements Serializable {

    private static final long serialVersionUID = 5796540365012525308L;

    private String type;
    private User user;

    public UserMessage() {
    }

    public UserMessage(String type, User user) {
        this.type = type;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
