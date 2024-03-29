# 大数据学习-Java Day10

## 常用类的概述和使用

##  1常用的包

###  1.1包的名称和功能 

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

## 2 Object类的概述（重点）  

#### 2.1 基本概念 

-  java.lang.Object类是Java语言中类层次结构的根类，也就是说任何一个类都是该类的直接或者间 接子类。
-  如果定义一个Java类时没有使用extends关键字声明其父类，则其父类为 java.lang.Object 类。 
- Object类定义了“对象”的基本行为, 被子类默认继承。  

#### 2.2 常用方法

| 方法声明                   | 功能介绍                                                     |
| -------------------------- | ------------------------------------------------------------ |
| Object()                   | 使用无参方式构造对象                                         |
| boolean equals(Object obj) | 用于判断调用对象是否与参数对象相等。<br /> 该方法默认比较两个对象的地址是否相等，与 == 运算符的结果一致 若希望比较两个对象的内容，则需要重写该方法。 <br />若该方法被重写后，则应该重写hashCode方法来保证结果的一致 性。 |
| int hashCode()             | 用于获取调用对象的哈希码值(内存地址的编号)。<br /> 若两个对象调用equals方法相等，则各自调用该方法的结果必须相 同<br /> 若两个调用对象equals方法不相等，则各自调用该方法的结果应该 不相同。 <br />为了使得该方法与equals方法保持一致，需要重写该方法。 |
| String toString()          | 用于获取调用对象的字符串形式 <br />该方法默认返回的字符串为：包名.类名@哈希码值的十六进制 <br />为了返回更有意义的数据，需要重写该方法 <br />使用print或println打印引用或字符串拼接引用都会自动调用该方法 |
| Class <?> getClass()       | 用于返回调用对象执行时的Class实例，反射机制使用              |

##### 案例题目

 编程实现Student类的封装，特征：学号(id)和姓名，要求提供打印所有特征的方法。 

编程实现StudentTest类，在main方法中使用有参方式构造两个Student类型的对象并打印特征。 

##### 题目扩展

 如何实现以姓名作为基准判断两个对象是否相等？以及以学号和姓名同时作为基准判断两个对象是 否相等？ 

```java

import java.util.Objects;

public class Student extends Object {
    private int id; // 用于描述学号的成员变量
    private String name; // 用于描述姓名的成员变量

    public Student() {
    }

    public Student(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("学号不合理哦！！！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

 */
    /**
     * 为了比较两个对象的内容，也就是学号信息需要重写该方法
     */
    // Student this = s1;
    // Object obj = s2;
    /*
    @Override
    public boolean equals(Object obj) {
        // 当调用对象和参数对象指向同一个对象时，则内容一定相同
        if (this == obj) return true;
        // 当调用对象为不为空而参数对象为空时，则内容一定不相同
        if (null == obj) return false;
        // 判断obj指向的对象是否为Student类型的对象，若是则条件成立，否则条件不成立
        if (obj instanceof Student) {
            Student ts = (Student) obj;
            // 以学号作为基准判断两个对象是否相等  int是基本数据类型，内存空间中放的就是数据本身，使用 == 可以判断数据是否相同
            //return this.getId() == ts.getId();
            // 以姓名作为基准判断两个对象是否相等  String是引用数据类型，内存空间中放的是地址，使用 == 判断地址是否相同
            // 也就是判断两个对象中姓名字符串的地址是否相同，不够完美
            //return this.getName() == ts.getName();
            return this.getName().equals(ts.getName()); // 比较姓名字符串的内容是否相同
        }
        // 否则类型不一致没有可比性，则内容一定不相同
        return false;
    }
    */
    /**
     * 为了使得该方法的结果与equals方法的结果保持一致，从而满足Java官方的常规协定，需要重写该方法
     */
    /*
    @Override
    public int hashCode() {
        //return getId(); // 不再代表内存地址的编号了
        final int type = 12;
        //return type*31 + getId();
        return type*31 + getName().hashCode();
    }
    */
    /**
     * 为了返回更有意义的字符串数据，则需要重写该方法
     */
    /*
    @Override
    public String toString() {
        return "Student[id = " + getId() + ", name = " + getName() + "]";
    }
     */
}

```

```java  

public class StudentTest {

    public static void main(String[] args) {

        // 1.使用有参方式构造Student类型的两个对象并判断是否相等
        Student s1 = new Student(1001, "zhangfei");
        //Student s2 = new Student(1002, "guanyu");
        Student s2 = new Student(1001, "zhangfei");
        //Student s2 = s1;  // 表示s2和s1都指向了同一个对象，地址相同了
        // 下面调用从Object类中继承下来的equals方法，该方法默认比较两个对象的地址，可以查看源码验证
        // 当Student类中重写equals方法后，则调用重写以后的版本，比较内容
        //boolean b1 = s1.equals(s2);
        //Student s3 = null;
        //boolean b1 = s1.equals(s3);
        //Student s3 = s1;
        boolean b1 = s1.equals(s2);
        System.out.println("b1 = " + b1); // false true
        System.out.println(s1 == s2); // 比较地址  false

        System.out.println("----------------------------------------------------------");
        // 下面调用从Object类中继承下来的hashCode方法，获取调用对象的哈希码值(内存地址的编号)
        // 当Student类中重写hashCode方法后，则调用重写以后的版本
        int ia = s1.hashCode();
        int ib = s2.hashCode();
        System.out.println("ia = " + ia);
        System.out.println("ib = " + ib);

        System.out.println("----------------------------------------------------------");
        // 下面调用从Object类中继承下来的toString方法，获取调用对象的字符串形式：包名.类名@哈希码值的十六进制
        // 当Student类中重写toString方法后，则调用重写以后的版本：Student[id = 1001, name = zhangfei]
        String str1 = s1.toString();
        System.out.println("str1 = " + str1); // com.lagou.task11.Student@55d
        System.out.println(s1); // 当打印一个引用变量时会自动调用toString方法
        String str2 = "hello" + s1;
        System.out.println("str2 = " + str2);
    }
}
```



## 3 包装类

####   3.1包装类的概念 

-  通常情况下基本数据类型的变量不是对象，为了满足万物皆对象的理念就需要对基本数据类型的变 量进行打包封装处理变成对象，而负责将这些变量声明为成员变量进行对象化处理的相关类，叫做包装 类。  

- ```java
  Person p = new Person();
  int num = 10;
  public class MyInt{
      private int num =10;
  }
  ```

####   3.2包装类的分类 

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

####  3.3Integer类的概述 

-  基本概念 
  -  java.lang.Integer类内部包装了一个int类型的变量作为成员变量，主要用于实现对int类型的包装并 提供int类型到String类之间的转换等方法。  
- 常用的常量  

| 常量类型和名称                          | 功能介绍                              |
| --------------------------------------- | ------------------------------------- |
| public static final int MAX_VALUE       | 表示int类型可以描述的最大值，即2^31-1 |
| public static final int MIN_VALUE       | 表示int类型可以描述的最小值，即-2^31  |
| public static final int SIZE            | 表示int类型采用二进制补码形式的位数   |
| public static final int BYTES           | 表示int类型所占的字节个数             |
| public static final Class<Integer> TYPE | 表示int类型的Class实例                |

- 常用的方法

| 方法声明                            | 功能介绍                                  |
| ----------------------------------- | ----------------------------------------- |
| Integer(int value)                  | 根据参数指定的整数来构造对象（已过时）    |
| Integer(String s)                   | 根据参数指定的字符串来构造对象 （已过时） |
| int intValue()                      | 获取调用对象中的整数值并返回              |
| static Integer valueOf(int i)       | 根据参数指定整数值得到Integer类型对象     |
| boolean equals(Object obj)          | 比较调用对象与参数指定的对象是否相等      |
| String toString()                   | 返回描述调用对象数值的字符串形式          |
| static int parseInt(String s)       | 将字符串类型转换为int类型并返回           |
| static String toString(int i)       | 获取参数指定整数的十进制字符串形式        |
| static String toBinaryString(int i) | 获取参数指定整数的二进制字符串形式        |
| static String toHexString(int i)    | 获取参数指定整数的十六进制字符串形式      |
| static String toOctalString(int i)  | 获取参数指定整数的八进制字符串形式        |

- 装箱和拆箱的概念
  -  在Java5发布之前使用包装类对象进行运算时，需要较为繁琐的“拆箱”和“装箱”操作；即运算前先将 包装类对象拆分为基本类型数据，运算后再将结果封装成包装类对象。 
  - 从Java5开始增加了自动拆箱和自动装箱的功能。  
-  自动装箱池 
  -  在Integer类的内部提供了自动装箱池技术，将-128到127之间的整数已经装箱完毕，当程序中使用 该范围之间的整数时，无需装箱直接取用自动装箱池中的对象即可，从而提高效率。 

```java

public class IntegerTest {

    public static void main(String[] args) {

        // 1.打印Integer类中常用的常量数值
        System.out.println("最大值是：" + Integer.MAX_VALUE); // 2^31-1
        System.out.println("最小值是：" + Integer.MIN_VALUE); // -2^31
        System.out.println("所表示二进制的位数是：" + Integer.SIZE); // 32
        System.out.println("所占字节的个数是：" + Integer.BYTES); // 4
        System.out.println("对应int类型的Class实例是：" + Integer.TYPE); // int

        System.out.println("------------------------------------------------------");
        // 2.使用构造方法来构造Integer类型的对象并打印
        //Integer it1 = new Integer(123);
        //System.out.println("it1 = " + it1); // 自动调用toString方法   123
        //Integer it2 = new Integer("456");
        //System.out.println("it2 = " + it2); // 456
        // 上述方法已过时，建议使用valueOf方法取代之，相当于从int类型到Integer类型的转换，叫做装箱
        Integer it3 = Integer.valueOf(123);
        System.out.println("it3 = " + it3); // 123
        // 相当于从String类型到Integer类型的转换
        Integer it4 = Integer.valueOf("456");
        System.out.println("it4 = " + it4); // 456   自动调用toString方法得到的是String类型
        // 获取调用对象中的整数数值，相当于从Integer类型到int类型的转换，叫做拆箱
        int ia = it4.intValue();
        System.out.println("获取到的整数数据是：" + ia); // 456  得到的是int类型

        System.out.println("------------------------------------------------------");
        // 3.从Java5开始增加了自动装箱和自动拆箱的机制
        Integer it5 = 100;  // 直接通过赋值运算符实现自动装箱
        int ib = it5;       // 直接通过赋值运算符实现自动拆箱

        System.out.println("------------------------------------------------------");
        // 4.装箱和拆箱的笔试考点
        Integer it6 = 127; //128;
        Integer it7 = 127; //128;
        Integer it8 = new Integer(127); //new Integer(128);
        Integer it9 = new Integer(127); //new Integer(128);
        System.out.println(it6 == it7);      // 比较地址  false  true  地址一样
        System.out.println(it6.equals(it7)); // 比较内容  true
        System.out.println(it8 == it9);      // 比较地址  false
        System.out.println(it8.equals(it9)); // 比较内容  true

        System.out.println("------------------------------------------------------");
        // 5.实现静态方法的调用
        int ic = Integer.parseInt("200");
        //int ic = Integer.parseInt("200a"); // 编译ok,运行发生NumberFormatException数字格式异常，因为有字母
        System.out.println("字符串转换为整数的结果是：" + ic); // 200
        System.out.println("根据参数指定的整数获取对应的十进制字符串是：" + Integer.toString(200));
        System.out.println("根据参数指定的整数获取对应的二进制字符串是：" + Integer.toBinaryString(200));
        System.out.println("根据参数指定的整数获取对应的十六进制字符串是：" + Integer.toHexString(200));
        System.out.println("根据参数指定的整数获取对应的八进制字符串是：" + Integer.toOctalString(200));
    }
}
```



#### 3.4  Double类的概述 

- 基本概念

  -  java.lang.Double类型内部包装了一个double类型的变量作为成员变量，主要用于实现对double 类型的包装并提供double类型到String类之间的转换等方法。 

- 常用的常量

  | 常量类型和名称                         | 功能介绍                   |
  | -------------------------------------- | -------------------------- |
  | public static final int SIZE           | 表示double类型的二进制位数 |
  | public static final int BYTES          | 表示double类型的字节个数   |
  | public static final Class<Double> TYPE | 表示double类型的Class实例  |

-  常用的方法 

  - | 方法声明                            | 功能介绍                                   |
    | ----------------------------------- | ------------------------------------------ |
    | Double(double value)                | 根据参数指定的浮点数据来构造对象（已过时） |
    | Double(String s)                    | 根据参数指定的字符串来构造对象 （已过时）  |
    | double doubleValue()                | 获取调用对象中的浮点数据并返回             |
    | static Double valueOf(double d)     | 根据参数指定浮点数据得到Double类型对象     |
    | boolean equals(Object obj)          | 比较调用对象与参数指定的对象是否相等       |
    | String toString()                   | 返回描述调用对象数值的字符串形式           |
    | static double parseDouble(String s) | 将字符串类型转换为double类型并返回         |
    | boolean isNaN()                     | 判断调用对象的数值是否为非数字             |

-  扩展： 

  - java.lang.Number类是个抽象类，是上述类的父类来描述所有类共有的成员。 

```java
public class DoubleTest {

    public static void main(String[] args) {

        // 1.在Java5之前装箱和拆箱的实现
        // 实现了从double类型到Double类型的转换，装箱
        Double db1 = Double.valueOf(3.14);
        System.out.println("db1 = " + db1); // 3.14
        // 实现了从Double类型到double类型的转换，拆箱
        double d1 = db1.doubleValue();
        System.out.println("d1 = " + d1); // 3.14

        System.out.println("---------------------------------------------");
        // 2.从Java5开始实现自动装箱和自动拆箱
        Double db2 = 3.14;
        double d2 = db2;

        System.out.println("---------------------------------------------");
        // 3.实现静态方法和成员方法的调用
        double d3 = Double.parseDouble("13.14");
        System.out.println("d3 = " + d3); // 13.14

        System.out.println("db2对象的判断结果是：" + db2.isNaN()); // false 不是非数字
        Double db3 = Double.valueOf(0/0.0);
        System.out.println("db2对象的判断结果是：" + db3.isNaN()); // true  是非数字


    }
}
```



#### 3.5   Boolean类的概述  

-  基本概念 
  -  java.lang.Boolean类型内部包装了一个boolean类型的变量作为成员变量，主要用于实现对 boolean类型的包装并提供boolean类型到String类之间的转换等方法 
-  常用的常量  

| 常量类型和名称                          | 功能介绍                   |
| --------------------------------------- | -------------------------- |
| public static final Boolean FALSE       | 对应基值为false的对象      |
| public static final Boolean TRUE        | 对应基值为true的对象       |
| public static final Class<Boolean> TYPE | 表示boolean类型的Class实例 |

- 常用方法

| 方法声明                              | 功能介绍                                   |
| ------------------------------------- | ------------------------------------------ |
| Boolean(boolean value)                | 根据参数指定的布尔数值来构造对象（已过时） |
| Boolean(String s)                     | 根据参数指定的字符串来构造对象 （已过时）  |
| boolean booleanValue()                | 获取调用对象中的布尔数值并返回             |
| static Boolean valueOf(boolean b)     | 根据参数指定布尔数值得到Boolean类型对象    |
| boolean equals(Object obj)            | 比较调用对象与参数指定的对象是否相等       |
| String toString()                     | 返回描述调用对象数值的字符串形式           |
| static boolean parseBoolean(String s) | 将字符串类型转换为boolean类型并返回        |

```java

public class BooleanTest {

    public static void main(String[] args) {

        // 1.在Java5之前采用方法进行装箱和拆箱
        // 相当于从boolean类型到Boolean类型的转换，装箱
        Boolean bo1 = Boolean.valueOf(true);
        System.out.println("bo1 = " + bo1); // true
        boolean b1 = bo1.booleanValue();
        System.out.println("b1 = " + b1); // true

        System.out.println("----------------------------------------------");
        // 2.从Java5开始支持自动装箱和拆箱
        Boolean bo2 = false;
        boolean b2 = bo2;
        System.out.println("b2 = " + b2); // false

        System.out.println("----------------------------------------------");
        // 3.实现从String类型到boolean类型的转换
        //boolean b3 = Boolean.parseBoolean("112");
        // 该方法的执行原理是：只要参数数值不为true或者TRUE时，则结果就是false，查手册和源码
        boolean b3 = Boolean.parseBoolean("TRUE");
        System.out.println("b3 = " + b3); // true
    }
}

```



#### 3.6  Character类的概述 

- 基本概念
  -  java.lang.Character类型内部包装了一个char类型的变量作为成员变量，主要用于实现对char类型 的包装并提供字符类别的判断和转换等方法。 
-  常用的常量 

| 常量类型和名称                            | 功能介绍                 |
| ----------------------------------------- | ------------------------ |
| public static final int SIZE              | 表示char类型的二进制位数 |
| public static final int BYTES             | 表示char类型的字节个数   |
| public static final Class<Character> TYPE | 表示char类型的Class实例  |

- 常用方法

| 方法声明                            | 功能介绍                                   |
| ----------------------------------- | ------------------------------------------ |
| Character(char value)               | 根据参数指定的字符数据来构造对象（已过时） |
| char charValue()                    | 获取调用对象中的字符数据并返回             |
| static Character valueOf(char c)    | 根据参数指定字符数据得到Character类型对象  |
| boolean equals(Object obj)          | 比较调用对象与参数指定的对象是否相等       |
| String toString()                   | 返回描述调用对象数值的字符串形式           |
| static boolean isUpperCase(char ch) | 判断参数指定字符是否为大写字符             |
| static boolean isLowerCase(char ch) | 判断参数指定字符是否为小写字符             |
| static boolean isDigit(char ch)     | 判断参数指定字符是否为数字字符             |
| static char toUpperCase(char ch)    | 将参数指定的字符转换为大写字符             |
| static char toLowerCase(char ch)    | 将参数指定的字符转换为小写字符             |

```java
public class CharacterTest {

    public static void main(String[] args) {

        // 1.在Java5之前调用方法实现装箱和拆箱机制
        // 相当于从char类型到Character类型的转换，装箱
        Character ca1 = Character.valueOf('a');
        System.out.println("ca1 = " + ca1); // a
        // 从Character类型向char类型的转换，拆箱
        char c1 = ca1.charValue();
        System.out.println("c1 = " + c1); // a

        System.out.println("----------------------------------------");
        // 2.从Java5开始支持自动装箱和拆箱
        Character ca2 = 'b';
        char c2 = ca2;
        System.out.println("c2 = " + c2); // b

        System.out.println("----------------------------------------");
        // 3.实现字符类型的判断以及转换
        System.out.println(Character.isUpperCase(c2)); // 判断是否为大写字母  false
        System.out.println(Character.isLowerCase(c2)); // 判断是否为小写字母  true
        System.out.println(Character.isDigit(c2));     // 判断是否为数字字符  false
        System.out.println("转换为大写字符是：" + Character.toUpperCase(c2)); // B
        System.out.println("转换为小写字符是：" + Character.toLowerCase(c2)); // b
    }
}

```



#### 3.7  包装类（Wrapper）的使用总结  

-  基本数据类型转换为对应包装类的方式 
  - 调用包装类的构造方法或静态方法即可
-  获取包装类对象中基本数据类型变量数值的方式 
  - 调用包装类中的xxxValue方法即可 
- 字符串转换为基本数据类型的方式 
  - 调用包装类中的parseXxx方法即可 

## 4  数学处理类

#### 4.1  Math类的概述 

- 基本概念
  -  java.lang.Math类主要用于提供执行数学运算的方法，如：对数，平方根。  
- 常用方法

| 方法声明                              | 功能介绍                 |
| ------------------------------------- | ------------------------ |
| static int max(int a, int b)          | 返回两个参数中的最大值   |
| static int min(int a, int b)          | 返回两个参数中的最小值   |
| static double pow(double a, double b) | 返回第一个参数的幂       |
| static int abs(int a)                 | 返回参数指定数值的绝对值 |
| static long round(double a)           | 返回参数四舍五入的结果   |
| static double sqrt(double a)          | 返回参数的平方根         |
| static double random()                | 返回0.0到1.0的随机数     |

```java

public class MathTest {

    public static void main(String[] args) {

        System.out.println("获取两个整数中最大值的结果是：" + Math.max(10, 20)); // 20
        System.out.println("获取两个整数中最小值的结果是：" + Math.min(10, 20)); // 10
        System.out.println("获取次方的结果是：" + Math.pow(2, 3)); // 8.0  体现double类型
        System.out.println("获取绝对值的结果是：" + Math.abs(-5)); // 5
        System.out.println("进行四舍五入的结果是：" + Math.round(3.14)); // 3
        System.out.println("该整数的平方根是：" + Math.sqrt(16)); // 4.0
        System.out.println("生成的随机数是：" + Math.random()); // 随机数
    }
}

```



#### 4.2   BigDecimal类的概述 

-  基本概念 
  - 由于float类型和double类型在运算时可能会有误差，若希望实现精确运算则借助 java.math.BigDecimal类型加以描述。 
- 常用方法

| 方法声明                                     | 功能介绍                       |
| -------------------------------------------- | ------------------------------ |
| BigDecimal(String val)                       | 根据参数指定的字符串来构造对象 |
| BigDecimal add(BigDecimal augend)            | 用于实现加法运算               |
| BigDecimal subtract(BigDecimal subtrahend)   | 用于实现减法运算               |
| BigDecimal multiply(BigDecimal multiplicand) | 用于实现乘法运算               |
| BigDecimal divide(BigDecimal divisor)        | 用于实现除法运算               |

```java

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {

        // 1.构造BigDecimal类型的两个对象
        BigDecimal bd1 = new BigDecimal("5.2");
        BigDecimal bd2 = new BigDecimal("1.3");
        // 2.使用构造完毕的对象实现加减乘除运算
        System.out.println("实现加法运算的结果是：" + bd1.add(bd2)); // 6.5
        System.out.println("实现减法运算的结果是：" + bd1.subtract(bd2)); // 3.9
        System.out.println("实现乘法运算的结果是：" + bd1.multiply(bd2)); // 6.76
        System.out.println("实现除法运算的结果是：" + bd1.divide(bd2)); // 4

        System.out.println("---------------------------------------------------------------");
        // 3.实现精确运算
        System.out.println(0.1 + 0.2); // 0.30000000000000004
        BigDecimal bd3 = new BigDecimal("0.1");
        BigDecimal bd4 = new BigDecimal("0.2");
        System.out.println("精确计算的结果是：" + bd3.add(bd4)); // 0.3

        System.out.println("---------------------------------------------------------------");
        // 4.注意事项
        BigDecimal bd5 = new BigDecimal("2");
        BigDecimal bd6 = new BigDecimal("0.3");
        System.out.println("除法运算的结果是：" + bd5.divide(bd6, RoundingMode.HALF_UP)); // 7
    }
}
```



#### 4.3   BigInteger类的概述 

- 基本概念

  -  若希望表示比long类型范围还大的整数数据，则需要借助java.math.BigInteger类型描述。  

- 常用方法

  - | 方法声明                                        | 功能介绍                       |
    | ----------------------------------------------- | ------------------------------ |
    | BigInteger(String val)                          | 根据参数指定的字符串来构造对象 |
    | BigInteger add(BigInteger val)                  | 用于实现加法运算               |
    | BigInteger subtract(BigInteger val)             | 用于实现减法运算               |
    | BigInteger multiply(BigInteger val)             | 用于实现乘法运算               |
    | BigInteger divide(BigInteger val)               | 用于实现除法运算               |
    | BigInteger remainder(BigInteger val)            | 用于实现取余运算               |
    | BigInteger[] divideAndRemainder(BigInteger val) | 用于实现取商和余数的运算       |

```java

import java.math.BigInteger;

public class BigIntegerTest {

    public static void main(String[] args) {

        // 1.构造两个BigInteger类型的对象并指定初始值
        BigInteger bi1 = new BigInteger("20");
        BigInteger bi2 = new BigInteger("8");
        // 2.实现加减乘除取余操作并打印
        System.out.println("实现加法运算的结果是：" + bi1.add(bi2)); // 28
        System.out.println("实现减法运算的结果是：" + bi1.subtract(bi2)); // 12
        System.out.println("实现乘法运算的结果是：" + bi1.multiply(bi2)); // 160
        System.out.println("实现除法运算的结果是：" + bi1.divide(bi2)); // 2
        System.out.println("实现取余运算的结果是：" + bi1.remainder(bi2)); // 4

        System.out.println("-----------------------------------------------------");
        // 3.一次性得到商和余数
        BigInteger[] arr = bi1.divideAndRemainder(bi2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("下标为" + i + "的元素是：" + arr[i]); // 2 4
        }
    }
}

```

