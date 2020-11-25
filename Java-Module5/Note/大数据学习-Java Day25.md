# 大数据学习-Java Day25

## 数据库连接池 &DBUtils 

### 1 数据库连接池

- 连接池概念

  -  实际开发中“获得连接”或“释放资源”是非常消耗系统资源的两个过程，为了解决此类性能问题，通常情况我们 采用连接池技术，来共享连接Connection。这样我们就不需要每次都创建连接、释放连接了，这些操作都交 给了连接池 
  - 优点
    -  用池来管理Connection，这样可以重复使用Connection。 当使用完Connection后，调用Connection的 close()方法也不会真的关闭Connection，而是把Connection“归还”给池。 

- JDBC方式与连接池方式

  - 普通JDBC方式

    ![](./picture/day25/普通JDBC方式.png)

  - 连接池方式

    ![](./picture/day25/连接池方式.png)

- 使用方式
  -  Java为数据库连接池提供了公共的接口：javax.sql.DataSource，各个厂商需要让自己的连接池实现这个接口。 这样应用程序可以方便的切换不同厂商的连接池！  
  -  常见的连接池有 DBCP连接池, C3P0连接池, Druid连接池, 

- 数据准备

  ```mysql
  #创建数据库
  CREATE DATABASE db5 CHARACTER SET utf8;
  #使用数据库
  USE db5;
  #创建员工表
  CREATE TABLE employee (
  eid INT PRIMARY KEY AUTO_INCREMENT ,
  ename VARCHAR (20), -- 员工姓名
  age INT , -- 员工年龄
  sex VARCHAR (6), -- 员工性别
  salary DOUBLE , -- 薪水
  empdate DATE -- 入职日期
  );
  #插入数据
  INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'李清照',22,'女',4000,'2018-11-12');
  INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'林黛玉',20,'女',5000,'2019-03-14');
  INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'杜甫',40,'男',6000,'2020-01-01');
  INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'李白',25,'男',3000,'2017-10-01');
  
  ```

-  DBCP连接池 

  -  DBCP也是一个开源的连接池，是Apache成员之一，在企业开发中也比较常见，tomcat内置的连接池。 

    ![](./picture/day25/DBCP连接池准备.png)

  - 编写工具类

    -  连接数据库表的工具类, 采用DBCP连接池的方式来完成

      -  Java中提供了一个连接池的规则接口 ： DataSource , 它是java中提供的连接池 
      - 在DBCP包中提供了DataSource接口的实现类，我们要用的具体的连接池 BasicDataSource 类 

      ```java
          //1.定义常量 保存数据库连接的相关信息
          public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
          public static final String URL = "jdbc:mysql://localhost:3306/db5?characterEncoding=UTF-8";
          public static final String USERNAME = "root";
          public static final String PASSWORD = "123456";
          //2.创建连接池对象 (有DBCP提供的实现类)
          public static BasicDataSource dataSource = new BasicDataSource();
      
          //3.使用静态代码块进行配置
          static {
              dataSource.setDriverClassName(DRIVERNAME);
              dataSource.setUrl(URL);
              dataSource.setUsername(USERNAME);
              dataSource.setPassword(PASSWORD);
          }
      
          //4.获取连接的方法
          public static Connection getConnection() throws SQLException {
      //从连接池中获取连接
              Connection connection = dataSource.getConnection();
              return connection;
          }
      
          //5.释放资源方法
          public static void close(Connection con, Statement statement) {
              if (con != null && statement != null) {
                  try {
                      statement.close();
                      //归还连接
                      con.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
              }
          }
      
          public static void close(Connection con, Statement statement, ResultSet resultSet) {
              if (con != null && statement != null && resultSet != null) {
                  try {
                      resultSet.close();
                      statement.close();
                      //归还连接
                      con.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
              }
          }
      ```

      

  - 测试工具类

    -  需求: 查询所有员工的姓名 

      ```java
      	 /*
           * 测试DBCP连接池
           * */
          public static void main(String[] args) throws SQLException {
              //1.从DBCP连接池中拿到连接
              Connection con = DBCPUtils.getConnection();
              //2.获取Statement对象
              Statement statement = con.createStatement();
              //3.查询所有员工的姓名
              String sql = "select ename from employee";
              ResultSet resultSet = statement.executeQuery(sql);
              //4.处理结果集
              while(resultSet.next()){
                  String ename = resultSet.getString("ename");
                  System.out.println("员工姓名: " + ename);
              }
              //5.释放资源
              DBCPUtils.close(con,statement,resultSet);
          }
      ```

  -  常见配置项 

    | 属性            | 描述           |
    | --------------- | -------------- |
    | driverClassName | 数据库驱动名称 |
    | url             | 数据库地址     |
    | username        | 用户名         |
    | password        | 密码           |
    | maxActive       | 最大连接数量   |
    | maxIdle         | 最大空闲连接   |
    | minIdle         | 最小空闲连接   |
    | initialSize     | 初始化连接     |

- C3P0连接池 

  - C3P0是一个开源的JDBC连接池,支持JDBC3规范和JDBC2的标准扩展。目前使用它的开源项目有Hibernate、 Spring等 

  -  导入jar包及配置文件

    1. 将jar包 复制到myJar文件夹即可,IDEA导入 

       ![](./picture/day25/C3P0连接池准备1.png)

    2.  导入配置文件 c3p0-config.xml  

       -  c3p0-config.xml 文件名不可更改

       -  直接放到src下,也可以放到到资源文件夹中 

         ```xml
         <c3p0-config>
           
           <!--默认配置-->
             <default-config>  
         		<!-- initialPoolSize：初始化时获取三个连接，
         			  取值应在minPoolSize与maxPoolSize之间。 --> 
                 <property name="initialPoolSize">3</property>  
         		
         		<!-- maxIdleTime：最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。-->
                 <property name="maxIdleTime">60</property>  
         		
         		<!-- maxPoolSize：连接池中保留的最大连接数 -->
                 <property name="maxPoolSize">100</property>  
         		<!-- minPoolSize: 连接池中保留的最小连接数 -->
                 <property name="minPoolSize">10</property>  
         		
             </default-config>  
           
            <!--配置连接池mysql-->
         
             <named-config name="mysql">
                 <property name="driverClass">com.mysql.jdbc.Driver</property>
                 <property name="jdbcUrl">jdbc:mysql://localhost:3306/db5?characterEncoding=UTF-8</property>
                 <property name="user">root</property>
                 <property name="password">123456</property>
                 <property name="initialPoolSize">10</property>
                 <property name="maxIdleTime">30</property>
                 <property name="maxPoolSize">100</property>
                 <property name="minPoolSize">10</property>
             </named-config>
             <!--配置连接池2,可以配置多个-->
         
         </c3p0-config>
         ```

    3.  在项目下创建一个resource文件夹(专门存放资源文件) 

       ![](./picture/day25/C3P0连接池准备2.png)

    4. 选择文件夹,右键 将resource文件夹指定为资源文件夹  

       ![](./picture/day25/C3P0连接池准备3.png)

    5.   将文件放在resource目录下即可,创建连接池对象的时候会去加载这个配置文件 

       ​	![](./picture/day25/C3P0连接池准备4.png)

  -  编写C3P0工具类 

    -  C3P0提供的核心工具类, ComboPooledDataSource , 如果想使用连接池,就必须创建该类的对象  

      -  new ComboPooledDataSource(); 使用 默认配置 
      - new ComboPooledDataSource("mysql"); 使用命名配置  

      ```java
      public class C3P0Utils {
      
      //1.创建连接池对象 C3P0对DataSource接口的实现类
          //使用的配置是 配置文件中的默认配置
          //public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
          //使用指定的配置
          public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
      
          //获取连接的方法
          public static Connection getConnection() throws SQLException {
              return dataSource.getConnection();
          }
      
          //释放资源
          public static void close(Connection con, Statement statement) {
              if (con != null && statement != null) {
                  try {
                      statement.close();
      //归还连接
                      con.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
              }
          }
      
          public static void close(Connection con, Statement statement, ResultSet resultSet) {
              if (con != null && statement != null && resultSet != null) {
                  try {
                      resultSet.close();
                      statement.close();
      //归还连接
                      con.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
              }
          }
      }
      ```

  - 测试工具类

    ```java
     //需求 查询姓名为李白的 记录
        public static void main(String[] args) throws SQLException {
    //1.获取连接
            Connection con = C3P0Utils.getConnection();
    //2.获取预处理对象
            String sql = "select * from employee where ename = ?";
            PreparedStatement ps = con.prepareStatement(sql);
    //3.设置占位符的值
            ps.setString(1, "李白");
            ResultSet resultSet = ps.executeQuery();
    //4.处理结果集
            while (resultSet.next()) {
                int eid = resultSet.getInt("eid");
                String ename = resultSet.getString("ename");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                double salary = resultSet.getDouble("salary");
                Date date = resultSet.getDate("empdate");
                System.out.println(eid + " " + ename + " " + age + " " + sex + " " + salary + " "
                        + date);
            }
    //5.释放资源
            C3P0Utils.close(con, ps, resultSet);
        }
    ```

  - 常见配置

    ![](./picture/day25/C3P0连接池常见配置.png)