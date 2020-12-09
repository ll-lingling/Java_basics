package com.bigdatalearn.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 通过该工具可以获取连接对象和连接池对象
 */

public class JDBCUtils {

    //创建c3p0连接池
    private static DataSource dataSource = new ComboPooledDataSource();

    // 提供一个方法返回连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 提供一个Connection的连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
