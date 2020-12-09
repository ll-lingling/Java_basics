package com.bigdatalearn.service;

import com.bigdatalearn.dao.CheckDao;

import java.sql.SQLException;

public class CheckService {
    //检查用户是否存在的check方法
    public boolean check(String name) throws SQLException {
        return new CheckDao().daoCheck(name);
    }
}
