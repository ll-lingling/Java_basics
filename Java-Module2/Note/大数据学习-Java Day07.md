# 大数据学习-Java Day07

##  static关键字和继承 

### static关键字

- 概念
  -  使用static关键字修饰成员变量表示静态的含义，此时成员变量由对象层 级提升为类层级，也就是**整个类只有一份并被所有对象共享，该成员变 量随着类的加载准备就绪，与是否创建对象无关**。 • 
  - static关键字修饰的成员可以使用引用.的方式访问，但推荐类名.的方式。 
  
- 使用方式
  - 在非静态成员方法中既能访问非静态的成员又能访问静态的成员。 (成员：成员变量 + 成员方法， 静态成员被所有对象共享) 
  
  - 在静态成员方法中只能访问静态成员不能访问非静态成员。 (成员：成员变量 + 成员方法， 因为此时可能还没有创建对象) 
  
  - 在开发中只有隶属于类层级并被所有对象共享的内容才可以使用 static关键字修饰。(不能滥用static关键字) 
  
  - ```java
    /*
        编程实现static关键字的使用
     */
    public class StaticTest {
    	
    	private int cnt = 1; // 隶属于对象层级，也就是每个对象都拥有独立的一份
    	private static int snt = 2; // 隶属于类层级，也就是所有对象都共享同一份
    	
    	// 自定义非静态的成员方法  需要使用引用.的方式访问
    	public void show() {
    		System.out.println("cnt = " + this.cnt); // 1
    		System.out.println("snt = " + this.snt); // 2  静态成员被所有对象共享，this关键字可以省略
    	}
    	// 自定义静态的成员方法 推荐使用类名.的方式访问
    	public static void test() {
    		// StaticTest st = new StaticTest();
    		//System.out.println("cnt = " + cnt); // 1   静态成员方法中没有this关键字，因为是可以通过类名.方式调用的
    		System.out.println("snt = " + snt); // 2 
    	}
    	
    	public static void main(String[] args) {
    		
    		StaticTest st = new StaticTest();
    		st.show();
    		
    		System.out.println("--------------------------------");
    		StaticTest.test();
    	}
    }
    ```
  
    
  
-  构造块和静态代码块 
  - 构造块：在类体中直接使用{}括起来的代码块。  
  
  - 每创建一个对象都会执行一次构造块。  
  
  - 静态代码块：使用static关键字修饰的构造块。  
  
  - 静态代码块随着类加载时执行一次。 
  
  - ```java
    /*
        编程实现构造块和静态代码块的使用
     */
    public class BlockTest {
    	
    	// 当需要在执行构造方法体之前做一些准备工作时，则将准备工作的相关代码写在构造块中即可，比如：对成员变量进行的统一初始化操作
    	{
    		System.out.println("构造块！"); // (2)
    	}
    	
    	// 静态代码块会随着类的加载而准备就绪，会先于构造块执行
    	// 当需要在执行代码块之前随着类的加载做一些准备工作时，则编写代码到静态代码块中，比如：加载数据库的驱动包等
    	static {
    		System.out.println("#####################静态代码块！");   // (1)
    	}
    	
    	// 自定义构造方法
    	public BlockTest() {
    		System.out.println("====构造方法体！"); // (3)
    	}
    	
    	public static void main(String[] args) {
    		
    		BlockTest bt = new BlockTest();
    		
    		
    		BlockTest bt2 = new BlockTest();
    	}
    }
    ```
  
    
  
- main方法说明

  - ```java
    /*
        编程实现main方法的测试
     */
    public class MainTest {
    	
    	public static void main(String[] args) {
    		
    		System.out.println("参数数组中元素的个数是：" + args.length);
    		System.out.println("传递给main方法的实际参数为：");
    		for(int i = 0; i < args.length; i++) {
    			System.out.println("下标为" + i + "的形参变量数值为：" + args[i]);
    		}
    	}
    }
    ```

    

##### 案例  编程实现People类的封装，特征有：姓名、年龄、国籍，要求提供打印 所有特征的方法。  编程实现PeopleTest类，main方法中使用有参方式构造两个对象并打印。 

```java

public class People {
	
	// 1.私有化成员变量，使用private关键字修饰
	private String name;
	private int age;
	//private String country; // 隶属于对象层级，也就是每个对象都拥有独立的一份
	//public static String country; // 隶属于类层级，也就是整个类只有一份并且被所有对象共享
	private static String country;
	
	// 3.在构造方法中调用set方法进行合理值的判断
	public People() {}
	public People(String name, int age/*, String country*/) {
		setName(name);
		setAge(age);
		//setCountry(country);
	}
	
	// 2.提供公有的get和set方法，并在方法体中进行合理值的判断
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
		if(age > 0 && age < 150) {
			this.age = age;
		} else {
			System.out.println("年龄不合理哦！！！");
		}
	}
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		//this.country = country;
		People.country = country;
	}
	
	public void show() {
		System.out.println("我是" + getName() + "，今年" + getAge() + "岁了，来自" + getCountry());
	}
}
```

```java
public class PeopleTest {
	
	public static void main(String[] args) {
		
		// 3.验证static关键字修饰的静态成员(类成员)是否与创建对象无关  类名.的方式 => 无关
		//System.out.println("获取到的国籍信息是：" + People.country); // null
		System.out.println("获取到的国籍信息是：" + People.getCountry()); // null
		
		// 1.使用有参方式构造两个People类型的对象并打印特征
		People p1 = new People("zhangfei", 30/*, "China"*/);
		p1.show(); // zhangfei 30 China
		
		People p2 = new People("guanyu", 35/*, "China"*/);
		p2.show(); // guanyu 35 China

		System.out.println("--------------------------------------------");
		// 2.验证static关键字修饰的静态成员(类成员) 是否被所有对象共享  => 共享
		//p1.country = "蜀国";
		p1.setCountry("蜀国");
		//System.out.println("第一个对象的国籍是：" + p1.country); // 蜀国
		//System.out.println("第二个对象的国籍是：" + p2.country); // 蜀国
		System.out.println("第一个对象的国籍是：" + p1.getCountry()); // 蜀国
		System.out.println("第二个对象的国籍是：" + p2.getCountry()); // 蜀国
		
		People p3 = new People();
		//System.out.println("第三个对象的国籍是：" + p3.country); // 蜀国
		System.out.println("第三个对象的国籍是：" + p3.getCountry()); // 蜀国
	}
}
```



- 单例设计模式
  - 概念
    -  在某些特殊场合中，一个类对外提供且只提供一个对象时，这样的类叫 做单例类，而设计单例的流程和思想叫做单例设计模式。 
  - 实现流程
    -  私有化构造方法，使用private关键字修饰。  
    - 声明本类类型的引用指向本类类型的对象，并使用private static关键字共 同修饰。  
    - 提供公有的get方法负责将对象返回出去，并使用public static关键字共同 修饰。 
  - 实现方式
    -  单例设计模式的实现方式有两种：饿汉式 和 懒汉式，在开发中推 荐饿汉式。 

##### 案例  编程实现Singleton类的封装。 编程实现SingletonTest类对Singleton类进行测试，要求main方法中能得 到且只能得到该类的一个对象。 

```java
public class Singleton {
	
	// 2.声明本类类型的引用指向本类类型的对象，使用private static关键字共同修饰
	//private static Singleton sin = new Singleton();  // 饿汉式
	private static Singleton sin = null;               // 懒汉式
	
	// 1.私有化构造方法，使用private关键字修饰
	private Singleton() {}
	
	// 3.提供公有的get方法负责将对象返回出去，使用public static关键字共同修饰
	public static Singleton getInstance() {
		//return sin;
		if(null == sin) {
			sin = new Singleton();
		}
		return sin;
	}
}
```

```java
public class SingletonTest {
	
	public static void main(String[] args) {
		
		// 1.声明Singleton类型的引用指向该类型的对象
		//Singleton s1 = new Singleton();
		//Singleton s2 = new Singleton();
		//System.out.println(s1 == s2); // 比较变量s1的数值是否与变量s2的数值相等  false
		//Singleton.sin = null;  可以使得引用变量无效
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2); // true
	}
}
```



### 继承

- 概念
  - 当多个类之间有相同的特征和行为时，可以将相同的内容提取出来组成 一个公共类，让多个类吸收公共类中已有特征和行为而在多个类型只需 要编写自己独有特征和行为的机制，叫做继承。 
  
  -  在Java语言中使用extends(扩展)关键字来表示继承关系。 • 
    -  public class Worker extends Person{} - 表示Worker类继承自Person类 其中Person类叫做超类、父类、基类。 
    - 其中Worker类叫做派生类、子类、孩子类。 • 
    
  - 使用继承提高了代码的复用性，可维护性及扩展性，是多态的前提条件。 
  
  - ```java
    /*
        编程实现Person类的封装
     */
    public class Person {
    	
    	// 1.私有化成员变量，使用private关键字修饰
    	private String name;
    	private int age;
    	//private boolean gender; // 性别
    	
    	// 3.在构造方法中调用set方法进行合理值的判断
    	public Person() {
    		System.out.println("Person()");
    	}
    	public Person(String name, int age) {
    		System.out.println("Person(String, int)");
    		setName(name);
    		setAge(age);
    	}
    	
    	// 2.提供公有的get和set方法并在方法体中进行合理值的判断
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
    		if(age > 0 && age < 150) {
    			this.age = age;
    		} else {
    			System.out.println("年龄不合理哦！！！");
    		}
    	}
    	
    	// 自定义成员方法实现特征的打印
    	public void show() {
    		System.out.println("我是" + getName() + "，今年" + getAge() + "岁了！");
    	}
    	// 自定义成员方法描述吃饭的行为
    	public void eat(String food) {
    		System.out.println(food + "真好吃！");
    	}
    	// 自定义成员方法描述娱乐的行为
    	public void play(String game) {
    		System.out.println(game + "真好玩！");
    	}
    }
    ```
  
    ```java
    /*
        自定义Worker类继承自Person类
     */
    public class Worker extends Person {
    	
    	private int salary;
    	
    	public Worker() {
    		super(); // 表示调用父类的无参构造方法，若没有加则编译器自动添加
    		System.out.println("Worker()");
    	}
    	public Worker(String name, int age, int salary) {
    		super(name, age); // 表示调用父类的有参构造方法
    		System.out.println("Worker(String, int, int)");
    		//setName(name);
    		//setAge(age);
    		setSalary(salary);
    	}
    	
    	public int getSalary() {
    		return salary;
    	}
    	public void setSalary(int salary) {
    		if(salary >= 2200) {
    			this.salary = salary;
    		} else {
    			System.out.println("薪水不合理哦！！！");
    		}
    	}
    	
    	// 自定义成员方法描述工作的行为
    	public void work() {
    		System.out.println("今天的砖头有点烫手...");
    	}
    	// 自定义show方法覆盖从父类中继承的版本
    	@Override  // 标注/注解，用于说明下面的方法是对父类方法的重写，若没有构成重写则编译报错
    	public void show() {
    		super.show(); // 表示调用父类的show方法
    		System.out.println("我的薪水是：" + getSalary());
    	}
    }
    ```
  
    ```java
    /*
        编程实现Worker类的测试
     */
    public class WorkerTest {
    	
    	public static void main(String[] args) {
    		
    		// 1.使用无参方式构造Worker类型的对象并打印特征
    		Worker w1 = new Worker();
    		// 当子类重写show方法后，则下面调用的是重写以后的版本
    		w1.show(); // null  0
    		
    		System.out.println("----------------------------------");
    		// 2.使用有参方式构造Worker类型的对象并打印特征
    		Worker w2 = new Worker("zhangfei", 30, 3000);
    		w2.show(); // zhangfei ...
    		// 调用成员方法测试
    		w2.eat("豆芽");
    		w2.play("王者荣耀");
    		w2.work();
    	}
    }
    ```
  
- 特点
  -  子类不能继承父类的构造方法和私有方法，但私有成员变量可以被继承 只是不能直接访问。  
  - 无论使用何种方式构造子类的对象时都会自动调用父类的无参构造方法， 来初始化从父类中继承的成员变量，相当于在构造方法的第一行增加代 码super()的效果。 
  -  使用继承必须满足逻辑关系：子类 is a 父类，也就是不能滥用继承。  
  - Java语言中只支持单继承不支持多继承，也就是说一个子类只能有一个父 类，但一个父类可以有多个子类。 
- 方法重写
  - 概念
    -  从父类中继承下来的方法不满足子类的需求时，就需要在子类中重新写 一个和父类一样的方法来覆盖从父类中继承下来的版本，该方式就叫做 方法的重写（Override）。 
  - 原则
    -  要求方法名相同、参数列表相同以及返回值类型相同，从Java5开始允许 返回子类类型。  
    - 要求方法的访问权限不能变小，可以相同或者变大。  
    - 要求方法不能抛出更大的异常(异常机制)。 

##### 案例   编程实现Animal类的封装，特征有：名字和毛色，要求提供打印所有特 征的方法。 编程实现Dog类的封装并继承自Animal类，该类的特征有：牙齿数量，要 求提供打印所有特征的方法。 编程实现DogTest类，在main方法中分别使用无参和有参方式构造Dog类 型对象并打印特征。 

```java
public class Animal {
    private String name;
    private String color;

    public Animal() {
    }
    public Animal(String name, String color) {
        setName(name);
        setColor(color);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void show() {
        // sout 回车   生成打印的语句
        System.out.println("名字：" + getName() + ", 颜色：" + getColor());
    }
}

```

```java

public class Dog extends Animal {
    private int tooth;

    public Dog() {
        super(); // 表示调用父类的无参构造方法  自动保存
    }
    public Dog(String name, String color, int tooth) {
        super(name, color); // 表示调用父类的有参构造方法
        setTooth(tooth);
    }

    public int getTooth() {
        return tooth;
    }
    public void setTooth(int tooth) {
        if (tooth > 0) {
            this.tooth = tooth;
        } else {
            System.out.println("牙齿数量不合理哦！！！");
        }
    }

    @Override
    public void show() {
        super.show();
        System.out.println("牙齿数量是：" + getTooth());
    }
}

```

```java

public class DogTest {

    public static void main(String[] args) {
        // 1.使用无参方式构造Dog类型的对象并打印特征
        Dog d1 = new Dog();
        d1.show(); // null null 0

        // 2.使用有参方式构造Dog类型的对象并打印特征
        Dog d2 = new Dog("旺财", "白色", 10);
        d2.show(); // 旺财 白色  10
    }
}

```



- 构造块与静态代码块
  -  先执行父类的静态代码块，再执行子类的静态代码块。  
  - 执行父类的构造块，执行父类的构造方法体。  
  - 执行子类的构造块，执行子类的构造方法体。 

### 访问控制

- 常见的访问控制符

  - | 修饰符    | 本类     | 同一个包中的类 | 子类     | 其他类   |
    | --------- | -------- | -------------- | -------- | -------- |
    | public    | 可以访问 | 可以访问       | 可以访问 | 可以访问 |
    | protected | 可以访问 | 可以访问       | 可以访问 | 不能访问 |
    | 默认      | 可以访问 | 可以访问       | 不能访问 | 不能访问 |
    | private   | 可以访问 | 不能访问       | 不能访问 | 不能访问 |

- 注意事项

  -  public修饰的成员可以在任意位置使用。  
  - private修饰的成员只能在本类内部使用。  
  - 通常情况下，成员方法都使用public关键字修饰，成员变量都使用private 关键字修饰。 

- package语句由来

  -  定义类时需要指定类的名称，但如果仅仅将类名作为类的唯一标识，则 不可避免的出现命名冲突的问题。这会给组件复用以及团队间的合作造 成很大的麻烦！  
  - 在Java语言中，用包（package）的概念来解决命名冲突的问题。 

- 包的定义

  -  在定义一个类时，除了定义类的名称一般还要指定一个包名，格式如下： 
    - package 包名; 
    - package 包名1.包名2.包名3...包名n;  
  - 为了实现项目管理、解决命名冲突以及权限控制的效果。 

- 定义包的规范

  -  如果各个公司或开发组织的程序员都随心所欲的命名包名的话，仍然不 能从根本上解决命名冲突的问题。因此，在指定包名的时候应该按照一 定的规范。 
  - org.apache.commons.lang.StringUtil 
    - 其中StringUtils是类名而org.apache.commons.lang是多层包名，其含义 如下：org.apache表示公司或组织的信息（是这个公司（或组织）域名的 反写）；common 表示项目的名称信息；lang 表示模块的名称信息。 

- 包的导入

  -  使用import关键字导入包。  
  - 使用import关键字导入静态成员，从Java5.0开始支持。 

### final 关键字

- 概念
  
  -  final本意为"最终的、不可改变的"，可以修饰类、成员方法以及成员变量。 
- 使用方式
  -  final关键字修饰类体现在该类不能被继承。
    
    - 主要用于防止滥用继承，如：java.lang.String类等。
  -  final关键字修饰成员方法体现在该方法不能被重写但可以被继承。 
    
    - 主要用于防止不经意间造成重写，如：java.text.Dateformat类中format方法等。
  - final关键字修饰成员变量体现在该变量必须初始化且不能改变。 
    
    - 主要用于防止不经意间造成改变，如：java.lang.Thread类中MAX_PRIORITY等 
    
    - ```java
      public class FinalMemberTest {
      //    private final int cnt = 1; // 显式初始化
          private final int cnt;
      
          /*{
              cnt = 2;  // 构造块中进行初始化
          }*/
      
          public FinalMemberTest() {
              cnt = 3; // 构造方法体中进行初始化
          }
      
          public static void main(String[] args) {
      
              // 声明FinalMemberTest类型的引用指向该类的对象
              FinalMemberTest fmt = new FinalMemberTest();
              // 打印成员变量的数值
              System.out.println("fmt.cnt = " + fmt.cnt); // 0  1  2  3
          }
      }
      
      ```
    
  
- 常量
  - 概念
    -  在开发中很少单独使用final关键字来修饰成员变量，通常使用 public static final关键字共同修饰成员变量来表达常量的含义，
    -  常量的命 名规范要求是所有字母都要大写，不同的单词之间采用下划线连。 
    -  public static final double PI = 3.14; 