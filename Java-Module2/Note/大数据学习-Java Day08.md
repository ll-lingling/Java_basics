# 大数据学习-Java Day08

## 多态和特殊类

### 多态

- 概念

  -  多态主要指同一种事物表现出来的多种形态。 

- 语法格式

  -  父类类型 引用变量名 = new 子类类型(); • 

    - ```java
      Shape sr = new Rect(); 
      sr.show(); 
      ```

- 特点
  -  当父类类型的引用指向子类类型的对象时，父类类型的引用可以直接调 用父类独有的方法。 
  - 当父类类型的引用指向子类类型的对象时，父类类型的引用不可以直接 调用子类独有的方法。 
  - 对于父子类都有的非静态方法来说，编译阶段调用父类版本，运行阶段 调用子类重写的版本（动态绑定）。  
  - 对于父子类都有的静态方法来说，编译和运行阶段都调用父类版本。 
- 引用数据类型间的转换
  -  引用数据类型之间的转换方式有两种：自动类型转换 和 强制类型转换。  
  - 自动类型转换主要指小类型向大类型的转换，也就是子类转为父类，也 叫做向上转型。  
  - 强制类型转换主要指大类型向小类型的转换，也就是父类转为子类，也 叫做向下转型或显式类型转换。 
  - 引用数据类型之间的转换必须发生在父子类之间，否则编译报错。 
  -  若强转的目标类型并不是该引用真正指向的数据类型时则编译通过，运 行阶段发生类型转换异常。 
  - 为了避免上述错误的发生，应该在强转之前进行判断，格式如下： if(引用变量 instanceof 数据类型) 判断引用变量指向的对象是否为后面的数据类型 

- 实际意义
  
  -  多态的实际意义在于屏蔽不同子类的差异性实现通用的编程带来不同的 效果。 
  
  

##### 案例  编程实现Shape类的封装，特征有：横纵坐标，要求提供打印所有特征的 方法。 编程实现Rect类的封装并继承自Shape类，特征有：长度和宽度。 编程实现ShapeRectTest类，在main方法中分别创建Shape和Rect类型对 象并打印特征。 

```java

public class Shape {
    private int x;
    private int y;

    public Shape() {
    }

    public Shape(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void show() {
        System.out.println("横坐标：" + getX() + "，纵坐标：" + getY());
    }

    // 自定义静态方法
    public static void test() {
        System.out.println("Shape类中的静态方法！");
    }
}

```

```java

public class Rect extends Shape {
    private int len;
    private int wid;

    public Rect() {
    }

    public Rect(int x, int y, int len, int wid) {
        super(x, y);
        setLen(len);
        setWid(wid);
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        if(len > 0) {
            this.len = len;
        } else {
            System.out.println("长度不合理哦！！！");
        }
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        if (wid > 0) {
            this.wid = wid;
        } else {
            System.out.println("宽度不合理哦！！！");
        }
    }

    @Override
    public void show() {
        super.show();
        System.out.println("长度是：" + getLen() + "，宽度是：" + getWid());
    }

    // 自定义静态方法
    //@Override Error: 历史原因、不是真正意义上的重写
    public static void test() {
        System.out.println("---Rect类中的静态方法！");
    }
}

```

```java

public class ShapeRectTest {

    public static void main(String[] args) {

        // 1.声明Shape类型的引用指向Shape类型的对象并打印特征
        Shape s1 = new Shape(1, 2);
        // 当Rect类中没有重写show方法时，下面调用Shape类中的show方法
        // 当Rect类中重写show方法后，下面调用Shape类中的show方法
        s1.show(); // 1 2

        // 使用ctrl+d快捷键可以复制当前行
        System.out.println("------------------------------------");
        // 2.声明Rect类型的引用指向Rect类型的对象并打印特征
        Rect r1 = new Rect(3, 4, 5, 6);
        // 当Rect类中没有重写show方法时，下面调用Shape类中的show方法
        // 当Rect类中重写show方法后，下面调用Rect类中的show方法
        r1.show(); // 3 4 5 6

        // 使用alt+shift+上下方向键  可以移动代码
        System.out.println("------------------------------------");
        // 3.声明Shape类型的引用指向Rect类型的对象并打印特征
        // 相当于从Rect类型到Shape类型的转换  也就是子类到父类的转换   小到大的转换  自动类型转换
        Shape sr = new Rect(7, 8, 9, 10);
        // 当Rect类中没有重写show方法时，下面调用Shape类中的show方法
        // 当Rect类中重写show方法后，下面的代码在编译阶段调用Shape类的方法，在运行阶段调用Rect类中的show方法
        sr.show(); // 7 8 9 10

        System.out.println("------------------------------------");
        // 4.测试Shape类型的引用能否直接调用父类和子类独有的方法呢？？？
        int ia = sr.getX();
        System.out.println("获取到的横坐标是：" + ia); // 7
        //sr.getLen();  error  Shape类中找不到getLen方法，也就是还在Shape类中查找

        // 调用静态方法
        sr.test(); // 提示：不建议使用引用.的方式访问
        Shape.test(); // 推荐使用类名.的方式访问

        System.out.println("------------------------------------");
        // 5.使用父类类型的引用调用子类独有方法的方式
        // 相当于从Shape类型到Rect类型的转换，也就是父类到子类的转换  大到小的转换   强制类型转换
        int ib = ((Rect) sr).getLen();
        System.out.println("获取到的长度是：" + ib); // 9

        // 希望将Shape类型转换为String类型  强制类型转换要求必须拥有父子类关系
        //String str1 = (String)sr;  Error
        // 希望将Shape类型强制转换为Circle类型，下面没有报错
        //Circle c1 = (Circle)sr; // 编译ok，但运行阶段发生  ClassCastException类型转换异常

        // 在强制类型转换之前应该使用instanceof进行类型的判断
        // 判断sr指向堆区内存中的对象是否为Circle类型，若是则返回true，否则返回false
        if(sr instanceof Circle) {
            System.out.println("可以放心地转换了！");
            Circle c1 = (Circle)sr;
        } else {
            System.out.println("强转有风险，操作需谨慎！");
        }
    }
}

```

```java

public class ShapeTest {

    // 自定义成员方法实现将参数指定矩形对象特征打印出来的行为，也就是绘制图形的行为
    // Rect r = new Rect(1, 2, 3, 4);
//    public static void draw(Rect r) {
//        r.show(); // 1 2 3 4
//    }
    // 自定义成员方法实现将参数指定圆形对象特征打印出来的行为
//    public static void draw(Circle c) {
//        c.show(); // 5 6 7
//    }
    // 自定义成员方法实现既能打印矩形对象又能打印圆形对象的特征，对象由参数传入  子类 is a 父类
    // Shape s = new Rect(1, 2, 3, 4);   父类类型的引用指向子类类型的对象，形成了多态
    // Shape s = new Circle(5, 6, 7);    多态
    // 多态的使用场合一：通过参数传递形成了多态
    public static void draw(Shape s) {
        // 编译阶段调用父类的版本，运行阶段调用子类重写以后的版本
        s.show();
    }

    public static void main(String[] args) {

        // Rect r = new Rect(1, 2, 3, 4);
        // r.show();
        ShapeTest.draw(new Rect(1, 2, 3, 4));
        ShapeTest.draw(new Circle(5, 6, 7));
    }
}

```



### 抽象类

- 概念
  -  抽象方法主要指不能具体实现的方法并且使用abstract关键字修饰，也就 是没有方法体。  
    - 具体格式如下： 
      - 访问权限 abstract 返回值类型 方法名(形参列表); 
      - public abstract void cry(); 
  -  抽象类主要指不能具体实例化的类并且使用abstract关键字修饰，也就是 不能创建对象。 
  
- 抽象类与抽象方法的关系
  -  抽象类中可以有成员变量、构造方法、成员方法；  
  - 抽象类中可以没有抽象方法，也可以有抽象方法；  
  - 拥有抽象方法的类必须是抽象类，因此真正意义上的抽象类应该是具有 抽象方法并且使用abstract关键字修饰的类。 

- 实际意义

  -  抽象类的实际意义不在于创建对象而在于被继承。  
  - 当一个类继承抽象类后必须重写抽象方法，否则该类也变成抽象类，也 就是抽象类对子类具有强制性和规范性，因此叫做模板设计模式 
  -  在开发中推荐使用多态的格式，此时父类类型引用直接调用的所 有方法一定是父类中拥有的方法，若以后更换子类时，只需要将new关键 字后面的子类类型修改而其它地方无需改变就可以立即生效，从而提高 了代码的可维护性和可扩展型。  
  - 该方式的缺点就是：父类引用不能直接调用子类独有的方法，若调用则 需要强制类型转换 

- ```java
  
  public abstract class AbstractTest {
      private int cnt;
  
      public AbstractTest() {
      }
  
      public AbstractTest(int cnt) {
          setCnt(cnt);
      }
  
      public int getCnt() {
          return cnt;
      }
  
      public void setCnt(int cnt) {
          this.cnt = cnt;
      }
  
      // 自定义抽象方法
      public abstract void show();
  
      public static void main(String[] args) {
  
          // 声明该类类型的引用指向该类类型的对象
          //AbstractTest at = new AbstractTest();
          //System.out.println("at.cnt = " + at.cnt); // 0
      }
  }
  
  ```

  ```java
  
  public class SubAbstractTest extends AbstractTest/*, Account*/ {
      @Override
      public void show() {
          System.out.println("其实我是被迫重写的，否则我也得变成抽象的呀！");
      }
  
      public static void main(String[] args) {
  
          // 1.声明本类类型的引用指向本类类型的对象，没有多态
          SubAbstractTest sat = new SubAbstractTest();
          sat.show();
  
          System.out.println("-------------------------------");
          // 2.声明AbstractTest类型的引用指向子类的对象，形成了多态
          // 多态的使用场合之二： 直接在方法体中使用抽象类的引用指向子类类型的对象
          AbstractTest at = new SubAbstractTest2();
          // 编译阶段调用父类版本，运行阶段调用子类版本
          at.show();
          ((SubAbstractTest2) at).test();
  
          System.out.println("-------------------------------");
          SubAbstractTest2 sat2 = new SubAbstractTest2();
          sat2.test();
      }
  }
  
  ```

  ```java
  
  public class SubAbstractTest2 extends AbstractTest {
      @Override
      public void show() {
          System.out.println("使用多态方式可以提高代码的可维护性哦！");
      }
  
      public void test() {
          System.out.println("第二个子类中独有的方法！");
      }
  }
  
  ```

  

- 应用

  -  银行有 定期账户和活期账户。继承自 账户类。账户类中： 

    - ```java
      public class Account{
      	private double money;
      	public double getLixi(){}
      }
      ```
      
      ```java
      public /*final*/ abstract class Account {
          private int money;
      
          public Account() {
          }
      
          public Account(int money) {
              setMoney(money);
          }
      
          public int getMoney() {
              return money;
          }
      
          public void setMoney(int money) {
              if (money >= 0) {
                  this.money = money;
              } else {
                  System.out.println("金额不合理哦！！！");
              }
          }
      
          // 自定义抽象方法实现计算利息并返回的功能描述
          public abstract double getLixi();
          // private 和 abstract 关键字不能共同修饰一个方法
          //private abstract double getLixi();
          // final 和 abstract 关键字不能共同修饰一个方法
          //public final abstract double getLixi();
          // static 和 abstract 关键字不能共同修饰一个方法
          //public static abstract double getLixi();
      }
      
      ```
      
      ```java
      
      public class FixedAccount extends Account {
          public FixedAccount() {
          }
      
          public FixedAccount(int i) {
              super(i); // 表示调用父类的有参构造方法
          }
      
          @Override
          public double getLixi() {
              // 利息 = 本金 * 利率 * 时间
              return getMoney() * 0.03 * 1;
          }
      
          public static void main(String[] args) {
      
              // 1.声明Account类型的引用指向子类类型的对象，形成了多态
              //Account acc = new FixedAccount(1000);
              Account acc = new FixedAccount();
              acc.setMoney(1000);
              double res = acc.getLixi();
              System.out.println("计算的利息是：" + res); // 30.0
          }
      }
      
      ```
      
      

### 接口

- 概念
  - 接口就是一种比抽象类还抽象的类，体现在所有方法都为抽象方法。  
  
- 定义类的关键字是class，而定义接口的关键字是interface。 
  
  - ```java
    public interface InterfaceTest {
        /*public static final */int CNT = 1;  // 里面只能有常量
        //private void show(){}  // 从Java9开始允许接口中出现私有方法
        /*public abstract */void show();         // 里面只能有抽象方法（新特性除外），注释中的关键字可以省略，但建议写上
    }
    
    ```
  
    
  
- 类与接口的关系

  - | 名称       | 关键字                           | 关系       |
    | ---------- | -------------------------------- | ---------- |
    | 类和类     | 使用extends关键字表达继承关系    | 支持单继承 |
    | 类和接口   | 使用implements关键字表达实现关系 | 支持多实现 |
    | 接口与接口 | 使用extends关键字表达继承关系    | 支持多继承 |

- 抽象类与接口的主要区别

  -  定义抽象类的关键字是abstract class，而定义接口的关键字是interface。 
  - 继承抽象类的关键字是extends，而实现接口的关键字是implements。 
  - 继承抽象类支持单继承，而实现接口支持多实现。  
  - 抽象类中可以有构造方法，而接口中不可以有构造方法。  
  - 抽象类中可以有成员变量，而接口中只可以有常量。 
  -  抽象类中可以有成员方法，而接口中只可以有抽象方法。  
  - 抽象类中增加方法时子类可以不用重写，而接口中增加方法时实现类需 要重写（Java8以前的版本）。  
  - 从Java8开始增加新特性，接口中允许出现非抽象方法和静态方法，但非 抽象方法需要使用default关键字修饰。  
  - 从Java9开始增加新特性，接口中允许出现私有方法。 



##### 案例   编程实现Runner接口，提供一个描述奔跑行为的抽象方法。 编程实现Hunter接口继承Runner接口，并提供一个描述捕猎行为的抽象 方法。 编程实现Man类实现Hunter接口并重写抽象方法，在main方法中使用多 态方式测试。 



```java
public interface Runner {
    // 自定义抽象方法描述奔跑的行为
    public abstract void run();
}

```

```java

// 接口只能继承接口，不能继承类
public interface Hunter extends Runner {
    // 自定义成员方法描述捕猎的行为
    public abstract void hunt();

    // 将两个默认方法中重复的代码可以提取出来打包成一个方法在下面的两个方法中分别调用即可
    private void show() {
        System.out.println("在以后的开发中尽量减少重复的代码，也就是减少代码的冗余！");
    }
    // 增加一个抽象方法
    //public abstract void show1();
    // 增加非抽象方法
    public default void show1() {
        show();
        //System.out.println("在以后的开发中尽量减少重复的代码，也就是减少代码的冗余！");
        System.out.println("show1方法中：这里仅仅是接口中的默认功能，实现类可以自由选择是否重写！");
    }

    // 增加非抽象方法
    public default void show2() {
        show();
        //System.out.println("在以后的开发中尽量减少重复的代码，也就是减少代码的冗余！");
        System.out.println("show2方法中：这里仅仅是接口中的默认功能，实现类可以自由选择是否重写！");
    }

    // 增加静态方法 隶属于类层级，也就是接口层级
    public static void test() {
        System.out.println("这里是静态方法，可以直接通过接口名.的方式调用，省略对象的创建");
    }


}
```

```java

public class Man implements Hunter {
    @Override
    public void hunt() {
        System.out.println("正在追赶一直小白兔...");
    }

    @Override
    public void run() {
        System.out.println("正在被一直大熊追赶，玩命奔跑中...");
    }

    @Override
    public void show1() {
        System.out.println("为了给你几分薄面，我决定重写一下！");
    }

    public static void main(String[] args) {

        // 1.声明接口类型的引用指向实现类的对象，形成了多态
        Runner runner = new Man();
        runner.run();

        Hunter hunter = new Man();
        hunter.hunt();

        System.out.println("-----------------------------------------");
        // 2.可以使用接口名称.的方式调用接口中的静态方法
        Hunter.test();
    }
}

```

​	