# 大数据学习-Java Day19

## 反射机制

### 1 基本概念

-  通常情况下编写代码都是固定的，无论运行多少次执行的结果也是固定的，在某些特殊场合中编写 代码时不确定要创建什么类型的对象，也不确定要调用什么样的方法，这些都希望通过运行时传递 的参数来决定，该机制叫做动态编程技术，也就是反射机制。 

- 通俗来说，反射机制就是用于动态创建对象并且动态调用方法的机制。 

- 目前主流的框架底层都是采用反射机制实现的。 

- 如：

  ```java
   Person p = new Person(); - 表示声明Person类型的引用指向Person类型的对象 
   p.show(); - 表示调用Person类中的成员方法show 
  ```

### 2 Class类

-  基本概念 
  - java.lang.Class类的实例可以用于描述Java应用程序中的类和接口，也就是一种数据类型。
  -  该类没有公共构造方法，该类的实例由Java虚拟机和类加载器自动构造完成，本质上就是加载到内 存中的运行时类。  
  
-  获取Class对象的方式 
  - 使用数据类型.class的方式可以获取对应类型的Class对象。 
  - 使用引用/对象.getClass()的方式可以获取对应类型的Class对象。 
  - 使用包装类.TYPE的方式可以获取对应基本数据类型的Class对象。
  -  使用Class.forName()的方式来获取参数指定类型的Class对象。 
  - 使用类加载器ClassLoader的方式获取指定类型的Class对象。 

- 常用方法

  | 方法声明                                  | 功能介绍                                  |
  | ----------------------------------------- | ----------------------------------------- |
  | static Class<?> forName(String className) | 用于获取参数指定类型对应的Class对象并返回 |
  | T newInstance()                           | 用于创建该Class对象所表示类的新实例       |
  
  ```java
  
  public class ClassTest {
  
      public static void main(String[] args) throws ClassNotFoundException {
  
          // 1.使用数据类型.class的方式可以获取对应类型的Class对象
          Class c1 = String.class;
          System.out.println("c1 = " + c1); // 自动调用toString方法  class java.lang.String
          c1 = int.class;
          System.out.println("c1 = " + c1); // int
          c1 = void.class;
          System.out.println("c1 = " + c1); // void
  
          System.out.println("---------------------------------------------------");
          // 2.使用对象.getClass()的方式获取对应的Class对象
          String str1 = new String("hello");
          c1 = str1.getClass();
          System.out.println("c1 = " + c1); // class java.lang.String
  
          Integer it1 = 20;
          c1 = it1.getClass();
          System.out.println("c1 = " + c1); // class java.lang.Integer
  
          int num = 5;
          //num.getClass(); Error: 基本数据类型的变量不能调用方法
  
          System.out.println("---------------------------------------------------");
          // 3.使用包装类.TYPE的方式来获取对应基本数据类型的Class对象
          c1 = Integer.TYPE;
          System.out.println("c1 = " + c1); // int
  
          c1 = Integer.class;
          System.out.println("c1 = " + c1); // class java.lang.Integer
  
          System.out.println("---------------------------------------------------");
          // 4.调用Class类中的forName方法来获取对应的Class对象
          //c1 = Class.forName("String"); // Error  要求写完整的名称：包名.类名
          c1 = Class.forName("java.lang.String");
          System.out.println("c1 = " + c1); // class java.lang.String
  
          c1 = Class.forName("java.util.Date");
          System.out.println("c1 = " + c1); // class java.util.Date
  
          //c1 = Class.forName("int");
          //System.out.println("c1 = " + c1); // 不能获取基本数据类型的Class对象
  
          System.out.println("---------------------------------------------------");
          // 5.使用类加载器的方式来获取Class对象
          ClassLoader classLoader = ClassTest.class.getClassLoader();
          // ClassLoader classLoader = String.class.getClassLoader();  NullPointerException  空指针异常
          System.out.println("classLoader = " + classLoader); // null
          c1 = classLoader.loadClass("java.lang.String");
          System.out.println("c1 = " + c1); // class java.lang.String
      }
  }
  
  ```
  
  

### 3 Constructor类 

-   基本概念
  
-  java.lang.reflect.Constructor类主要用于描述获取到的构造方法信息 
  
-  Class类的常用方法 

  | 方法声明                                                  | 功能介绍                                               |
  | --------------------------------------------------------- | ------------------------------------------------------ |
  | Constructor<T> getConstructor(Class<?>... parameterTypes) | 用于获取此Class对象所表示类型中参数指定的 公共构造方法 |
  | Constructor<?>[] getConstructors()                        | 用于获取此Class对象所表示类型中所有的公共 构造方法     |

-  Constructor类的常用方法 

  | 方法声明                          | 功能介绍                                                     |
  | --------------------------------- | ------------------------------------------------------------ |
  | T newInstance(Object... initargs) | 使用此Constructor对象描述的构造方法来构造Class对象代表类 型的新实例 |
  | int getModifiers()                | 获取方法的访问修饰符                                         |
  | String getName()                  | 获取方法的名称                                               |
  | Class<?>[] getParameterTypes()    | 获取方法所有参数的类型                                       |

  ```java
  
  import java.io.IOException;
  
  public class Person {
      private String name;
      //public String name;
      private int age;
  
      public Person() {
      }
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getAge() {
          return age;
      }
  
      public void setAge(int age) throws IOException {
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  
  ```
  
  ```java
  
  import java.io.BufferedReader;
  import java.io.FileInputStream;
  import java.io.InputStreamReader;
  import java.lang.reflect.Constructor;
  import java.util.Scanner;
  
  public class PersonConstructorTest {
  
      public static void main(String[] args) throws Exception {
  
          // 1.使用原始方式以无参形式构造Person类型的对象并打印
          Person p1 = new Person();
          System.out.println("无参方式创建的对象是：" + p1); // null 0
  
          System.out.println("---------------------------------------------------");
          // 2.使用反射机制以无参形式构造Person类型的对象并打印
          // 创建对象的类型可以从键盘输入
          //System.out.println("请输入要创建对象的类型：");
          //Scanner sc = new Scanner(System.in);
          //String str1 = sc.next();
          //Class c1 = Class.forName("com.bigdatalearn.Person");
          // 创建对象的类型可以从配置文件中读取
          BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/a.txt")));
          String str1 = br.readLine();
          Class c1 = Class.forName(str1);
          //System.out.println("无参方式创建的对象是：" + c1.newInstance()); // null 0
          // 获取Class对象对应类中的无参构造方法，也就是Person类中的无参构造方法
          Constructor constructor = c1.getConstructor();
          // 使用获取到的无参构造方法来构造对应类型的对象，也就是在此Person类型的对象
          System.out.println("无参方式创建的对象是：" + constructor.newInstance());
          //sc.close();
          br.close();
  
          System.out.println("---------------------------------------------------");
          // 3.使用原始方式以有参方式构造Person类型的对象并打印
          Person p2 = new Person("zhangfei", 30);
          System.out.println("有参方式构造的对象是：" + p2); // zhangfei 30
  
          System.out.println("---------------------------------------------------");
          // 4.使用反射机制以有参方式构造Person类型的对象并打印
          // 获取Class对象对应类中的有参构造方法，也就是Person类中的有参构造方法
          Constructor constructor1 = c1.getConstructor(String.class, int.class);
          // 使用获取到的有参构造方法来构造对应类型的对象，也就是Person类型的对象
          // newInstance方法中的实参是用于给有参构造方法的形参进行初始化的，也就是给name和age进行初始化的
          System.out.println("有参方式构造的对象是：" + constructor1.newInstance("zhangfei", 30)); // zhangfei 30
  
          System.out.println("---------------------------------------------------");
          // 5.使用反射机制获取Person类中所有的公共构造方法并打印
          Constructor[] constructors = c1.getConstructors();
          for (Constructor ct : constructors) {
              System.out.println("构造方法的访问修饰符是：" + ct.getModifiers());
              System.out.println("构造方法的方法名称是：" + ct.getName());
              Class[] parameterTypes = ct.getParameterTypes();
              System.out.print("构造方法的所有参数类型是：");
              for (Class cs : parameterTypes) {
                  System.out.print(cs + " ");
              }
              System.out.println();
              System.out.println("-------------------------------------------------");
          }
      }
  }
  
  ```
  
  

###  4 Field类 

-  基本概念

  -  java.lang.reflect.Field类主要用于描述获取到的单个成员变量信息。

-  Class类的常用方法  

  | 方法声明                            | 功能介绍                                                 |
  | ----------------------------------- | -------------------------------------------------------- |
  | Field getDeclaredField(String name) | 用于获取此Class对象所表示类中参数指定的单个成员变量 信息 |
  | Field[] getDeclaredFields()         | 用于获取此Class对象所表示类中所有成员变量信息            |

-   Field类的常用方法 

  | 方法声明                           | 功能介绍                                                     |
  | ---------------------------------- | ------------------------------------------------------------ |
  | Object get(Object obj)             | 获取参数对象obj中此Field对象所表示成员变量的数值             |
  | void set(Object obj, Object value) | 将参数对象obj中此Field对象表示成员变量的数值修改为参数 value的数值 |
  | void setAccessible(boolean flag)   | 当实参传递true时，则反射对象在使用时应该取消 Java 语言访 问检查 |
  | int getModifiers()                 | 获取成员变量的访问修饰符                                     |
  | Class<?> getType()                 | 获取成员变量的数据类型                                       |
  | String getName()                   | 获取成员变量的名称                                           |



```java

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PersonFieldTest {

    public static void main(String[] args) throws Exception {

        // 1.使用原始方式来构造对象以及获取成员变量的数值并打印
        Person p1 = new Person("zhangfei", 30);
        //System.out.println("获取到的成员变量数值为：" + p1.name); // zhangfei

        System.out.println("-------------------------------------------------------");
        // 2.使用反射机制来构造对象以及获取成员变量的数值并打印
        // 2.1 获取Class对象
        Class c1 = Class.forName("com.bigdatalearn.Person");
        // 2.2 根据Class对象获取对应的有参构造方法
        Constructor constructor = c1.getConstructor(String.class, int.class);
        // 2.3 使用有参构造方法来得到Person类型的对象
        Object object = constructor.newInstance("zhangfei", 30);
        // 2.4 根据Class对象获取对应的成员变量信息
        Field field = c1.getDeclaredField("name");
        // 设置Java语言访问检查的取消  暴力反射
        field.setAccessible(true);
        // 2.5 使用Person类型的对象来获取成员变量的数值并打印
        // 获取对象object中名字为field成员变量的数值，也就是成员变量name的数值
        System.out.println("获取到的成员变量数值为：" + field.get(object)); // zhangfei

        System.out.println("-------------------------------------------------------");
        // 3.使用原始方式修改指定对象中成员变量的数值后再次打印
        //p1.name = "guanyu";
        //System.out.println("修改后成员变量的数值为：" + p1.name); // guanyu

        System.out.println("-------------------------------------------------------");
        // 4.使用反射机制修改指定对象中成员变量的数值后再次打印
        // 表示修改对象object中名字为field成员变量的数值为guanyu，也就是成员变量name的数值为guanyu
        field.set(object, "guanyu");
        System.out.println("修改后成员变量的数值为：" + field.get(object)); // guanyu

        System.out.println("-------------------------------------------------------");
        // 5.获取Class对象对应类中所有的成员变量
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field ft : declaredFields) {
            System.out.println("获取到的访问修饰符为：" + ft.getModifiers());
            System.out.println("获取到的数据类型为：" + ft.getType());
            System.out.println("获取到的成员变量名称是：" + ft.getName());
            System.out.println("---------------------------------------------");
        }
    }
}

```



###  5 Method类 

-  基本概念 

  - java.lang.reflect.Method类主要用于描述获取到的单个成员方法信息。

-  Class类的常用方法  

  | 方法声明                                                  | 功能介绍                                                     |
  | --------------------------------------------------------- | ------------------------------------------------------------ |
  | Method getMethod(String name, Class<?>... parameterTypes) | 用于获取该Class对象表示类中名字为name参数为 parameterTypes的指定公共成员方法 |
  | Method[] getMethods()                                     | 用于获取该Class对象表示类中所有公共成员方法                  |

-   Method类的常用方法 

  | 方法声明                                  | 功能介绍                                                     |
  | ----------------------------------------- | ------------------------------------------------------------ |
  | Object invoke(Object obj, Object... args) | 使用对象obj来调用此Method对象所表示的成员方法，实 参传递args |
  | int getModifiers()                        | 获取方法的访问修饰符                                         |
  | Class<?> getReturnType()                  | 获取方法的返回值类型                                         |
  | String getName()                          | 获取方法的名称                                               |
  | Class<?>[] getParameterTypes()            | 获取方法所有参数的类型                                       |
  | Class<?>[] getExceptionTypes()            | 获取方法的异常信息                                           |



```java

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PersonMethodTest {

    public static void main(String[] args) throws Exception {

        // 1.使用原始方式构造对象并调用方法打印结果
        Person p1 = new Person("zhangfei", 30);
        System.out.println("调用方法的返回值是：" + p1.getName()); // zhangfei

        System.out.println("------------------------------------------------------");
        // 2.使用反射机制构造对象并调用方法打印结果
        // 2.1 获取Class对象
        Class c1 = Class.forName("com.bigdatalearn.Person");
        // 2.2 根据Class对象来获取对应的有参构造方法
        Constructor constructor = c1.getConstructor(String.class, int.class);
        // 2.3 使用有参构造方法构造对象并记录
        Object object = constructor.newInstance("zhangfei", 30);
        // 2.4 根据Class对象来获取对应的成员方法
        Method method = c1.getMethod("getName");
        // 2.5 使用对象调用成员方法进行打印
        // 表示使用object对象调用method表示的方法，也就是调用getName方法来获取姓名
        System.out.println("调用方法的返回值是：" + method.invoke(object)); // zhangfei

        System.out.println("------------------------------------------------------");
        // 3.使用反射机制来获取类中的所有成员方法并打印
        Method[] methods = c1.getMethods();
        for (Method mt : methods) {
            System.out.println("成员方法的修饰符是：" + mt.getModifiers());
            System.out.println("成员方法的返回值类型是：" + mt.getReturnType());
            System.out.println("成员方法的名称是：" + mt.getName());
            System.out.println("成员方法形参列表的类型是：");
            Class<?>[] parameterTypes = mt.getParameterTypes();
            for (Class ct : parameterTypes) {
                System.out.print(ct + " ");
            }
            System.out.println();
            System.out.println("成员方法的异常类型列表是：");
            Class<?>[] exceptionTypes = mt.getExceptionTypes();
            for (Class ct: exceptionTypes) {
                System.out.print(ct + " ");
            }
            System.out.println();
            System.out.println("---------------------------------------------------");
        }
    }
}

```



### 6 获取其它结构信息 

| 方法声明                         | 功能介绍           |
| -------------------------------- | ------------------ |
| Package getPackage()             | 获取所在的包信息   |
| Class<? super T> getSuperclass() | 获取继承的父类信息 |
| Class<?>[] getInterfaces()       | 获取实现的所有接口 |
| Annotation[] getAnnotations()    | 获取注解信息       |
| Type[] getGenericInterfaces()    | 获取泛型信息       |

```java

import java.io.Serializable;

@MyAnnotation
public class Student<T, E> extends Person implements Comparable, Serializable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
```



```java

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}

```



```java

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class StudentTest {

    public static void main(String[] args) throws Exception {

        // 获取Student类型的Class对象
        Class c1 = Class.forName("com.bigdatalearn.Student");
        System.out.println("获取到的包信息是：" + c1.getPackage());
        System.out.println("获取到的父类信息是：" + c1.getSuperclass());

        System.out.println("-------------------------------------------------");
        System.out.println("获取到的接口信息是：");
        Class[] interfaces = c1.getInterfaces();
        for (Class ct : interfaces) {
            System.out.print(ct + " ");
        }
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("获取到的注解信息是：");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation at : annotations) {
            System.out.print(at + " ");
        }
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("获取到的泛型信息是：");
        Type[] genericInterfaces = c1.getGenericInterfaces();
        for (Type tt : genericInterfaces) {
            System.out.print(tt + " ");
        }
        System.out.println();
    }
}

```

