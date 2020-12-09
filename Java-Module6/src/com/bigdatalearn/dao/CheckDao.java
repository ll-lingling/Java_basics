package com.bigdatalearn.dao;

import com.bigdatalearn.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class CheckDao {

    // 检查用户名是否存在
    public boolean daoCheck(String name) throws SQLException {

        // 1.获取连接池DataSource对象
        DataSource dataSource = JDBCUtils.getDataSource();

        // 2.使用DBYtils
        QueryRunner queryRunner = new QueryRunner(dataSource);

        //3. 查询操作
        Long count = (Long) queryRunner.query("select count(*) from USER where username = ? ", new ScalarHandler(), name);

        // 4.如果查到了 count>=1
        return count >= 1;
    }

}
