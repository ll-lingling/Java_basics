# 大数据学习-Java Day09

## 特殊类

### 内部类

- 概念

  -  当一个类的定义出现在另外一个类的类体中时，那么这个类叫做内部类 （Inner），而这个内部类所在的类叫做外部类（Outer）。 
  -  类中的内容：成员变量、成员方法、构造方法、静态成员、构造块和静 态代码块、内部类。 

- 实际作用

  -  当一个类存在的价值仅仅是为某一个类单独服务时，那么就可以将这个 类定义为所服务类中的内部类，这样可以隐藏该类的实现细节并且可以 方便的访问外部类的私有成员而不再需要提供公有的get和set方法。 

- 分类

  -  普通内部类 - 直接将一个类的定义放在另外一个类的类体中。  
  -  静态内部类 - 使用static关键字修饰的内部类，隶属于类层级。  
  -  局部内部类 - 直接将一个类的定义放在方法体的内部时。  
  -  匿名内部类 - 就是指没有名字的内部类。 

- 普通（成员）内部类

  - 格式 

    - ```java
      访问修饰符 class 外部类的类名 { 
      	访问修饰符 class 内部类的类名 { 
      		内部类的类体; 
      	} 
      }  
      ```

      

  - 普通内部类的使用方式

    -  普通内部类和普通类一样可以定义成员变量、成员方法以及构造方法等。
    -  普通内部类和普通类一样可以使用final或者abstract关键字修饰。
    -  普通内部类还可以使用private或protected关键字进行修饰。
    -  普通内部类需要使用外部类对象来创建对象。
    -  如果内部类访问外部类中与本类内部同名的成员变量或方法时，需要使 用this关键字。

  - ```java
    /**
     * 编程实现普通内部类的定义和使用       -  文档注释
     */
    public class NormalOuter {
        private int cnt = 1;
    
        // 定义普通内部类，隶属于外部类的成员，并且是对象层级
        /*private*/public /*final*/ class NormalInner {
            private int ia = 2;
            private int cnt = 3;
            public NormalInner() {
                System.out.println("普通内部类的构造方法体执行到了！");
            }
    
            public void show() {
                System.out.println("外部类中变量cnt的数值为：" + cnt); // 1
                System.out.println("ia = " + ia); // 2
            }
    
            public void show2(int cnt) {
                System.out.println("形参变量cnt = " + cnt);  // 局部优先原则  4
                System.out.println("内部类中cnt = " + this.cnt); // 3
                System.out.println("外部类中cnt = " + NormalOuter.this.cnt); // 1
            }
        }
    }
    ```

     

    ```java
    public class NormalOuterTest {
    
        public static void main(String[] args) {
    
            // 1.声明NormalOuter类型的引用指向该类型的对象
            NormalOuter no = new NormalOuter();
            // 2.声明NormalOuter类中内部类的引用指向内部类的对象
            NormalOuter.NormalInner ni = no.new NormalInner();
            // 调用内部类中的show方法
            ni.show();
    
            System.out.println("---------------------------------------------");
            ni.show2(4);
        }
    }
    
    ```

- 静态内部类

  - 格式

    -  访问修饰符 class 外部类的类名 { 访问修饰符 static class 内部类的类名 { 内部类的类体; } }  

  - 使用方式

    -  静态内部类不能直接访问外部类的非静态成员。
    -  静态内部类可以直接创建对象。
    -  如果静态内部类访问外部类中与本类内同名的成员变量或方法时，需要 使用类名.的方式访问。

  - ```java
    /**
     * 实现静态内部类的定义和使用
     */
    public class StaticOuter {
        private int cnt = 1;        // 隶属于对象层级
        private static int snt = 2; // 隶属于类层级
    
        public /*static*/ void show() {
            System.out.println("外部类的show方法就是这里！");
        }
    
        /**
         * 定义静态内部类   有static关键字修饰隶属于类层级
         */
        public static class StaticInner {
            private int ia = 3;
            private static int snt = 4;
    
            public StaticInner() {
                System.out.println("静态内部类的构造方法哦！");
            }
    
            public void show() {
                System.out.println("ia = " + ia); // 3
                System.out.println("外部类中的snt = " + snt); // 2
                //System.out.println("外部类的cnt = " + cnt); // Error:静态上下文中不能访问非静态的成员，因此此时可能还没有创建对象
            }
    
            public void show2(int snt) {  // 就近原则
                System.out.println("snt = " + snt); // 5
                System.out.println("内部类中的成员snt = " + StaticInner.snt); // 4
                System.out.println("外部类中的成员snt = " + StaticOuter.snt); // 2
                //StaticOuter.show();
                new StaticOuter().show();
            }
        }
    }
    ```

    ```java
    public class StaticOuterTest {
    
        public static void main(String[] args) {
    
            // 1.声明StaticInner类型的引用指向该类型的对象
            StaticOuter.StaticInner si = new StaticOuter.StaticInner();
            // 2.调用show方法进行测试
            si.show();
    
            System.out.println("---------------------------------------------");
            si.show2(5);
        }
    }
    
    ```

- 局部（方法）内部类

  - 格式

    - ```
      访问修饰符 class 外部类的类名 { 
      	访问修饰符 返回值类型 成员方法名（形参列表） { 
      		class 内部类的类名 { 
      			内部类的类体; 
      			} 
            } 
      }  
      ```

      

  - 使用方式

    -  局部内部类只能在该方法的内部可以使用。
    -  局部内部类可以在方法体内部直接创建对象。
    -  局部内部类不能使用访问控制符和static关键字修饰符。
    -  局部内部类可以使用外部方法的局部变量，但是必须是final的。由局部内 部类和局部变量的声明周期不同所致 

  - ```java
    /**
     * 编程实现局部内部类的定义和使用
     */
    public class AreaOuter {
        private int cnt = 1;
    
        public void show() {
    
            // 定义一个局部变量进行测试，从Java8开始默认理解为final关键字修饰的变量
            // 虽然可以省略final关键字，但建议还是加上
            final int ic = 4;
    
            // 定义局部内部类，只在当前方法体的内部好使    拷贝一份
            class AreaInner {
                private int ia = 2;
    
                public AreaInner() {
                    System.out.println("局部内部类的构造方法！");
                }
    
                public void test() {
                    int ib = 3;
                    System.out.println("ia = " + ia); // 2
                    System.out.println("cnt = " + cnt); // 1
                    //ic = 5;  Error
                    System.out.println("ic = " + ic); // 4
                }
            }
    
            // 声明局部内部类的引用指向局部内部类的对象
            AreaInner ai = new AreaInner();
            ai.test();
        }
    
    }
    
    ```

    ```java
    public class AreaOuterTest {
    
        public static void main(String[] args) {
    
            // 1.声明外部类类型的引用指向外部类的对象
            AreaOuter ao = new AreaOuter();
            // 2.通过show方法的调用实现局部内容类的定义和使用
            ao.show();
        }
    }
    
    ```

- 回调模式

  -  回调模式是指——如果一个方法的参数是接口类型，则在调用该方法时， 需要创建并传递一个实现此接口类型的对象；而该方法在运行时会调用 到参数对象中所实现的方法（接口中定义的）。 
  -  当接口/类类型的引用作为方法的形参时，实参的传递方式有两种： 
     - 自定义类实现接口/继承类并重写方法，然后创建该类对象作为实参传递；  
     - 使用上述匿名内部类的语法格式得到接口/类类型的引用即可； 

- 匿名内部类 

  - 语法格式

    - ```
      接口/父类类型 引用变量名 = new 接口/父类类型() { 方法的重写 }; 
      ```

  - ```java
    public class AnonymousInterfaceTest {
    
        // 假设已有下面的方法，请问如何调用下面的方法？
        // AnonymousInterface ai = new AnonymousInterfaceImpl();
        // 接口类型的引用指向实现类型的对象，形成了多态
        public static void test(AnonymousInterface ai) {
            // 编译阶段调用父类版本，运行调用实现类重写的版本
            ai.show();
        }
    
        public static void main(String[] args) {
    
            //AnonymousInterfaceTest.test(new AnonymousInterface()); // Error:接口不能实例化
            AnonymousInterfaceTest.test(new AnonymousInterfaceImpl());
    
            System.out.println("---------------------------------------------------------------");
            // 使用匿名内部类的语法格式来得到接口类型的引用，格式为：接口/父类类型 引用变量名 = new 接口/父类类型() { 方法的重写 };
            AnonymousInterface ait = new AnonymousInterface() {
                @Override
                public void show() {
                    System.out.println("匿名内部类就是这么玩的，虽然你很抽象！");
                }
            };
    
            // 从Java8开始提出新特性lamda表达式可以简化上述代码，格式为：(参数列表) -> {方法体}
            AnonymousInterface ait2 = () -> System.out.println("lamda表达式原来是如此简单！");
            AnonymousInterfaceTest.test(ait2);
        }
    }
    ```

    ```java
    public interface AnonymousInterface {
        // 自定义抽象方法
        public abstract void show();
    }
    
    ```

    ```java
    public class AnonymousInterfaceImpl implements AnonymousInterface {
        @Override
        public void show() {
            System.out.println("这里是接口的实现类！");
        }
    }
    
    ```

    

### 枚举

- 概念

  - 在日常生活中这些事物的取值只有明确的几个固定值，此时描述这些事 物的所有值都可以一一列举出来，而这个列举出来的类型就叫做枚举类 型。

  - ```java
    /**
     * 编程实现所有方向的枚举，所有的方向：向上、向下、向左、向右
     */
    public class Direction {
        private final String desc; // 用于描述方向字符串的成员变量
    
        // 2.声明本类类型的引用指向本类类型的对象
        public static final Direction UP = new Direction("向上");
        public static final Direction DOWN = new Direction("向下");
        public static final Direction LEFT = new Direction("向左");
        public static final Direction RIGHT = new Direction("向右");
    
        // 通过构造方法实现成员变量的初始化，更加灵活
        // 1.私有化构造方法，此时该构造方法只能在本类的内部使用
        private Direction(String desc) {
            this.desc = desc;
        }
    
        // 通过公有的get方法可以在本类的外部访问该类成员变量的数值
        public String getDesc() {
            return desc;
        }
    }
    
    ```

     

    ```java
    public class DirectionTest {
    
        public static void main(String[] args) {
    
            /*// 1.声明Direction类型的引用指向该类型的对象并打印特征
            Direction d1 = new Direction("向上");
            System.out.println("获取到的字符串是：" + d1.getDesc()); // 向上
    
            Direction d2 = new Direction("向下");
            System.out.println("获取到的字符串是：" + d2.getDesc()); // 向下
    
            Direction d3 = new Direction("向左");
            System.out.println("获取到的字符串是：" + d3.getDesc()); // 向左
    
            Direction d4 = new Direction("向右");
            System.out.println("获取到的字符串是：" + d4.getDesc()); // 向右
    
            System.out.println("-------------------------------------");
            Direction d5 = new Direction("向前");
            System.out.println("获取到的字符串是：" + d5.getDesc()); // 向前*/
    
            //Direction.UP = 2; Error:类型不匹配
            //Direction d2 = null;
            //Direction.UP = d2; Error: final关键字修饰
            Direction d1 = Direction.UP;
            System.out.println("获取到的方向是：" + d1.getDesc()); // 向上
    
            System.out.println("-------------------------------------");
            // 使用一下Java5开始的枚举类型
            DirectionEnum de = DirectionEnum.DOWN;
            System.out.println("获取到的方向是：" + de.getDesc()); // 向下
        }
    }
    
    ```

- 定义

  - 使用public static final表示的常量描述较为繁琐，使用enum关键字来定 义枚举类型取代常量，枚举类型是从Java5开始增加的一种引用数据类型。 • 

  - 枚举值就是当前类的类型，也就是指向本类的对象，默认使用public static final关键字共同修饰，因此采用枚举类型.的方式调用。 • 

  - 枚举类可以自定义构造方法，但是构造方法的修饰符必须是private，默 认也是私有的。

  - ```java
    /**
     * 编程实现所有方向的枚举，所有的方向：向上、向下、向左、向右   枚举类型要求所有枚举值必须放在枚举类型的最前面
     */
    public enum DirectionEnum {
        // 2.声明本类类型的引用指向本类类型的对象
        
        UP("向上") , DOWN("向下") , LEFT("向左") , RIGHT("向右") ;
    
        private final String desc; // 用于描述方向字符串的成员变量
    
        // 通过构造方法实现成员变量的初始化，更加灵活
        // 1.私有化构造方法，此时该构造方法只能在本类的内部使用
        private DirectionEnum(String desc) { this.desc = desc; }
    
        // 通过公有的get方法可以在本类的外部访问该类成员变量的数值
        public String getDesc() {
            return desc;
        }
    }
    
    ```

  - ```java
    public class DirectionUseTest {
    
        // 自定义静态方法实现根据参数指定的字符串内容来打印具体的方向信息
        public static void test1(String str) {
            switch (str) {
                case "向上":
                    System.out.println("抬头望明月！"); break;
                case "向下":
                    System.out.println("低头思故乡！"); break;
                case "向左":
                    System.out.println("左牵黄"); break;
                case "向右":
                    System.out.println("右擎苍"); break;
                default:
                    System.out.println("没有这样的方向哦！");
            }
        }
    
        // 自定义静态方法实现根据参数指定的枚举类型来打印具体的方向信息
        public static void test2(DirectionEnum de) {
            switch (de) {
                case UP:
                    System.out.println("抬头望明月！"); break;
                case DOWN:
                    System.out.println("低头思故乡！"); break;
                case LEFT:
                    System.out.println("左牵黄"); break;
                case RIGHT:
                    System.out.println("右擎苍"); break;
                default:
                    System.out.println("没有这样的方法哦！");
            }
        }
    
        public static void main(String[] args) {
    
            DirectionUseTest.test1(Direction.UP.getDesc());
            DirectionUseTest.test1("今天是个好日子！");
    
            System.out.println("--------------------------------------------");
            DirectionUseTest.test2(DirectionEnum.DOWN);
            //DirectionUseTest.test2("今天是个好日子！"); Error:类型不匹配，减少了出错的可能性
        }
    }
    
    ```

     

- Enum类的概念和方法 

  - 所有的枚举类都继承自java.lang.Enum类，常用方法如下： 

    - | static T[] values()          | 返回当前枚举类中的所有对象               |
      | ---------------------------- | ---------------------------------------- |
      | String toString()            | 返回当前枚举类对象的名称                 |
      | int ordinal()                | 获取枚举对象在枚举类中的索引位置         |
      | static T valueOf(String str) | 将参数指定的字符串名转为当前枚举类的对象 |
      | int compareTo(E o)           | 比较两个枚举对象在定义时的顺序           |

    ```java
    /**
     * 编程实现方向枚举类的测试，调用从Enum类中继承下来的方法
     */
    public class DirectionEnumTest {
    
        public static void main(String[] args) {
    
            // 1.获取DirectionEnum类型中所有的枚举对象
            DirectionEnum[] arr = DirectionEnum.values();
            // 2.打印每个枚举对象在枚举类型中的名称和索引位置
            for (int i = 0; i < arr.length; i++) {
                System.out.println("获取到的枚举对象名称是：" + arr[i].toString());
                System.out.println("获取到的枚举对象对应的索引位置是：" + arr[i].ordinal()); // 和数组一样下标从0开始
            }
    
            System.out.println("---------------------------------------------------------------");
            // 3.根据参数指定的字符串得到枚举类型的对象，也就是将字符串转换为对象
            //DirectionEnum de = DirectionEnum.valueOf("向下"); // 编译ok，运行发生IllegalArgumentException非法参数异常
            DirectionEnum de = DirectionEnum.valueOf("DOWN");
            //DirectionEnum de = DirectionEnum.valueOf("UP LEFT"); // 要求字符串名称必须在枚举对象中存在
            //System.out.println("转换出来的枚举对象名称是：" + de.toString());
            System.out.println("转换出来的枚举对象名称是：" + de); // 当打印引用变量时，会自动调用toString方法
    
            System.out.println("---------------------------------------------------------------");
            // 4.使用获取到的枚举对象与枚举类中已有的对象比较先后顺序
            for(int i = 0; i < arr.length; i++) {
                // 当调用对象在参数对象之后时，获取到的比较结果为 正数
                // 当调用对象在参数对象相同位置时，则获取到的比较结果为 零
                // 当调用对象在参数对象之前时，则获取到的比较结果为 负数
                System.out.println("调用对象与数组中对象比较的先后顺序结果是：" + de.compareTo(arr[i]));
            }
    
        }
    }
    
    ```

    

- 枚举类实现接口方式

  - 枚举类实现接口后需要重写抽象方法，而重写方法的方式有两种：重写 一个，或者每个对象都重写。

    ```java
    public interface DirectionInterface {
        // 自定义抽象方法
        public abstract void show();
    }
    
    ```

    ```java
    public enum DirectionEnum implements DirectionInterface {
        // 2.声明本类类型的引用指向本类类型的对象
        // 匿名内部类的语法格式：接口/父类类型 引用变量名 = new 接口/父类类型() { 方法的重写 };
        // public static final Direction UP = new Direction("向上") { 方法的重写 };
        UP("向上") {
            @Override
            public void show() {
                System.out.println("贪吃蛇向上移动了一下！");
            }
        }, DOWN("向下") {
            @Override
            public void show() {
                System.out.println("贪吃蛇向下移动了一下！");
            }
        }, LEFT("向左") {
            @Override
            public void show() {
                System.out.println("左移了一下！");
            }
        }, RIGHT("向右") {
            @Override
            public void show() {
                System.out.println("右移了一下！");
            }
        };
    
        private final String desc; // 用于描述方向字符串的成员变量
    
        // 通过构造方法实现成员变量的初始化，更加灵活
        // 1.私有化构造方法，此时该构造方法只能在本类的内部使用
        private DirectionEnum(String desc) { this.desc = desc; }
    
        // 通过公有的get方法可以在本类的外部访问该类成员变量的数值
        public String getDesc() {
            return desc;
        }
    
        // 整个枚举类型只重写一次，所有对象调用同一个
        /*@Override
        public void show() {
            System.out.println("现在可以实现接口中抽象方法的重写了！");
        }*/
    }
    
    ```

    ```java
    public class DirectionEnumTest {
    
        public static void main(String[] args) {
            // 使用数组中每个DirectionEnum对象都去调用show方法测试
            for (int i = 0; i < arr.length; i++) {
                arr[i].show();
            }
        }
    }
    
    ```

    

### 注解

- 概念

  -  注解（Annotation）又叫标注，是从Java5开始增加的一种引用数据类型。
  -  注解本质上就是代码中的特殊标记，通过这些标记可以在编译、类加载、 以及运行时执行指定的处理。 

- 语法格式

  - ```java
    访问修饰符 @interface 注解名称 { 
    	注解成员; 
    }  
    ```

    

  - 自定义注解自动继承java.lang.annotation.Annotation接口。

  - 通过@注解名称的方式可以修饰包、类、 成员方法、成员变量、构造方 法、参数、局部变量的声明等。 

- 使用方式

  -  注解体中只有成员变量没有成员方法，而注解的成员变量以“无形参的方 法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该 成员变量的类型。 • 
  -  如果注解只有一个参数成员，建议使用参数名为value，而类型只能是八 种基本数据类型、String类型、Class类型、enum类型及Annotation类型。 

- 元注解

  - 概念

    -  注解体中只有成员变量没有成员方法，而注解的成员变量以“无形参的方 法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该 成员变量的类型。 • 
    -  如果注解只有一个参数成员，建议使用参数名为value，而类型只能是八 种基本数据类型、String类型、Class类型、enum类型及Annotation类型。 

  - @Retention 

    -  @Retention 应用到一个注解上用于说明该注解的的生命周期，取值如下：
    -  RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时 它将被丢弃忽视。
    -  RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加 载到 JVM 中，默认方式。
    -  RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载 进入到 JVM 中，所以在程序运行时可以获取到它们。 

  - @Documented 

    -  使用javadoc工具可以从程序源代码中抽取类、方法、成员等注释形成一 个和源代码配套的API帮助文档，而该工具抽取时默认不包括注解内容。 • 
    -  @Documented用于指定被该注解将被javadoc工具提取成文档。 • 
    -  定义为@Documented的注解必须设置Retention值为RUNTIME 

  - @Target 

    - @Target用于指定被修饰的注解能用于哪些元素的修饰，取值如下 

      - | ElementType.ANNOTATION_TYPE | 可以给一个注解进行注解                 |
        | --------------------------- | -------------------------------------- |
        | ElementType.CONSTRUCTOR     | 可以给构造方法进行注解                 |
        | ElementType.FIELD           | 可以给属性进行注解                     |
        | ElementType.LOCAL_VARIABLE  | 可以给局部变量进行注解                 |
        | ElementType.METHOD          | 可以给方法进行注解                     |
        | ElementType.PACKAGE         | 可以给一个包进行注解                   |
        | ElementType.PARAMETER       | 可以给一个方法内的参数进行注解         |
        | ElementType.TYPE            | 可以给类型进行注解，比如类、接口、枚举 |

  - @Inherited  

    -  @Inherited并不是说注解本身可以继承，而是说如果一个超类被该注解标 记过的注解进行注解时，如果子类没有被任何注解应用时，则子类就继 承超类的注解。 

  ```java
  // 表示将标签MyAnnotation贴在Person类的代码中，使用注解时采用 成员参数名 = 成员参数值, ...
  //@MyAnnotation(value = "hello", value2 = "world")
  @MyAnnotation(value2 = "world")
  public class Person {
      /**
     * name是用于描述姓名的成员变量
       */
    @MyAnnotation(value2 = "1")
      private String name;
      /**
       * age是用于描述年龄的成员变量
       */
      private int age;
  
      /**
       * 编程实现无参构造方法
       */
      @MyAnnotation(value2 = "2")
      public Person() {
    }
  
      /**
       * 编程实现有参构造方法
       * @param name
       * @param age
       */
      public Person(@MyAnnotation(value2 = "4") String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      /**
       * 自定义成员方法实现特征的获取和修改
       * @return
       */
      @MyAnnotation(value2 = "3")
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
  }
  
  
  ```

  ```java
  import java.lang.annotation.*;
  
  //@Retention(RetentionPolicy.SOURCE)     // 表示下面的注解在源代码中有效
  //@Retention(RetentionPolicy.CLASS)      // 表示下面的注解在字节码文件中有效，默认方式
  @Retention(RetentionPolicy.RUNTIME)      // 表示下面的注解在运行时有效
  @Documented                              // 表示下面的注解信息可以被javadoc工具提取到API文档中，很少使用
  // 表示下面的注解可以用于类型、构造方法、成员变量、成员方法、参数 的修饰
  @Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
  @Inherited  // 表示下面的注解所修饰的类中的注解使用可以被子类继承
  // 若一个注解中没有任何的成员，则这样的注解叫做标记注解/标识注解
  public @interface MyAnnotation {
      //public Direction value(); // 声明一个String类型的成员变量，名字为value   类型有要求
      public String value() default "123"; // 声明一个String类型的成员变量，名字为value
      public String value2();
  }
  
  ```

  

  - @Repeatable 

    - @Repeatable表示自然可重复的含义，从Java8开始增加的新特性。 • 

      - 从Java8开始对元注解@Target的参数类型ElementType枚举值增加了两个： • 
      - 其中ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明 语句中，如：泛型。 • 其中ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。 

    - ```java
      @ManType(value = "职工")
      @ManType(value = "超人")
      //@ManTypes({@ManType(value = "职工"), @ManType(value = "超人")})  // 在Java8以前处理多个注解的方式
      public class Man {
      
          @Deprecated // 表示该方法已经过时，不建议使用
          public void show() {
              System.out.println("这个方法马上过时了！");
          }
      
          public static void main(String[] args) {
              int ia = 97;
              char c1 = (@ManType char) ia;
          }
      }
      
      ```

      ```java
      import java.lang.annotation.ElementType;
      import java.lang.annotation.Repeatable;
      import java.lang.annotation.Target;
      
      /**
       * 自定义注解用于描述任务的角色
       */
      @Repeatable(value = ManTypes.class)
      @Target(ElementType.TYPE_USE)
      public @interface ManType {
          String value() default "";
      }
      
      ```

      ```java
      import java.lang.annotation.ElementType;
      import java.lang.annotation.Target;
      
      /**
       * 自定义注解里面可以描述多种角色
       */
      @Target(ElementType.TYPE_USE)
      public @interface ManTypes {
          ManType[] value();
      }
      
      ```

      ```java
      public class ManTest {
      
          public static void main(String[] args) {
      
              Man man = new Man();
              man.show();
          }
      }
      
      ```

      

  - 常见预制注解

    - 预制注解就是Java语言自身提供的注解，具体如下： 

      - | @author           | 标明开发该类模块的作者，多个作者之间使用,分割           |
        | ----------------- | ------------------------------------------------------- |
        | @version          | 标明该类模块的版本                                      |
        | @see              | 参考转向，也就是相关主题                                |
        | @since            | 从哪个版本开始增加的                                    |
        | @param            | 对方法中某参数的说明，如果没有参数就不能写              |
        | @return           | 对方法返回值的说明，如果方法的返回值类型是void就 不能写 |
        | @exception        | 对方法可能抛出的异常进行说明                            |
        | @Override         | 限定重写父类方法, 该注解只能用于方法                    |
        | @Deprecated       | 用于表示所修饰的元素(类, 方法等)已过时                  |
        | @SuppressWarnings | 抑制编译器警告                                          |

        