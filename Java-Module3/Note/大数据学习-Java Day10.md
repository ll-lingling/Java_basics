# 大数据学习-Java Day10

##  常用的包（熟悉） 

###  包的名称和功能 

-  java.lang包 - 该包是Java语言的核心包，并且该包中的所有内容由Java虚拟机自动导入。 
  - 如：System类、String类、... 
- java.util包 - 该包是Java语言的工具包，里面提供了大量工具类以及集合类等。
  -  如：Scanner类、Random类、List集合、... 
- java.io包 - 该包是Java语言中的输入输出包，里面提供了大量读写文件相关的类等。 
  - 如：FileInputStream类、FileOutputStream类、...
-  java.net包 - 该包是Java语言中的网络包，里面提供了大量网络编程相关的类等。 
  - 如：ServerSocket类、Socket类、... 
- java.sql 包 - 该包是Java语言中的数据包，里面提供了大量操作数据库的类和接口等。 
  - 如：DriverManager类、Connection接口、… 
- ... ... 
- Java程序员在编程时可以使用大量类库，因此Java编程时需要记的很多，对编程能力本身要求不是 特别的高。  

###  Object类的概述（重点）  

#### 基本概念 

-  java.lang.Object类是Java语言中类层次结构的根类，也就是说任何一个类都是该类的直接或者间 接子类。
-  如果定义一个Java类时没有使用extends关键字声明其父类，则其父类为 java.lang.Object 类。 
- Object类定义了“对象”的基本行为, 被子类默认继承。  

#### 常用方法

| 方法声明                   | 功能介绍                                                     |
| -------------------------- | ------------------------------------------------------------ |
| Object()                   | 使用无参方式构造对象                                         |
| boolean equals(Object obj) | 用于判断调用对象是否与参数对象相等。<br /> 该方法默认比较两个对象的地址是否相等，与 == 运算符的结果一致 若希望比较两个对象的内容，则需要重写该方法。 <br />若该方法被重写后，则应该重写hashCode方法来保证结果的一致 性。 |
| int hashCode()             | 用于获取调用对象的哈希码值(内存地址的编号)。<br /> 若两个对象调用equals方法相等，则各自调用该方法的结果必须相 同<br /> 若两个调用对象equals方法不相等，则各自调用该方法的结果应该 不相同。 <br />为了使得该方法与equals方法保持一致，需要重写该方法。 |
| String toString()          | 用于获取调用对象的字符串形式 <br />该方法默认返回的字符串为：包名.类名@哈希码值的十六进制 为了返回更有意义的数据，需要重写该方法 <br />使用print或println打印引用或字符串拼接引用都会自动调用该方法 |
| Class getClass()           | 用于返回调用对象执行时的Class实例，反射机制使用              |

##### 案例题目

 编程实现Student类的封装，特征：学号(id)和姓名，要求提供打印所有特征的方法。 

编程实现StudentTest类，在main方法中使用有参方式构造两个Student类型的对象并打印特征。 

##### 题目扩展

 如何实现以姓名作为基准判断两个对象是否相等？以及以学号和姓名同时作为基准判断两个对象是 否相等？ 

 ### 包装类（熟悉） 

####   包装类的概念 

-  通常情况下基本数据类型的变量不是对象，为了满足万物皆对象的理念就需要对基本数据类型的变 量进行打包封装处理变成对象，而负责将这些变量声明为成员变量进行对象化处理的相关类，叫做包装 类。  

- ```java
  Person p = new Person();
   int num = 10;
  
  ```

####   包装类的分类 

| 包装类              | 对应的基本类型 |
| ------------------- | -------------- |
| java.lang.Byte      | byte           |
| java.lang.Short     | short          |
| java.lang.Integer   | int            |
| java.lang.Long      | long           |
| java.lang.Float     | float          |
| java.lang.Double    | double         |
| java.lang.Boolean   | boolean        |
| java.lang.Character | char           |

#### 类的描述

-  基本概念 
  - java.lang.Integer类内部包装了一个int类 

-  常用的常量  

  

| 常量类型和名称                    | 功能介绍                              |
| --------------------------------- | ------------------------------------- |
| public static final int MAX_VALUE | 表示int类型可以描述的最大值，即2^31-1 |
| public static final int MIN_VALUE | 表示int类型可以描述的最小值，即-2^31  |
| public static final int SIZE      | 表示int类型采用二进制补码形式的位数   |
| public static final int BYTES     | 表示int类型所占的字节个数             |
| public static final Class TYPE    | 表示int类型的Class实例                |

#### 常用方法

