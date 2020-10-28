# 大数据学习-Java Day06

## 方法和封装

### 构造方法

- 概念
  -  class 类名 { 类名(形参列表) { 构造方法体; } } 
  -  构造方法名与类名完全相同并且没有返回值类型，连void都不许有。 
- 默认构造方法
  -  当一个类中没有定义任何构造方法时，编译器会自动添加一个无参空构 造构造方法，叫做默认/缺省构造方法，如：Person(){}  
  - 若类中出现了构造方法，则编译器不再提供任何形式的构造方法。
- 作用
  -  使用new关键字创建对象时会自动调用构造方法实现成员变量初始化工作。 

```java
/*
    编程实现构造方法的测试
 */
public class Person {
	
	String name; // 用于描述姓名的成员变量
	int age;     // 用于描述年龄的成员变量
	
	// 自定义构造方法
	// String s = "张飞";
	// int i = 30;
	// String s = "关羽";
	// int i = 35;
	// 就近原则  懒人原则  
	Person(String name, int age) {
		//System.out.println("我就是自定义的构造方法！");
		//name = "张飞";
		//age = 30;
		this.name = name;
		this.age = age;
	}
	// 自定义无参构造方法
	Person() {
	}
	
	// 自定义成员方法实现所有特征的打印  隐含着this关键字,this关键字代表当前正在调用的对象
	// Person this = p1;   this.name = p1.name = 张飞
	// Person this = p2;   this.name = p2.name = 关羽
	void show() {
		// 每当打印成员变量的数值时，让年龄增长一岁
		//this.grow();
		//grow();
		//System.out.println("我是" + this.name + "，今年" + this.age + "岁了！");
		System.out.println("我是" + name + "，今年" + age + "岁了！");
	}
	// 自定义成员方法实现年龄增长一岁的行为
	void grow() {
		age++;
	}
	// 自定义成员方法实现年龄增长参数指定数值的行为
	void grow(int age) {
		this.age += age;
	}
	// 自定义成员方法实现Person类型对象的获取并返回的行为
	//String getName(){}
	Person getPerson() {
		// 返回当前调用对象本身  Person tp = new Person();  return tp;
		return this;
	} 
	
	public static void main(String[] args) {
		
		// 1.声明一个Person类型的引用指向Person类型的对象
		// 当类中没有提供构造方法时，则下面调用默认构造方法，若类中提供构造方法后，则下面调用类中提供的版本
		Person p1 = new Person("张飞", 30);
		// 并打印特征
		p1.show();  // null 0  张飞  30
		
		Person p2 = new Person("关羽", 35);
		p2.show();  // 关羽 35
		
		Person p3 = new Person();
		p3.show(); // null 0
		
		System.out.println("----------------------------------------------------");
		// 2.实现重载方法的调用和测试
		p1.grow();
		p1.show(); // 张飞 31
		p1.grow(3);
		p1.show(); // 张飞 34
		
		System.out.println("----------------------------------------------------");
		// 3.调用成员方法获取对象
		Person p4 = p1.getPerson();
		System.out.println("p1 = " + p1);
		System.out.println("p4 = " + p4);
		
	}
}
```



### 方法重载

- 概念

  -  若方法名称相同，参数列表不同，这样的方法之间构成重载关系 (Overload)。 

- 体现形式

  -  方法重载的主要形式体现在：参数的个数不同、参数的类型不同、参数 的顺序不同，与返回值类型和形参变量名无关，但建议返回值类型最好 相同。 所以重载不能重复写参数类型和数量相同的

  - **判断方法能否构成重载的核心：调用方法时能否加以区分**

  - ```java
    /*
        编程实现方法重载主要形式的测试
     */
    public class OverloadTest {
    	
    	// 自定义成员方法
    	void show() {
    		System.out.println("show()");
    	}
    	void show(int i) { // ok  体现在方法参数的个数不同
    		System.out.println("show(int)");
    	}
    	void show(int i, double d) { // ok  体现在方法参数的个数不同
    		System.out.println("show(int, double)");
    	}
    	void show(int i, int j) { // ok  体现在方法参数的类型不同
    		System.out.println("show(int, int)");
    	}
    	void show(double d, int i) { // ok  体现在方法参数的顺序不同
    		System.out.println("show(double, int)");
    	}
    	/*
    	void show(double a, int b) { // error 与参数变量名无关
    		System.out.println("show(double, int)");
    	}
    	*/
    	/*
    	int show(double d, int i) { // error, 与返回值类型无关
    		System.out.println("show(double, int)");
    	}
    	*/
    	
    	public static void main(String[] args) {
    		
    		// 1.声明OverloadTest类型的引用指向该类型的对象
    		OverloadTest ot = new OverloadTest();
    		// 2.调用show方法
    		ot.show();
    		ot.show(66);
    		ot.show(66, 3.14);
    		ot.show(66, 118);
    		ot.show(3.14, 118);
    		//ot.show(3.14, 66);
    	}
    }
    ```

    

- 意义

  -  方法重载的实际意义在于调用者只需要记住一个方法名就可以调用各种 不同的版本，来实现各种不同的功能。  
  - 如：java.io.PrintStream类中的println方法 

##### 案例   编程实现Point类的定义并向Point类添加构造方法 Point() 默认创建原点对象 Point(int i, int j) 根据参数创建点对象； up() – 实现纵坐标减1的功能。 up(int dy) – 实现纵坐标减去参数指定数值的功能。  测试重载方法的调用规则 

```java
public class Point {
	
	int x; // 用于描述横坐标的成员变量
	int y; // 用于描述纵坐标的成员变量
	
	// 自定义无参构造方法
	Point() {}
    // 自定义有参构造方法
    Point(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	// 自定义成员方法实现特征的打印
	void show() {
		System.out.println("横坐标是：" + x + "，纵坐标是：" + y);
	}
	// 自定义成员方法实现纵坐标减1的行为
	void up() {
		y--;
	}
	// 自定义成员方法实现纵坐标减去参数指定数值的行为
	void up(int y) {
		this.y -= y;
	}
	
	public static void main(String[] args) {
		
		// 1.使用无参方式构造对象并打印特征
		Point p1 = new Point();
		p1.show(); // 0 0
		
		// 2.使用有参方式构造对象并打印特征
		Point p2 = new Point(3, 5);
		p2.show(); // 3 5
		
		System.out.println("------------------------------------");
		// 3.调用重载的成员方法
		p2.up();
		p2.show(); // 3 4
		p2.up(2);
		p2.show(); // 3 2
	}
}
```

 #### this关键字

- 概念
  - 若在构造方法中出现了this关键字，则代表当前正在构造的对象。  
  
  - 若在成员方法中出现了this关键字，则代表当前正在调用的对象。  
  
  - this关键字本质上就是当前类类型的引用 变量
  
  - ```java
    /*
        编程实现this关键字的使用
     */
    public class ThisTest {
    	
    	// 自定义构造方法
    	ThisTest() {
    		// this代表当前正在构造的对象
    		System.out.println("构造方法中：this = " + this);
    	}
    	// 自定义成员方法
    	void show() {
    		// this代表当前正在调用的对象
    		System.out.println("成员方法中：this = " + this);
    	}
    	
    	public static void main(String[] args) {
    		
    		// 1.声明ThisTest类型的引用指向该类型的对象
    		ThisTest tt = new ThisTest();
    		// 2.调用show方法
    		tt.show();
    		System.out.println("main方法中：tt = " + tt);
    		
    		
    		
    	}
    }
    ```
  
    
- 原理
  
  -  在构造方法中和成员方法中访问成员变量时，编译器会加上this.的前缀， 而this.相当于汉语中"我的"，当不同的对象调用同一个方法时，由于调用 方法的对象不同导致this关键字不同，从而this.方式访问的结果也就随之 不同。 
- 使用方式
  -  **当局部变量名与成员变量名相同时，在方法体中会优先使用局部变量(就 近原则)，若希望使用成员变量，则需要在成员变量的前面加上this.的前 缀，明确要求该变量是成员变量** 
  - **this关键字除了可以通过this.的方式调用成员变量和成员方法外，还可以 作为方法的返回值**
  - 在构造方法的第一行可以使用this()的方式来调用本类中的其它构造方法 
- 注意事项
  -  引用类型变量用于存放对象的地址，可以给引用类型赋值为null，表示不 指向任何对象。  
  - 当某个引用类型变量为null时无法对对象实施访问（因为它没有指向任何 对象）。此时，如果通过引用访问成员变量或调用方法，会产生 NullPointerException 异常。 

```java
 /*
    编程实现Boy类的定义
 */
public class Boy {
	
	String name; // 用于描述姓名的成员变量
	
	// 自定义构造方法
	Boy() {
		// 调用本类中的有参构造方法
		//this("无名");
		System.out.println("无参构造方法！");
	}
	Boy(String name) {
		// 调用本类中的无参构造方法
		this();
		System.out.println("=========有参构造方法！");
		this.name = name;
	}
	// 自定义成员方法实现特征的打印
	void show() {
		System.out.println("我的名字是：" + name);
	}
	
	public static void main(String[] args) {
		
		// 1.使用无参方式构造对象并打印特征
		Boy b1 = new Boy();
		b1.show(); // null
		
		System.out.println("-----------------------------------");
		// 2.使用有参方式构造对象并打印特征
		Boy b2 = new Boy("张飞");
		b2.show(); // 张飞
		
		System.out.println("-----------------------------------");
		// 3.引用变量的数值可以为空
		//Boy b3 = null;
		//b3.show(); // 编译ok，运行会发生NullPointerException空指针异常   算术异常、数组下标越界异常
		Boy b3 = b2;
		b3.show(); // 张飞
	}
}
```



### 递归

- 概念
  -  递归本质就是指在方法体的内部直接或间接调用当前方法自身的形式。 
- 注意事项
  -  使用递归必须有递归的规律以及退出条件。 • 
  - 使用递归必须使得问题简单化而不是复杂化。 • 
  -  若递归影响到程序的执行性能，则使用递推取代之。 
     - 递归每次执行时调用自己需要重新申请一块内存空间，空间复杂度高

##### 案例  编程实现参数n的阶乘并返回，所谓阶乘就是从1累乘到n的结果。 

```java

public class JieChengTest {
	
	// 自定义成员方法实现将参数n的阶乘计算出来并返回
	// 1! = 1;     2! = 1*2;   3! = 1*2*3;   ...   n! = 1*2*3*...*n;
	int show(int n) { // int n=5; int n = 4; int n = 3; int n = 2;  int n = 1;
		// 递推的方式 
		/*
		int num = 1;
		for(int i = 1; i <= n; i++) {
			num *= i;
		}
		return num;
		*/
		/*
		    5! = 5 * 4 * 3 * 2 * 1;
			4! = 4 * 3 * 2 * 1;
			3! = 3 * 2 * 1;
			2! = 2 * 1;
			1! = 1;
			
			5! = 5 * 4!;
			4! = 4 * 3!;
			3! = 3 * 2!;
			2! = 2 * 1!;
			1! = 1;
			
			n! = n * (n-1)!;
		  
		*/
		// 递归的方式
		// 当n的数值为1时，则阶乘的结果就是1
		/*
		if(1 == n) {
			return 1;
		}
		*/
		if(1 == n) return 1;
		// 否则阶乘的结果就是 n*(n-1)!
		return n*show(n-1);
		// show(5) => return 5*show(4); => 120
		// show(4) => return 4*show(3); => 24 
		// show(3) => return 3*show(2); => 6
		// show(2) => return 2*show(1); => 2
		// show(1) => return 1;         => 1
	}
	
	public static void main(String[] args) {
		
		// 1.声明JieChengTest类型的引用指向该类型的对象
		JieChengTest jct = new JieChengTest();
		// 2.调用方法进行计算并打印
		int res = jct.show(5);
		System.out.println("最终的计算结果是：" + res); // 120
	}
}
```

##### 案例  编程实现费式数列中第n项的数值并返回。 费式数列： 1 1 2 3 5 8 13 21 …… 

```java

public class Fee {
	
	// 自定义成员方法实现费氏数列中第n项数值的计算并返回，n由参数指定
	// 1 1 2 3 5 8 13  21 ....
	int show(int n) { // int n = 5; int n = 4; int n = 3; int n = 2; int n = 1;
		// 1.使用递归的方式进行计算
		/*
		// 当n=1或者n=2时，结果是1
		if(1 == n || 2 == n) {
			return 1;
		}
		// 否则结果是前两项的和
		return show(n-1) + show(n-2);
		// show(5) => return show(4) + show(3); => 5
		// show(4) => return show(3) + show(2); => 3
		// show(3) => return show(2) + show(1); => 2
		// show(2) => return 1;                 => 1
		// show(1) => return 1;                 => 1
		*/
		// 2.使用递推的方式进行计算
		int ia = 1;
		int ib = 1;
		for(int i = 3; i <= n; i++) {
			int ic = ia + ib;
			ia = ib;
			ib = ic;
		}
		return ib;
	}
}
```

### 封装

- 概念
  -  通常情况下可以在测试类给成员变量赋值一些合法但不合理的数值，无 论是编译阶段还是运行阶段都不会报错或者给出提示，此时与现实生活 不符。  
  - 为了避免上述错误的发生，就需要对成员变量进行密封包装处理，来隐 藏成员变量的细节以及保证成员变量数值的合理性，该机制就叫做封装。 
  
- 实现流程
  -  私有化成员变量，使用private关键字修饰。  
  - 提供公有的get和set方法，并在方法体中进行合理值的判断。  
  - 在构造方法中调用set方法进行合理值的判断 
  
  ```java
  /*
      编程实现Student类的封装  封装类
   */
  public class Student {
  	
  	// 1.私有化成员变量，使用private关键字修饰
  	// private关键字修饰表示私有的含义，也就是该成员变量只能在当前类的内部使用
  	private int id;       // 用于描述学号的成员变量
  	private String name;  // 用于描述姓名的成员变量 
  	
  	// 3.在公有的构造方法中调用set方法进行合理值的判断
  	public Student() {}
  	public Student(int id, String name) {
  		//this.id = id;
  		//this.name = name;
  		setId(id);
  		setName(name);
  	}
  	
  	// 2.提供公有的get和set方法，并在方法体中进行合理值的判断
  	// 使用public关键字修饰表示公有的含义，也就是该方法可以在任意位置使用
  	public int getId() {
  		return id;
  	}
  	public void setId(int id) {
  		if(id > 0) {
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
  	
  	// 自定义成员方法实现特征的打印
  	// 什么修饰符都没有叫做默认的访问权限，级别介于private和public之间
  	public void show() {
  		//System.out.println("我是" + name + "，我的学号是" + id);
  		System.out.println("我是" + getName() + "，我的学号是" + getId());
  	}
  }
  ```
  
  ```java
  /*
      编程实现Student类的测试
   */
  public class StudentTest {
  	
  	public static void main(String[] args) {
  		
  		// 1.声明Student类型的引用指向Student类型的对象
  		Student s1 = new Student();
  		// 2.对成员变量进行赋值并打印
  		//s1.id = -1001;
  		//s1.name = "张飞";
  		s1.setId(-1001);
  		s1.setName("张飞");
  		s1.show(); // 1001 张飞
  		
  		System.out.println("----------------------------------------------------");
  		// 3.使用有参方式构造对象并打印特征
  		Student s2 = new Student(-1001, "张飞");
  		s2.show(); 
  	}
  }
  ```
  
  

##### 案例   提示用户输入班级的学生人数以及每个学生的信息，学生的信息有：学 号、姓名，最后分别打印出来。提示：Student[] arr = new Student[num]; 

```java

import java.util.Scanner; 
 
public class StudentTest2 {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入学生的人数并使用变量记录
		System.out.println("请输入学生的人数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.根据学生的人数准备对应的一维数组
		// int[] arr = new int[3];  - 表示声明一个长度为3元素类型为int类型的一维数组
		// 数组中的每个元素都是int类型，也就是说数组中的每个元素都可以看做是一个int类型的变量，使用整数数据进行初始化 arr[0] = 10;
		// 下面的代码是声明一个长度为num元素类型为Student类型的一维数组
		// 数组中的每个元素都是Student类型，也就是说数组中的每个元素都可以看做Student类型的变量，arr[0] = new Student();
		Student[] arr = new Student[num];
		
		
		// 3.提示用户输入每个学生的信息(学号 姓名)并记录到一维数组中
		for(int i = 0; i < num; i++) {
			System.out.println("请输入第" + (i+1) + "个学生的信息(学号 姓名)：");
			arr[i] = new Student(sc.nextInt(), sc.next());
		}
		
		System.out.println("-----------------------------------------------");
		// 4.打印所有学生信息
		System.out.println("该班级的所有学生信息有：");
		for(int i = 0; i < num; i++) {
			//System.out.println(arr[i]);
			arr[i].show();
		}
	}
}
```

- JavaBean概念
  -  JavaBean是一种Java语言写成的可重用组件，其它Java 类可以通过反射机 制发现和操作这些JavaBean 的属性。 
  -  JavaBean本质上就是符合以下标准的Java类：  
    -  类是公共的 
    -  有一个无参的公共的构造器 
    - 有属性，且有对应的get、set方法