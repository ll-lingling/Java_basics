# 大数据学习-Java Day13

## 集合类库

### 1 集合的概述 （重点）  

- 集合的由来
  -  当需要在Java程序中记录单个数据内容时，则声明一个变量。 
  - 当需要在Java程序中记录多个类型相同的数据内容时，声明一个一维数组。 
  - 当需要在Java程序中记录多个类型不同的数据内容时，则创建一个对象。 
  - 当需要在Java程序中记录多个类型相同的对象数据时，创建一个对象数组。 当需要在Java程序中记录多个类型不同的对象数据时，则准备一个集合。 

- 集合的框架结构
  -  Java中集合框架顶层框架是：java.util.Collection集合 和 java.util.Map集合。 
    - 其中Collection集合中存取元素的基本单位是：单个元素。 
    - 其中Map集合中存取元素的基本单位是：单对元素。 

### 2  Collection集合（重点）

![./picture/Snipaste_2020-11-14_12-20-34.png](./picture/Snipaste_2020-11-14_12-20-34.png)

- 概念

  -  java.util.Collection接口是List接口、Queue 接口以及Set接口的父接口，因此该接口里定义的方法 既可用于操作List集合，也可用于操作Queue集合和Set集合 

- 常用方法

  | 方法声明                                   | 功能介绍                                                     |
  | ------------------------------------------ | ------------------------------------------------------------ |
  | boolean add(E  e);                         | 向集合中添加对象                                             |
  | boolean  addAll(Collection<? extends E> c) | boolean  contains(Object o);  用于将参数指定集合c中的所有元素添加到当前集合 中 |
  | boolean  contains(Object o);               | 判断是否包含指定对象                                         |
  | boolean  containsAll(Collection<?> c)      | 判断是否包含参数指定的所有对象                               |
  | boolean  retainAll(Collection<?> c)        | 保留当前集合中存在且参数集合中存在的所有对象                 |
  | boolean  remove(Object o);                 | 从集合中删除对象                                             |
  | boolean  removeAll(Collection<?> c)        | 从集合中删除参数指定的所有对象                               |
  | void clear();                              | 清空集合                                                     |
  | int size();                                | 返回包含对象的个数                                           |
  | boolean isEmpty();                         | 判断是否为空                                                 |
  | boolean equals(Object o)                   | 判断是否相等                                                 |
  | int hashCode()                             | 获取当前集合的哈希码值                                       |
  | Object[] toArray()                         | 将集合转换为数组                                             |
  | Iterator<E> iterator()                     | 获取当前集合的迭代器                                         |
  
  ```java
  
  import java.util.Objects;
  
  public class Person {
      private String name;
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
  
      public void setAge(int age) {
          this.age = age;
      }
  
      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Person person = (Person) o;
          return age == person.age &&
                  Objects.equals(name, person.name);
      }
  
      @Override
      public int hashCode() {
          return Objects.hash(name, age);
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
  
  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Collection;
  import java.util.List;
  
  public class CollectionTest {
  
      public static void main(String[] args) {
  
          // 1.准备一个Collection集合并打印
          //Collection c1 = new Collection();  // 接口不能实例化，也就是不能创建对象
          // 接口类型的引用指向实现类的对象，形成了多态
          Collection c1 = new ArrayList();
          // 自动调用toString方法，调用ArrayList类中的toString方法，默认打印格式为：[元素值1, 元素值2, ...]
          System.out.println("集合中的元素有：" + c1); // [啥也没有]
  
          System.out.println("--------------------------------------------------------");
          // 2.向集合中添加单个元素并打印
          boolean b1 = c1.add(new String("one"));
          System.out.println("b1 = " + b1); // true
          System.out.println("集合中的元素有：" + c1); // [one]
  
          b1 = c1.add(Integer.valueOf(2));
          System.out.println("b1 = " + b1); // true
          System.out.println("集合中的元素有：" + c1); // [one, 2]
  
          b1 = c1.add(new Person("zhangfei", 30));
          System.out.println("b1 = " + b1); // true
          // 打印集合中的所有元素时，本质上就是打印集合中的每个对象，也就是让每个对象调用对应类的toString方法
          System.out.println("集合中的元素有：" + c1); // [one, 2, Person{name='zhangfei', age=30}]
  
          System.out.println("--------------------------------------------------------");
          // 3.向集合中添加多个元素并打印
          Collection c2 = new ArrayList();
          c2.add("three");  // 常量池
          c2.add(4);        // 自动装箱机制
          System.out.println("c2 = " + c2); // [three, 4]
          // 将c2中的所有元素全部添加到集合c1中，也就是将集合c2中的元素一个一个依次添加到集合c1中
          b1 = c1.addAll(c2);
          // 表示将集合c2整体看做一个元素添加到集合c1中
          //b1 = c1.add(c2);
          System.out.println("b1 = " + b1);
          // [one, 2, Person{name='zhangfei', age=30}, three, 4]    [one, 2, Person{name='zhangfei', age=30}, [three, 4]]
          System.out.println("c1 = " + c1);
  
          System.out.println("--------------------------------------------------------");
          // 4.判断集合中是否包含参数指定的单个元素
          b1 = c1.contains(new String("one"));
          System.out.println("b1 = " + b1); // true
  
          b1 = c1.contains(new String("two"));
          System.out.println("b1 = " + b1); // false
  
          b1 = c1.contains(Integer.valueOf(2));
          System.out.println("b1 = " + b1); // true
  
          b1 = c1.contains(Integer.valueOf(3));
          System.out.println("b1 = " + b1); // false
          // contains方法的工作原理是：Objects.equals(o, e)，其中o代表contains方法的形式参数，e代表集合中的每个元素
          // 也就是contains的工作原理就是 拿着参数对象与集合中已有的元素依次进行比较，比较的方式调用Objects中的equals方法
          // 而该方法equals的工作原理如下：
          /*
          public static boolean equals(Object a, Object b) {    其中a代表Person对象，b代表集合中已有的对象
              return (a == b) || (a != null && a.equals(b));
              元素包含的第一种方式就是：Person对象与集合中已有对象的地址相同
                       第二种方式就是：Person对象不为空，则Person对象调用equals方法与集合中已有元素相等
          }
          */
          // 当Person类中没有重写equals方法时，则调用从Object类中继承下来的equals方法，比较两个对象的地址  false
          // 当Person类中重写equals方法后，则调用重写以后的版本，比较两个对象的内容  true
          b1 = c1.contains(new Person("zhangfei", 30));
          System.out.println("b1 = " + b1); // true  false
  
          System.out.println("--------------------------------------------------------");
          // [one, 2, Person{name='zhangfei', age=30}, three, 4]
          System.out.println("c1 = " + c1);
  
          // 5.判断当前集合中是否包含参数指定集合的所有元素
          Collection c3 = new ArrayList();
          c3.add(4);
          System.out.println("c3 = " + c3); // [4]
  
          // 判断集合c1中是否包含集合c3中的所有元素
          b1 = c1.containsAll(c3);
          System.out.println("b1 = " + b1); // true
  
          c3.add("five");
          System.out.println("c3 = " + c3); // [4, five]
          // 判断集合c1中是否包含集合c3中的所有元素，只有集合c3中的所有元素都在集合c1中出现才会返回true，否则都是false
          b1 = c1.containsAll(c3);
          System.out.println("b1 = " + b1); // false
  
          // 笔试考点
          System.out.println("c2 = " + c2); // [three, 4]
          b1 = c1.containsAll(c2);
          System.out.println("b1 = " + b1); // true false
          // 判断集合c1中是否拥有集合c2这个整体为单位的元素
          b1 = c1.contains(c2);
          System.out.println("b1 = " + b1); // false true
  
          System.out.println("--------------------------------------------------------");
          // 6.计算两个集合的交集并保留到当前集合中
          System.out.println("c2 = " + c2); // [three, 4]
          System.out.println("c3 = " + c3); // [4, five]
          // 也就是让集合自己和自己取交集，还是自己，也就是当前集合中的元素没有发生改变
          b1 = c2.retainAll(c2);
          System.out.println("b1 = " + b1); // false 表示当前集合中的元素没有发生改变
          System.out.println("c2 = " + c2); // [three, 4]
          // 计算集合c2和c3的交集并保留到集合c2中，取代集合c2中原有的数值
          b1 = c2.retainAll(c3);
          System.out.println("b1 = " + b1); // true 当前集合的元素发生了改变
          System.out.println("c2 = " + c2); // [4]
          System.out.println("c3 = " + c3); // [4, five]
  
          System.out.println("--------------------------------------------------------");
          // 7.实现集合中单个元素的删除操作
          // [one, 2, Person{name='zhangfei', age=30}, three, 4]
          System.out.println("c1 = " + c1);
          // 删除参数指定的单个元素
          b1 = c1.remove(1);
          System.out.println("b1 = " + b1); // false
          // [one, 2, Person{name='zhangfei', age=30}, three, 4]
          System.out.println("c1 = " + c1);
  
          b1 = c1.remove("one");
          System.out.println("b1 = " + b1); // true
          // [2, Person{name='zhangfei', age=30}, three, 4]
          System.out.println("c1 = " + c1);
  
          // remove方法的工作原理：Objects.equals(o, e)
          b1 = c1.remove(new Person("zhangfei", 30));
          System.out.println("b1 = " + b1); // true
          // [2, three, 4]
          System.out.println("c1 = " + c1);
  
          System.out.println("--------------------------------------------------------");
          // 8.实现集合中所有元素的删除操作
          System.out.println("c3 = " + c3); // [4, five]
          // 从集合c1中删除集合c3中的所有元素，本质上就是一个一个元素进行删除，有元素则删除，否则不删除
          b1 = c1.removeAll(c3);
          System.out.println("b1 = " + b1); // true
          // [2, three]
          System.out.println("c1 = " + c1);
          System.out.println("c3 = " + c3); // [4, five]
  
          // 笔试考点  删除整体对象c3
          b1 = c1.remove(c3);
          System.out.println("b1 = " + b1); // false
          System.out.println("c1 = " + c1); // [2, three]
  
          System.out.println("--------------------------------------------------------");
          // 9.实现集合中其它方法的测试   ctrl+n 可以直接搜索并打开类的源码  使用ctrl+f12可以搜索类中的方法
          System.out.println("集合中元素的个数为：" + c1.size()); // 2
          System.out.println(0 == c1.size() ? "集合已经空了": "集合还没有空"); // 没有空
          System.out.println(c1.isEmpty()? "集合已经空了": "集合还没有空"); // 没有空
          // 清空集合中的所有元素
          c1.clear();
          System.out.println("集合中元素的个数为：" + c1.size()); // 0
          System.out.println(0 == c1.size() ? "集合已经空了": "集合还没有空"); // 已经空了
          System.out.println(c1.isEmpty()? "集合已经空了": "集合还没有空");   // 已经空了
  
          // 准备两个集合并判断是否相等
          Collection c4 = new ArrayList();
          c4.add(1);
          c4.add(2);
          System.out.println("c4 = " + c4); // [1, 2]
          Collection c5 = new ArrayList();
          c5.add(1);
          c5.add(2);
          c5.add(3);
          System.out.println("c5 = " + c5); // [1, 2, 3]
          // 判断是否相等
          b1 = c4.equals(c5);
          System.out.println("b1 = " + b1); // true  false
  
          System.out.println("--------------------------------------------------------");
          // 10.实现集合和数组类型之间的转换   通常认为：集合是用于取代数组的结构
          // 实现集合向数组类型的转换
          Object[] objects = c5.toArray();
          // 打印数组中的所有元素
          System.out.println("数组中的元素有：" + Arrays.toString(objects)); // [1, 2, 3]
          // 实现数组类型到集合类型的转换
          Collection objects1 = Arrays.asList(objects);
          System.out.println("集合中的元素有：" + objects1); // [1, 2, 3]
      }
  }
  
  ```
  
  

### 3  Iterator接口（重点） 

- 概念
  -  java.util.Iterator接口主要用于描述迭代器对象，可以遍历Collection集合中的所有元素。 
  - java.util.Collection接口继承Iterator接口，因此所有实现Collection接口的实现类都可以使用该迭 代器对象。 

- 常用方法

  | 方法声明          | 功能介绍                            |
  | ----------------- | ----------------------------------- |
  | boolean hasNext() | 判断集合中是否有可以迭代/访问的元素 |
  | E next()          | 用于取出一个元素并指向下一个元素    |
  | void remove()     | 用于删除访问到的最后一个元素        |

##### 案例  如何使用迭代器实现toString方法的打印效果？ 

```java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionPrintTest {

    public static void main(String[] args) {

        // 1.准备一个Collection集合并放入元素后打印
        Collection c1 = new ArrayList();
        c1.add("one");
        c1.add(2);
        c1.add(new Person("zhangfei", 30));
        // 遍历方式一： 自动调用toString方法   String类型的整体
        System.out.println("c1 = " + c1); // [one, 2, Person{name='zhangfei', age=30}]

        System.out.println("------------------------------------------------");
        // 2.遍历方式二：使用迭代器来遍历集合中的所有元素  更加灵活
        // 2.1 获取当前集合中的迭代器对象
        Iterator iterator1 = c1.iterator();
        /*
        // 2.2 判断是否有元素可以访问
        System.out.println(iterator1.hasNext()); // true
        // 2.3 取出一个元素并指向下一个
        System.out.println("获取到的元素是：" + iterator1.next()); // one

        System.out.println(iterator1.hasNext()); // true
        System.out.println("获取到的元素是：" + iterator1.next()); // 2

        System.out.println(iterator1.hasNext()); // true
        System.out.println("获取到的元素是：" + iterator1.next()); // Person{name='zhangfei', age=30}

        System.out.println(iterator1.hasNext()); // false
        System.out.println("获取到的元素是：" + iterator1.next()); // 编译ok，运行发生NoSuchElementException没有这样的元素异常
         */
        while (iterator1.hasNext()) {
            System.out.println("获取到的元素是：" + iterator1.next());
        }

        System.out.println("------------------------------------------------");
        // 由于上个循环已经使得迭代器走到了最后，因此需要重置迭代器
        iterator1 = c1.iterator();
        // 3.使用迭代器来模拟toString方法的打印效果
        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            // 当获取的元素是最后一个元素时，则拼接元素加中括号
            if (!iterator1.hasNext()) {
                sb1.append(obj).append("]");
            } else {
                // 否则拼接元素加逗号加空格
                sb1.append(obj).append(",").append(" ");
            }
        }
        // [one, 2, Person{name='zhangfei', age=30}]
        System.out.println("c1 = " + sb1);

        System.out.println("------------------------------------------------");
        // 4.不断地去获取集合中的元素并判断，当元素值为"one"时则删除该元素
        iterator1 = c1.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            if("one".equals(obj)) {
                iterator1.remove();  //使用迭代器的remove方法删除元素没问题
                //c1.remove(obj); // 使用集合的remove方法编译ok，运行发生ConcurrentModificationException并发修改异常
            }
        }
        System.out.println("删除后集合中的元素有：" + c1); // [2, Person{name='zhangfei', age=30}]

        System.out.println("------------------------------------------------");
        // 5.使用 for each结构实现集合和数组中元素的遍历  代码简单且方法灵活
        // 由调试源码可知：该方式确实是迭代器的简化版
        for (Object obj : c1) {
            System.out.println("取出来的元素是：" + obj);
        }

        int[] arr = new int[] {11, 22, 33, 44, 55};
        for (int i : arr) {
            System.out.println("i = " + i);
            i = 66; // 修改局部变量i的数值，并不是修改数组中元素的数值
        }
        System.out.println("数组中的元素有：" + Arrays.toString(arr));

    }
}

```



### 4   for each循环（重点） 

-  基本概念 
  - Java5推出了增强型for循环语句，可以应用数组和集合的遍历。 
  - 是经典迭代的“简化版”。 

-  语法格式 

  ```java
  for(元素类型 变量名 : 数组/集合名称) { 
      循环体; 
  }  
  ```

-   执行流程 
  
  - 不断地从数组/集合中取出一个元素赋值给变量名并执行循环体，直到取完所有元素为止。 

### 5  List集合（重中之重） 

-  基本概念 
  - java.util.List集合是Collection集合的子集合，该集合中允许有重复的元素并且有先后放入次序。 
  
  - 该集合的主要实现类有：ArrayList类、LinkedList类、Stack类、Vector类。 
  
  - 其中ArrayList类的底层是采用动态数组进行数据管理的，支持下标访问，增删元素不方便。 
  
- 其中LinkedList类的底层是采用双向链表进行数据管理的，访问不方便，增删元素方便。 可以认为ArrayList和LinkedList的方法在逻辑上完全一样，只是在性能上有一定的差别，ArrayList 更适合于 机访问而LinkedList更适合于插入和删除；在性能要求不是特别苛刻的情形下可以忽略这个差别。 
  
    - ```java
      
      import java.util.ArrayList;
      import java.util.LinkedList;
      import java.util.List;
      
      public class ListTest {
      
          public static void main(String[] args) {
      
              // 1.声明一个List接口类型的引用指向ArrayList类型的对象，形成了多态
              // 由源码可知：当new对象时并没有申请数组的内存空间
              List lt1 = new ArrayList();
              // 2.向集合中添加元素并打印
              // 由源码可知：当调用add方法添加元素时会给数组申请长度为10的一维数组，扩容原理是：原始长度的1.5倍
              lt1.add("one");
              System.out.println("lt1 = " + lt1); // [one]
      
              System.out.println("----------------------------------------------------");
              // 2.声明一个List接口类型的引用指向LinkedList类型的对象，形成了多态
              List lt2 = new LinkedList();
              lt2.add("one");
              System.out.println("lt2 = " + lt2); // [one]
          }
      }
      
      ```
    
      
    
  - 其中Stack类的底层是采用动态数组进行数据管理的，该类主要用于描述一种具有后进先出特征的 数据结构，叫做栈(last in first out LIFO)。 
  
  - 其中Vector类的底层是采用动态数组进行数据管理的，该类与ArrayList类相比属于线程安全的 类，效率比较低，以后开发中基本不用。  
  
- 常用方法

  | 方法声明                                              | 功能介绍                 |
  | ----------------------------------------------------- | ------------------------ |
  | void add(int index, E element)                        | 向集合中指定位置添加元素 |
  | boolean  addAll(int index, Collection<? extends E> c) | 向集合中添加所有元素     |
  | E get(int index)                                      | 从集合中获取指定位置元素 |
  | int indexOf(Object o)                                 | 查找参数指定的对象       |
  | int lastIndexOf(Object o)                             | 反向查找参数指定的对象   |
  | E set(int index, E element)                           | 修改指定位置的元素       |
  | E remove(int index)                                   | 删除指定位置的元素       |
  | List subList(int fromIndex, int toIndex)              | 用于获取子List           |

  ```java
  
  import java.util.LinkedList;
  import java.util.List;
  
  public class ListMethodTest {
  
      public static void main(String[] args) {
  
          // 1.准备一个List集合并打印
          List lt1 = new LinkedList();
          System.out.println("lt1 = " + lt1); // [啥也没有]
  
          System.out.println("------------------------------------------");
          // 2.向集合中添加元素并打印
          // 向集合中的开头位置添加元素
          lt1.add(0, "one");
          System.out.println("lt1 = " + lt1); // [one]
          // 向集合中的末尾位置添加元素
          lt1.add(1, 3);
          System.out.println("lt1 = " + lt1); // [one, 3]
          // 向集合中的中间位置添加元素
          lt1.add(1, "two");
          System.out.println("lt1 = " + lt1); // [one, two, 3]
  
          System.out.println("------------------------------------------");
          // 3.根据参数指定的下标来获取元素
          String str1 = (String) lt1.get(0);
          System.out.println("获取到的元素是：" + str1); // one
  
          // 注意：获取元素并进行强制类型转换时一定要慎重，因为容易发生类型转换异常
          //String str2 = (String)lt1.get(2); // 编译ok，运行发生ClassCastException类型转换异常
          //System.out.println("获取到的元素是：" + str2); // 3
  
          System.out.println("------------------------------------------");
          // 4.使用get方法获取集合中的所有元素并打印
          StringBuilder sb1 = new StringBuilder();
          sb1.append("[");
          for (int i = 0; i < lt1.size(); i++) {
              //Object obj = lt1.get(i);
              //System.out.println("获取到的元素是：" + obj);
              Object obj = lt1.get(i);
              // 若取出的元素是最后一个元素，则拼接元素值和]
              if (lt1.size()-1 == i) {
                  sb1.append(obj).append("]");
              }
              // 否则拼接元素和逗号以及空格
              else {
                  sb1.append(obj).append(",").append(" ");
              }
          }
          System.out.println("lt1 = " + sb1); // [one, two, 3]
  
          System.out.println("------------------------------------------");
          // 5.查找指定元素出现的索引位置
          System.out.println("one第一次出现的索引位置为：" + lt1.indexOf("one")); // 0
          lt1.add("one");
          System.out.println("lt1 = " + lt1); // [one, two, 3, one]
          System.out.println("one反向查找第一次出现的索引位置是：" + lt1.lastIndexOf("one")); // 3
  
          System.out.println("------------------------------------------");
          System.out.println("lt1 = " + lt1); // [one, two, 3, one]
          // 6.实现集合中元素的修改
          Integer it1 = (Integer) lt1.set(2, "three");
          System.out.println("被修改的元素是：" + it1); // 3
          System.out.println("修改后集合中的元素有：" + lt1); // [one, two, three, one]
  
          String str2 = (String) lt1.set(3, "four");
          System.out.println("被修改的元素是：" + str2); // one
          System.out.println("修改后集合中的元素有：" + lt1); // [one, two, three, four]
  
          System.out.println("------------------------------------------");
          // 7.使用remove方法将集合中的所有元素删除
          //for (int i = 0; i < lt1.size(); /*i++*/) {
         /* for (int i = lt1.size()-1; i >= 0; i--) {
              //System.out.println("被删除的元素是：" + lt1.remove(i)); // one  two  three  four 删除元素后，后面的元素补位
              //System.out.println("被删除的元素是：" + lt1.remove(0));
              System.out.println("被删除的元素是：" + lt1.remove(i));
          }
          System.out.println("最终集合中的元素有：" + lt1); // [啥也没有]*/
  
          System.out.println("------------------------------------------");
          // 8.获取当前集合中的子集合，也就是将集合中的一部分内容获取出来，子集合和当前集合共用同一块内存空间
          // 表示获取当前集合lt1中下标从1开始到3之间的元素，包含1但不包含3
          List lt2 = lt1.subList(1, 3);
          System.out.println("lt2 = " + lt2); // [two, three]
          // 删除lt2中元素的数值
          str2 = (String) lt2.remove(0);
          System.out.println("被删除的元素是：" + str2); // two
          System.out.println("删除后lt2 = " + lt2); // [three]
          System.out.println("删除后lt1 = " + lt1); // [one, three, four]
      }
  }
  
  ```
  
  
  
  ##### 案例  准备一个Stack集合，将数据11、22、33、44、55依次入栈并打印，然后查看栈顶元素并打印， 然后将栈中所有数据依次出栈并打印。 再准备一个Stack对象，将数据从第一个栈中取出来放入第二个栈中，然后再从第二个栈中取出并 打印。 
  
  ```java
  
  import java.util.Stack;
  
  public class StackTest {
  
      public static void main(String[] args) {
  
          // 1.准备一个Stack类型的对象并打印
          Stack s1 = new Stack();
          Stack s2 = new Stack();
          System.out.println("s1 = " + s1); // [啥也没有]
          System.out.println("s2 = " + s2); // [啥也没有]
  
          System.out.println("-----------------------------------------------");
          // 2.将数据11、22、33、44、55依次入栈并打印
          for (int i = 1; i <= 5; i++) {
              Object obj = s1.push(i * 11);
              System.out.println("入栈的元素是：" + obj);
              //System.out.println("栈中的元素有：" + s1); // 11 22 33 44 55
          }
  
          System.out.println("-----------------------------------------------");
          // 3.查看栈顶元素值并打印
          //Object obj2 = s1.peek();
          //System.out.println("获取到的栈顶元素是：" + obj2); // 55
  
          System.out.println("-----------------------------------------------");
          // 4.对栈中所有元素依次出栈并打印
          int len = s1.size();
          for (int i = 1; i <= len; i++) {
              Object to = s1.pop();
              //System.out.println("出栈的元素是：" + to); // 55 44 33 22 11
              s2.push(to);
          }
  
          System.out.println("-----------------------------------------------");
          // 5.最终打印栈中的所有元素
          //System.out.println("s1 = " + s1); // [啥也没有]
  
          System.out.println("-----------------------------------------------");
          len = s2.size();
          for (int i = 1; i <= len; i++) {
              Object to = s2.pop();
              System.out.println("出栈的元素是：" + to); // 11 22 33 44 55
          }
      }
  }
  
  ```
  
  #####  

###  6 Queue集合（重点） 

-  基本概念
  -  java.util.Queue集合是Collection集合的子集合，与List集合属于平级关系。 
  - 该集合的主要用于描述具有先进先出特征的数据结构，叫做队列(first in first out FIFO)。
  -  该集合的主要实现类是LinkedList类，因为该类在增删方面比较有优势。 

- 常用方法

  | 方法声明           | 功能介绍                                   |
  | ------------------ | ------------------------------------------ |
  | boolean offer(E e) | 将一个对象添加至队尾，若添加成功则返回true |
  | E poll()           | 从队首删除并返回一个元素                   |
  | E peek()           | 返回队首的元素（但并不删除）               |

##### 案例  准备一个Queue集合，将数据11、22、33、44、55依次入队并打印，然后查看队首元素并打印， 然后将队列中所有数据依次出队并打印。 

```java

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        // 1.准备一个Queue集合并打印
        Queue queue = new LinkedList();
        System.out.println("队列中的元素有：" + queue); // [啥也没有]

        System.out.println("----------------------------------------------------------");
        // 2.将数据11、22、33、44、55依次入队并打印
        for (int i = 1; i <= 5; i++) {
            boolean b1 = queue.offer(i * 11);
            //System.out.println("b1 = " + b1);
            System.out.println("队列中的元素有：" + queue); // 11 22 33 44 55
        }

        System.out.println("----------------------------------------------------------");
        // 3.然后查看队首元素并打印
        System.out.println("对首元素是：" + queue.peek()); // 11

        System.out.println("----------------------------------------------------------");
        // 4.然后将队列中所有数据依次出队并打印
        int len = queue.size();
        for (int i = 1; i <= len; i++) {
            System.out.println("出队的元素是：" + queue.poll()); // 11 22 33 44 55
        }

        System.out.println("----------------------------------------------------------");
        // 5.查看队列中最终的元素
        System.out.println("队列中的元素有：" + queue); // [啥也没有]
    }
}

```

