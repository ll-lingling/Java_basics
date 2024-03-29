# 大数据学习-Java Day12

## 可变字符串类和日期相关类

##  1 可变字符串类（重点） 

- 基本概念
  -  由于String类描述的字符串内容是个常量不可改变，当需要在Java代码中描述大量类似的字符串 时，只能单独申请和存储，此时会造成内存空间的浪费。 
  - 为了解决上述问题，可以使用java.lang.StringBuilder类和java.lang.StringBuffer类来描述字符序 列可以改变的字符串，如："ab"。 
  - StringBuffer类是从jdk1.0开始存在，属于线程安全的类，因此效率比较低。 
  - StringBuilder类是从jdk1.5开始存在，属于非线程安全的类，效率比较高。 

#### StringBuilder类常用的构造方法 

| 方法声明                    | 功能介绍                                              |
| --------------------------- | ----------------------------------------------------- |
| StringBuilder()             | 使用无参方式构造对象，容量为16                        |
| StringBuilder(int capacity) | 根据参数指定的容量来构造对象，容量为参数指定大小      |
| StringBuilder(String str)   | 根据参数指定的字符串来构造对象，容量为：16+字符串长度 |

#### StringBuilder类常用的成员方法 

| 方法声明                                               | 功能介绍                                     |
| ------------------------------------------------------ | -------------------------------------------- |
| int capacity()                                         | 用于返回调用对象的容量                       |
| int length()                                           | 用于返回字符串的长度，也就是字符的个数       |
| StringBuilder insert(int offset, String str)           | 插入字符串并返回调用对象的引用，就是自己     |
| StringBuilder append(String str)                       | 追加字符串                                   |
| StringBuilder deleteCharAt(int index)                  | 将当前字符串中下标为index位置的单个字符 删除 |
| StringBuilder delete(int start，int end)               | 删除字符串                                   |
| StringBuilder replace(int start，int end， String str) | 替换字符串                                   |
| StringBuilder reverse()                                | 字符串反转                                   |

- 注意： 作为参数传递的话，方法内部String不会改变其值，StringBuffer和StringBuilder会改变其值。 

-  返回值的设计
  -  StringBuilder的很多方法的返回值均为StringBuilder类型。这些方法的返回语句均为：return this。 
  - 由此可见，这些方法在对StringBuilder所封装的字符序列进行改变后又返回了该对象的引用。基 于这样设计的目的在于可以连续调用。  

```java

public class StringBuilderTest {

    public static void main(String[] args) {

        // 1.使用无参方式构造StringBuilder类型的对象并打印容量和长度
        StringBuilder sb1 = new StringBuilder();
        System.out.println("sb1 = " + sb1); // 自动调用toString方法 啥也没有
        System.out.println("容量是：" + sb1.capacity()); // 16
        System.out.println("长度是：" + sb1.length()); // 0

        System.out.println("-----------------------------------------------------------");
        // 2.使用参数指定的容量来构造对象并打印容量和长度
        StringBuilder sb2 = new StringBuilder(20);
        System.out.println("sb2 = " + sb2); // 自动调用toString方法 啥也没有
        System.out.println("容量是：" + sb2.capacity()); // 20
        System.out.println("长度是：" + sb2.length()); // 0

        System.out.println("-----------------------------------------------------------");
        // 3.根据参数指定的字符串内容来构造对象并打印容量和长度
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println("sb3 = " + sb3); // 自动调用toString方法  hello
        System.out.println("容量是：" + sb3.capacity()); // 16 + 5 = 21
        System.out.println("长度是：" + sb3.length()); // 5

        System.out.println("-----------------------------------------------------------");
        String str1 = new String("hello");
        String str2 = str1.toUpperCase();
        System.out.println("str2 = " + str2); // HELLO
        System.out.println("str1 = " + str1); // hello  字符串本身是个常量不会改变

        // 4.实现向字符串中插入和追加字符串内容
        // 向下标为0的位置插入字符串内容"abcd"，也就是向开头位置插入字符串内容
        StringBuilder sb4 = sb3.insert(0, "abcd");
        System.out.println("sb4 = " + sb4); // abcdhello  返回调用对象自己的引用，也就是返回值和调用对象是同一个字符串
        System.out.println("sb3 = " + sb3); // abcdhello
        // 向中间位置插入字符串"1234"
        sb3.insert(4, "1234");
        System.out.println("sb3 = " + sb3); // abcd1234hello
        // 向末尾位置插入字符串"ABCD"
        sb3.insert(sb3.length(), "ABCD");
        System.out.println("sb3 = " + sb3); // abcd1234helloABCD

        System.out.println("-----------------------------------------------------------");
        // 向末尾位置追加字符串内容
        sb3.append("world");
        System.out.println("sb3 = " + sb3); // abcd1234helloABCDworld
        // 当字符串的长度超过了字符串对象的初始容量时，该字符串对象会自动扩容，默认扩容算法是：原始容量*2 + 2 => 21*2 + 2 => 44
        // 底层采用byte数组来存放所有的字符内容。
        // ctrl+alt+左右方向键  表示回到上/下一个位置
        System.out.println("容量是：" + sb3.capacity()); // 44
        System.out.println("长度是：" + sb3.length()); // 22

        System.out.println("-----------------------------------------------------------");
        // 5.实现字符串中字符和字符串的删除
        // 表示删除下标为8的单个字符
        sb3.deleteCharAt(8);
        System.out.println("sb3 = " + sb3); // abcd1234elloABCDworld
        // 使用for循环删除多个字符
        for (int i = 8; i < 12; i++) {
            // 由结果可知：删除一个字符后就跳过一个字符继续删除，因为每当删除一个字符后后面的字符会向前补位，因为下标会发生变化
            //sb3.deleteCharAt(i);
            // 始终删除下标为8的字符
            sb3.deleteCharAt(8);
        }
        System.out.println("删除后的字符串是：" + sb3); // abcd1234ABCDworld

        System.out.println("-----------------------------------------------------------");
        // 删除起始字符串abcd，包含0但不包含4
        sb3.delete(0, 4);
        System.out.println("sb3 = " + sb3); // 1234ABCDworld
        // 删除中间字符串
        sb3.delete(4, 8);
        System.out.println("sb3 = " + sb3); // 1234world
        // 删除末尾字符串
        sb3.delete(4, sb3.length());
        System.out.println("sb3 = " + sb3); // 1234

        System.out.println("-----------------------------------------------------------");
        // 6.实现字符串内容的修改、查找以及反转操作
        // 表示将下标为0这个位置的字符修改为'a'
        sb3.setCharAt(0, 'a');
        System.out.println("修改单个字符后的内容是：" + sb3); // a234
        // 修改"234"为"bcd"
        sb3.replace(1, 4, "bcd");
        System.out.println("修改字符串后的结果是：" + sb3); // abcd
        // 实现查找的功能
        int pos = sb3.indexOf("b");
        System.out.println("从前向后查找的结果是：" + pos); // 1
        pos = sb3.lastIndexOf("b");
        System.out.println("从后向前查找的结果是：" + pos); // 1
        // 实现字符串的反转功能
        sb3.reverse();
        System.out.println("反转后的结果是：" + sb3); // dcba

        System.out.println("-----------------------------------------------------------");
        // 7.笔试考点
        // 考点一：既然StringBuilder类的对象本身可以修改，那么为什么成员方法还有返回值呢？
        // 解析：为了连续调用
        //sb3.reverse().append("1").append("2").insert(0, "3").delete(0, 1).reverse();
        // 考点二：如何实现StringBuilder类型和String类型之间的转换呢？
        //String str3 = sb3.toString();
        //StringBuilder sb5 = new StringBuilder(str3);
        // 考点三：String、StringBuilder、StringBuffer之间效率谁高？排列如何？
        // String < StringBuffer < StringBuilder
    }
}

```



##   2 Java8之前的日期相关类 

### 2.1 System类的概述 

-  基本概念

  -  Java.lang.System类中提供了一些有用的类字段和方法。  

- 常用方法

  | 方法声明                        | 功能介绍                                                     |
  | ------------------------------- | ------------------------------------------------------------ |
  | static long currentTimeMillis() | 返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时 间差 |
  
  ```java
  
  public class SystemTest {
  
      public static void main(String[] args) {
  
          // 1.获取当前系统时间距离1970年1月1日0时0分0秒的毫秒数
          long msec = System.currentTimeMillis();
          System.out.println("当前系统时间距离1970年1月1日0时0分0秒已经过去" + msec + "毫秒了！");
  
          // 通常用于测试某一段代码的执行效率
      }
  }
  
  ```
  
  

### 2.2   Date类的概述 

- 基本概念

  -  java.util.Date类主要用于描述特定的瞬间，也就是年月日时分秒，可以精确到毫秒。 

- 常用方法

  | 方法声明                | 功能介绍                                                     |
  | ----------------------- | ------------------------------------------------------------ |
  | Date()                  | 使用无参的方式构造对象，也就是当前系统时间                   |
  | Date(long date)         | 根据参数指定毫秒数构造对象， 参数为距离1970年1月1日0时0分0秒 的毫秒数 |
  | long getTime()          | 获取调用对象距离1970年1月1日0时0分0秒的毫秒数                |
  | void setTime(long time) | 设置调用对象为距离基准时间time毫秒的时间点                   |
  
  ```java
  
  import java.util.Date;
  
  public class DateTest {
  
      public static void main(String[] args) {
  
          // 1.使用无参方式构造Date对象并打印
          Date d1 = new Date();
          System.out.println("d1 = " + d1); // 获取当前系统时间
  
          System.out.println("------------------------------------");
          // 2.使用参数指定的毫秒数来构造Date对象并打印  1秒 = 1000毫秒  东八区
          Date d2 = new Date(1000);
          System.out.println("d2 = " + d2); // 1970 1 1 8 0 1
  
          System.out.println("------------------------------------");
          // 3.获取调用对象距离1970年1月1日0时0分0秒的毫秒数
          long msec = d2.getTime();
          System.out.println("获取到的毫秒数是：" + msec); // 1000
  
          // 4.设置调用对象所表示的时间点为参数指定的毫秒数
          d2.setTime(2000);
          System.out.println("修改后的时间是：" + d2); // 1970 1 1 8 0 2
      }
  }
  
  ```
  
  

### 2.3   SimpleDateFormat类的概述 

- 基本概念

  -  java.text.SimpleDateFormat类主要用于实现日期和文本之间的转换。  

- 常用方法

  | 方法声明                         | 功能介绍                                                     |
  | -------------------------------- | ------------------------------------------------------------ |
  | SimpleDateFormat()               | 使用无参方式构造对象                                         |
  | SimpleDateFormat(String pattern) | 根据参数指定的模式来构造对象，模式主要有: y-年 M-月 d-日 H-时 m-分 s-秒 |
  | final String format(Date date)   | 用于将日期类型转换为文本类型                                 |
  | Date parse(String source)        | 用于将文本类型转换为日期类型                                 |

  ```java
  
  import java.text.SimpleDateFormat;
  import java.util.Date;
  
  public class SimpleDateFormatTest {
  
      public static void main(String[] args) throws Exception {
  
          // 1.获取当前系统时间并打印
          Date d1 = new Date();
          System.out.println("d1 = " + d1);
  
          // 2.构造SimpleDateFormat类型的对象并指定格式
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          // 3.实现日期类型向文本类型的转换并打印
          // alt+Enter 可以实现返回值的生成
          String format = sdf.format(d1);
          System.out.println("转换后的日期为：" + format);
          // 4.实现文本类型到日期类型的转换并打印
          Date parse = sdf.parse(format);
          System.out.println("转回日期格式的结果为：" + parse);
      }
  }
  
  ```
  
  

### 2.4  Calendar类的概述 

- 基本概念

  -  java.util.Calender类主要用于描述特定的瞬间，取代Date类中的过时方法实现全球化。 
  - 该类是个抽象类，因此不能实例化对象，其具体子类针对不同国家的日历系统，其中应用最广泛的 是GregorianCalendar（格里高利历），对应世界上绝大多数国家/地区使用的标准日历系统。  

- 常用方法

  | 方法声明                                                     | 功能介绍                          |
  | ------------------------------------------------------------ | --------------------------------- |
  | static Calendar getInstance()                                | 用于获取Calendar类型的引 用       |
  | void set(int year, int month, int date, int hourOfDay, int minute, int second) | 用于设置年月日时分秒信息          |
  | Date getTime()                                               | 用于将Calendar类型转换为 Date类型 |
  | void set(int field, int value)                               | 设置指定字段的数值                |
  | void add(int field, int amount)                              | 向指定字段增加数值                |

  

- 多态的使用场合

  -  通过方法的参数传递形成多态； 

    ```java
    public static void draw(Shape s){ 
        s.show(); 
    } 
    draw(new Rect(1, 2, 3, 4)); 
    ```

  -  在方法体中直接使用多态的语法格式 

    ```java
    Account acc = new FixedAccount(); 
    ```

  -  通过方法的返回值类型形成多态 

    ```java
    Calender getInstance(){
     return new GregorianCalendar(zone, aLocale);
     }
    
    ```

```java

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) {

        // 1.使用过时的方法按照指定的年月日时间分来构造对象
        Date d1 = new Date(2008-1900, 8-1, 8, 20, 8, 8);
        // 2.设置日期对象的格式并打印
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d1);
        System.out.println("获取到的时间是：" + format); // 2008 8 8 20 8 8

        System.out.println("-----------------------------------------------------");
        // 2.使用取代的方式按照指定的年月日时分秒来构造对象
        // 2.1 获取Calendar类型的引用
        // 考点：既然Calendar是个抽象类不能创建对象，那么下面的方法为啥可以获取Calendar类型的引用呢？
        // 解析：由源码可知，返回的并不是Calendar类型的对象，而是Calendar类的子类GregorianCalendar等对象，形成了多态
        // 多态的使用场合之三
        Calendar instance = Calendar.getInstance();
        // 2.2 设置指定的年月日时分秒信息
        instance.set(2008, 8-1, 8, 20, 8, 8);
        // 2.3 转换为Date类型的对象
        Date d2 = instance.getTime();
        String format1 = sdf.format(d2);
        System.out.println("获取到的时间是：" + format1); // 2008 8 8 20 8 8

        System.out.println("-----------------------------------------------------");
        // 3.向指定的字段设置以及增加指定的数值
        instance.set(Calendar.YEAR, 2018);
        // 转换为Date类型并按照指定的格式打印
        Date d3 = instance.getTime();
        System.out.println("设置年份后的结果是：" + sdf.format(d3)); // 2018 8 8 20 8 8

        instance.add(Calendar.MONTH, 2);
        Date d4 = instance.getTime();
        System.out.println("增加月份后的结果是：" + sdf.format(d4)); // 2018 10 8 20 8 8
    }
}

```



## 3   Java8中的日期相关类 

### 3.1  Java8日期类的由来 

-  JDK 1.0中包含了一个java.util.Date类，但是它的大多数方法已经在JDK 1.1引入Calendar类之后被 弃用 了。而Calendar并不比Date好多少。它们面临的问题是：
  -  Date类中的年份是从1900开始的，而月份都从0开始。 
  - 格式化只对Date类有用，对Calendar类则不能使用。 
  - 非线程安全等。  

### 3.2  Java8日期类的概述 

-  Java 8通过发布新的Date-Time API来进一步加强对 日期与时间的处理。
  -  java.time包：该包日期/时间API的基础包。
  -  java.time.chrono包：该包提供对不同日历系统的访问。 
  - java.time.format包：该包能够格式化和解析日期时间对象。
  -  java.time.temporal包：该包包含底层框架和扩展特性。
  -  java.time.zone包：该包支持不同时区以及相关规则的类。  

### 3.3   LocalDate类的概述 

- 基本概念
  
-  java.time.LocalDate类主要用于描述年-月-日格式的日期信息，该类不表示时间和时区信息。  
  
- 常用方法

  ```java
  static LocalDate now() 		// 在默认时区中从系统时钟获取当前日期
  ```

### 3.4  LocalTime类的概述 

-  基本概念 
  - java.time.LocalTime 类主要用于描述时间信息，可以描述时分秒以及纳秒。
- 常用方法 

| 方法声明                          | 功能介绍                           |
| --------------------------------- | ---------------------------------- |
| static LocalTime now()            | 从默认时区的系统时间中获取当前时间 |
| static LocalTime now(ZoneId zone) | 获取指定时区的当前时间             |

### 3.5   LocalDateTime类的概述 

-  基本概念 
  - java.time.LocalDateTime类主要用于描述ISO-8601日历系统中没有时区的日期时间，如2007-12- 03T10:15:30。 
- 常用的方法 

| 方法声明                                                     | 功能介绍                                      |
| ------------------------------------------------------------ | --------------------------------------------- |
| static LocalDateTime now()                                   | 从默认时区的系统时间中获取 当前日期时间       |
| static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second) | 根据参数指定的年月日时分秒 信息来设置日期时间 |
| int getYear()                                                | 获取年份字段的数值                            |
| int getMonthValue()                                          | 获取1到12之间的月份字段                       |
| int getDayOfMonth()                                          | 获取日期字段                                  |
| int getHour()                                                | 获取小时数                                    |
| int getMinute()                                              | 获取分钟数                                    |
| int getSecond()                                              | 获取秒数                                      |
| LocalDateTime withYear(int year)                             | 设置为参数指定的年                            |
| LocalDateTime withMonth(int month)                           | 设置为参数指定的月                            |
| LocalDateTime withDayOfMonth(int dayOfMonth)                 | 设置为参数指定的日                            |
| LocalDateTime withHour(int hour)                             | 设置为参数指定的时                            |
| LocalDateTime withMinute(int minute)                         | 设置为参数指定的分                            |
| LocalDateTime withSecond(int second)                         | 设置为参数指定的秒                            |
| LocalDateTime plusYears(long years)                          | 加上参数指定的年                              |
| LocalDateTime plusMonths(long months)                        | 加上参数指定的月                              |
| LocalDateTime plusDays(long days)                            | 加上参数指定的日                              |
| LocalDateTime plusHours(long hours)                          | 加上参数指定的时                              |
| LocalDateTime plusMinutes(long minutes)                      | 加上参数指定的分                              |
| LocalDateTime plusSeconds(long seconds)                      | 加上参数指定的秒                              |
| LocalDateTime minusYears(long years)                         | 减去参数指定的年                              |
| LocalDateTime minusMonths(long months)                       | 减去参数指定的月                              |
| LocalDateTime minusDays(long days)                           | 减去参数指定的日                              |
| LocalDateTime minusHours(long hours)                         | 减去参数指定的时                              |
| LocalDateTime minusMinutes(long minutes)                     | 减去参数指定的分                              |
| LocalDateTime minusSeconds(long seconds)                     | 减去参数指定的秒                              |

```java

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        // 1.获取当前日期信息并打印
        LocalDate now = LocalDate.now();
        System.out.println("获取到的当前日期是：" + now);
        // 2.获取当前时间信息并打印
        LocalTime now1 = LocalTime.now();
        System.out.println("获取到的当前时间是：" + now1);
        // 3.获取当前日期时间信息并打印，使用最多
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("获取到的当前日期时间是：" + now2);

        System.out.println("-------------------------------------------------------");
        // 4.使用参数指定的年月日时分秒信息来获取对象并打印
        // 使用ctrl+F12来查找指定的方法
        LocalDateTime of = LocalDateTime.of(2008, 8, 8, 20, 8, 8);
        System.out.println("指定的日期时间是：" + of); // 自动调用toString方法
        System.out.println("获取到的年是：" + of.getYear()); // 2008
        System.out.println("获取到的月是：" + of.getMonthValue()); // 8
        System.out.println("获取到的日是：" + of.getDayOfMonth()); // 8
        System.out.println("获取到的时是：" + of.getHour()); // 20
        System.out.println("获取到的分是：" + of.getMinute()); // 8
        System.out.println("获取到的秒是：" + of.getSecond()); // 8

        System.out.println("-------------------------------------------------------");
        // 5.实现特征的设置并打印
        // 与String类型相似，调用对象本身的数据内容不会改变，返回值相当于创建了一个新的对象，由此证明了不可变性
        LocalDateTime localDateTime = of.withYear(2012);
        System.out.println("localDateTime = " + localDateTime); // 2012-08-08T20:08:08
        System.out.println("of = " + of); // 2008-08-08T20:08:08
        LocalDateTime localDateTime1 = localDateTime.withMonth(12);
        System.out.println("localDateTime1 = " + localDateTime1); // 2012 12 8 20 8 8

        System.out.println("-------------------------------------------------------");
        // 6.实现特征的增加并打印
        LocalDateTime localDateTime2 = localDateTime1.plusDays(2);
        System.out.println("localDateTime2 = " + localDateTime2); // 2012 12 10 20 8 8
        System.out.println("localDateTime1 = " + localDateTime1); // 2012 12 8 20 8 8
        LocalDateTime localDateTime3 = localDateTime2.plusHours(3);
        System.out.println("localDateTime3 = " + localDateTime3); // 2012 12 10 23 8 8

        System.out.println("-------------------------------------------------------");
        // 7.实现特征的减少并打印
        LocalDateTime localDateTime4 = localDateTime3.minusMinutes(1);
        System.out.println("localDateTime4 = " + localDateTime4); // 2012 12 10 23 7 8
        System.out.println("localDateTime3 = " + localDateTime3); // 2012 12 10 23 8 8
        LocalDateTime localDateTime5 = localDateTime4.minusSeconds(3);
        System.out.println("localDateTime5 = " + localDateTime5); // 2012 12 10 23 7 5

    }
}

```



### 3.6   Instant类的概述 

- 基本 概念
  
-  java.time.Instant类主要用于描述瞬间的时间点信息。 
  
- 常用方法

  | 方法声明                                     | 功能介绍                                                     |
  | -------------------------------------------- | ------------------------------------------------------------ |
  | static Instant now()                         | 从系统时钟上获取当前时间                                     |
  | OffsetDateTime atOffset(ZoneOffset offset)   | 将此瞬间与偏移量组合以创建偏移日期时间                       |
  | static Instant ofEpochMilli(long epochMilli) | 根据参数指定的毫秒数来构造对象，参数为距离1970年1月1 日0时0分0秒的毫秒数 |
  | long toEpochMilli()                          | 获取距离1970年1月1日0时0分0秒的毫秒数                        |

```java

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    public static void main(String[] args) {

        // 1.使用Instant类来获取当前系统时间  并不是当前系统的默认时区  本初子午线   差8小时  东八区
        Instant now = Instant.now();
        System.out.println("获取到的当前时间为：" + now);

        // 2.加上时区所差的8个小时
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("偏移后的日期时间为：" + offsetDateTime);

        System.out.println("--------------------------------------------------------");
        // 3.获取当前调用对象距离标准基准时间的毫秒数
        long g1 = now.toEpochMilli();
        System.out.println("获取到的毫秒差为：" + g1);

        // 4.根据参数指定的毫秒数来构造对象
        Instant instant = Instant.ofEpochMilli(g1);
        System.out.println("根据参数指定的毫秒数构造出来的对象为：" + instant);
    }
}

```



### 3.7   DateTimeFormatter类的概述 

-  基本概念
  -  java.time.format.DateTimeFormatter类主要用于格式化和解析日期。 
- 常用的方法 

| 方法声明                                           | 功能介绍                       |
| -------------------------------------------------- | ------------------------------ |
| static DateTimeFormatter ofPattern(String pattern) | 根据参数指定的模式来获取对象   |
| String format(TemporalAccessor temporal)           | 将参数指定日期时间转换为字符串 |
| TemporalAccessor parse(CharSequence text)          | 将参数指定字符串转换为日期时间 |

```java

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {

    public static void main(String[] args) {

        // 1.获取当前系统的日期时间并打印
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        // 2.按照指定的格式准备一个DateTimeFormatter类型的对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 3.实现日期时间向字符串类型的转换并打印
        String str = dateTimeFormatter.format(now);
        System.out.println("调整格式后的结果是：" + str);
        // 4.实现字符串类型到日期时间类型的转换并打印
        TemporalAccessor parse = dateTimeFormatter.parse(str);
        System.out.println("转回去的结果是：" + parse);
    }
}

```

