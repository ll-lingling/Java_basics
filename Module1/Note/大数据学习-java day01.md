# 大数据学习-Java Day01
  ## 变量与数据类型
  ### 变量

#### 变量的基本概念

-  当需要在程序中记录单个数据内容时，则声明一个变量即可，而声明变 量的本质就是在内存中申请一个**存储单元**，由于该存储单元中的数据内 容可以发生改变，因此得名为"变量" 。  
-  由于存放的数据内容大小不一样，导致所需存储单元的大小不一样，在 Java语言中使用数据类型加以描述，为了便于下次访问还需要给该变量指 定一个名字，用于记录该变量对应的存储单元。 

#### 变量的声明方式

- 数据类型 变量名 = 初始值；
- 其中初始值可以忽略，但不可省略

#### 变量的注意事项

- Java是强类型语言，变量在使用前必须声明其数据类型。
- 变量在使用之前必须初始化
- 变量不能重复声明

```java
/*
    编程实现变量的声明和使用
 */
public class VarTest {
	
	public static void main(String[] args) {
	
		// 1.声明一个变量并初始化   数据类型 变量名 = 初始值;
        int age = 18;
		// 2.打印变量的数值   + 字符串连接符  用于将两边的内容拼接/连接起来结果还是字符串
		System.out.println("age = " + age); // age = 18
		
		System.out.println("-----------------------------------------------------");
		// 3.使用变量的注意事项
		// 3.1 使用变量之前需要声明
		// System.out.println("name = " + name); // 错误: 找不到符号 
		// 3.2 使用变量之前需要初始化
		//String name;
		//System.out.println("name = " + name); // 错误: 可能尚未初始化变量name
		String name = "奇点";
		System.out.println("name = " + name); // name = 奇点
		// 3.3 变量不能重复声明
		//int age = 17; // 错误: 已在方法 main(String[])中定义/声明了变量 age
		int aGe = 17;
		int fjakjf3fjdlakjfa7987jfkdajlkf2427897fdjafjalkl89809fdjafjlj = 10;
		int 年龄 = 16;
	}
} 
```

#### 标识符命名规则

-  由数字、字母、下划线以及$等组成，其中数字不能开头 （必须遵守）

-  不能使用语言的关键字，所谓关键字就是Java语言用于表示特殊含义 的单词。  

  - | 访问控制             | private  | protected  | public   |              |            |           |        |
    | -------------------- | -------- | ---------- | -------- | ------------ | ---------- | --------- | :----: |
    | 类，方法和变量修饰符 | abstract | class      | extends  | final        | implements | interface | native |
    |                      | new      | static     | strictfp | synchronized | transient  | volatile  |        |
    | 程序控制             | break    | continue   | return   | do           | while      | if        |  else  |
    |                      | for      | instanceof | switch   | case         | default    |           |        |
    | 错误处理             | try      | catch      | throw    | throws       | finally    |           |        |
    | 包相关               | import   | package    |          |              |            |           |        |
    | 基本类型             | boolean  | byte       | char     | double       | float      | int       |  long  |
    |                      | short    | null       | true     | false        |            |           |        |
    | 变量引用             | super    | this       | void     |              |            |           |        |
    | 保留字               | goto     | const      |          |              |            |           |        |

-  区分大小写，长度没有限制但不宜过长。 

-   尽量做到见名知意，支持中文但不推荐使用。  

- 标识符可以给类/变量/属性/方法/包 起名字 

#### 案例 实现变量的输入输出

```Java
/*
   编程实现变量的输入输出
 */

// 导入java目录中util目录的Scanner类
import java.util.Scanner; 
 
public class VarIOTest {
	
	public static void main(String[] args) {
		
		// 1.声明两个变量用于记录姓名和年龄信息
		//String name;
		//int age;
		
		// 2.提示用户从键盘输入姓名和年龄信息并放入到变量中   变量随使用随声明
		System.out.println("请输入您的姓名和年龄信息：");
		// 创建一个扫描器来扫描键盘输入的内容  System.in代表键盘输入
		Scanner sc = new Scanner(System.in);
		// 通过扫描器读取一个字符串数据放入变量name中
		String name = sc.next();
		// 通过扫描器读取一个整数数据放入变量age中
		int age = sc.nextInt();
		
		// 3.打印变量的数值     尽可能减少重复的代码
		//System.out.println("name = " + name);
		//System.out.println("age = " + age);
		System.out.println("name = " + name + ", age = " + age);
	}
} 
```



### 数据类型

#### 数据类型的分类

- 在Java中数据类型基本分为两类

  - 基本数据类型
    - byte 、short、int、long、float、double、boolean、char 

  - 引用数据类型
    -  数组、类、接口、枚举、标注 

#### 常用进制

-   在日常生活中采用十进制进行数据的描述，逢十进一，十进制权重是： 10^0、10^1、10^2、... 
- 在计算机的底层采用0和1组成的二进制序列进行数据的描述，逢二进一， 二进制的权重是2^0、2^1、2^2、... 
-  二进制中的最高位（最左边）用于代表符号位，若该位是0则表示非负数， 若该位是1则表示负数。 
-  八进制和十六进制其实都是二进制的简写。 

#### 进制之间转换

-  正十进制转换为二进制的方式 
  - 除2取余法，使用十进制整数不断地除以2取出余数，直到商为0时将 余数逆序排序。 
  - 拆分法，将十进制整数拆分为若干个二进制权重的和，有该权重下面 写1，否则写0。 

-  正二进制转换为十进制的方式 
  -  加权法，使用二进制中的每个数字乘以当前位的权重再累加起来。 
-  负十进制转换为二进制的方式 
  -  先将十进制的绝对值转换为二进制，然后进行按位取反再加1。 
  -  **负数的需要补码：按位取反，再加1 。** 
-  负二进制转换为十进制的方式  
  -  先减1再按位取反，合并为十进制整数后添加负号。 

#### 单个字节表示的整数范围

-  **在计算机中单个字节表示八位二进制位，其中最高位(最左边)代表符号位， 使用0代表非负数，使用1代表负数，具体表示的整数范围如下：**
  - **非负数表示范围：0000 0000 ~ 0111 1111 => 0 ~ 127 => 0 ~ 2^7-1**
  - **负数表示范围：1000 0000 ~ 1111 1111 => -128 ~ -1 => -2^7 ~ -2^0**
  - **单个字节表示的整数范围是：-2^7 ~ 2^7-1，也就是-128 ~ 127.** 

- 整数类型

  -  Java语言中描述整数数据的类型有：byte、short、int、long，荐int类型 

    - 其中byte类型在内存空间中占1个字节，表示范围是：-2^7 ~ 2^7-1. 

    - 其中short类型在内存空间中占2个字节，表示范围是：-2^15 ~ 2^15-1. 

    - 其中int类型在内存空间中占4个字节，表示范围是：-2^31 ~ 2^31-1. 

    - 其中long类型在内存空间中占8个字节，表示范围是：-2^63 ~ 2^63-1. 

    - 在Java程序中直接写出的整数数据叫做直接量/字面值/常量，默认为int类 型。若希望表达更大的直接量，则在直接量的后面加上l或者L，推荐使用L

    - ```java
      /*
          编程实现整数类型的使用
       */
      public class IntTest {
      	
      	public static void main(String[] args) {
      		
      		// 1.声明一个byte类型的变量并初始化
      		byte b1 = 25;
      		//byte b1 = 250;     // 错误: 不兼容的类型: 从int转换到byte可能会有损失  250这样直接写出的整数数据叫做直接量/常量/字面值 默认为int类型 
      		// 2.打印变量的数值
      		System.out.println("b1 = " + b1); // b1 = 25
      		
      		System.out.println("---------------------------------------------");
      		// 3.声明一个short类型的变量并初始化
      		short s1 = 250;
      		//short s1 = 250250;  // 错误：不兼容的类型：从int转换到short可能会有损失
      		System.out.println("s1 = " + s1); // s1 = 250
      		
      		System.out.println("---------------------------------------------");
      		// 4.声明一个int类型的变量并初始化
      		int i1 = 250250;
      		//int i1 = 2502505006; // 错误: 整数太大   默认为int类型，这个数据自身已经出错，无法表示
      		//int i1 = 2502505006L;  // 错误：不兼容的类型：从long转换到int可能会有损失
      		System.out.println("i1 = " + i1); // i1 = 250250
      		
      		System.out.println("---------------------------------------------");
      		// 5.声明一个long类型的变量并初始化，若描述比long类型还大的数据则使用java.math.BigInteger类型
      		long g1 = 2502505006L;
      		System.out.println("g1 = " + g1); // g1 = 2502505006
      		
      		System.out.println("---------------------------------------------");
      		// 6.请问下面的代码是否有错误？若有请指出并说明原因
      		//int i2 = 25;
      		//byte b2 = i2;  // 错误: 不兼容的类型: 从int转换到byte可能会有损失
      		//System.out.println("b2 = " + b2);
      		
      	}
      }
      ```

      

- 浮点类型

  -  Java语言中用于描述小数数据的类型：float 和 double，推荐double类型 

    - 其中float类型在内存空间占4个字节，叫做单精度浮点数，可以表示7位 有效数字，范围：-3.403E38~3.403E38。

    - 其中double类型在内存空间占8个字节，叫做双精度浮点数，可以表示15 位有效数字，范围：-1.798E308~1.798E308。

    - Java程序中直接写出的小数数据叫做直接量，默认为double类型，若希望 表达float类型的直接量，则需要在直接量的后面加上f或者F 

    - ```java
          编程实现浮点类型的使用
       */
      public class DoubleTest {
      	
      	public static void main(String[] args) {
      		
      		// 1.声明一个float类型的变量并初始化
      		//float f1 = 3.1415926;   // 错误: 不兼容的类型: 从double转换到float可能会有损失   小数数据叫做直接量，默认为double类型
      		float f1 = 3.1415926f;
      		// 2.打印变量的数值
      		System.out.println("f1 = " + f1); // f1 = 3.1415925     一般是7位有效数字
      		
      		System.out.println("---------------------------------------------------------");
      		// 3.声明一个double类型的变量并初始化
      		double d1 = 3.1415926;
      		System.out.println("d1 = " + d1); // d1 = 3.1415926     一般是15位有效数字
      		
      		System.out.println("---------------------------------------------------------");
      		// 4.笔试考点
      		System.out.println(0.1 + 0.2);  // 0.30000000000000004  运算时可能会有误差，若希望实现精确运算则借助java.math.BigDecimal类型 
      	}
      }
      ```

      

-  布尔类型 

  -  Java语言中用于描述真假信息类型有：boolean，数值只有：true 和 false。 

    -  布尔类型在内存空间中所占大小没有明确的规定，可以认为是1个字节。 

      ```java
      /*
          编程实现布尔类型的使用
       */
      public class BooleanTest {
      	
      	public static void main(String[] args) {
      		
      		// 1.声明一个boolean类型的变量并初始化
      		boolean b1 = true;
      		// 2.打印变量的数值
      		System.out.println("b1 = " + b1); // b1 = true
      		
      		System.out.println("-------------------------------------------");
      		// 3.修改变量b1的数值   = 赋值运算符，用于将=右边的数据赋值给=左边的变量，覆盖变量中原来的数值
      		b1 = false;
      		System.out.println("b1 = " + b1); // b1 = false
      		
      		System.out.println("-------------------------------------------");
      		//b1 = 1; // 错误: 不兼容的类型: int无法转换为boolean
      	}
      }
      ```

      

- 字符类型

  -  Java语言中用于描述单个字符的数据类型：char类型。如：'a'、 '中'等。 

    -  其中char类型在内存空间中占2个字节并且没有符号位，表示的范围是： 0 ~ 65535，由于现实生活中很少有数据能够被单个字符描述，因此以后 的开发中更多的使用由多个字符串起来组成的字符串，使用String类型加 以描述，如：“hello”、 “奇点”等。 

  - 计算机的底层只识别0和1组成的二进制序列，对于字符'a'这样的图案来 说不满足该规则，因此该数据无法直接在计算机中存储，但现实生活中 存在这样的图案数据需要计算机存储，为了使得该数据能够存储起来就 可以给该数据指定一个编号，然后将编号存储起来即可，该编号就叫做 ASCII。 

    - 要求掌握的ASCII有：'0' - 48 'A' - 65 'a' - 97 空格 - 32 换行符 - 10 

  - Java字符类型采用Unicode字符集编码。Unicode是世界通用的定长字符 集，所有的字符都是16位。 

    -  要求掌握的转义字符有：\" - " \' - ' \\ - \ \t - 制表符 \n - 换行符 

  - ```java
    /*
       编程实现字符类型的使用         
     */
    public class CharTest {
    	
    	public static void main(String[] args) {
    		
    		// 1.声明一个char类型的变量并初始化
    		char c1 = 'a';
    		// 2.打印变量的数值
    		System.out.println("c1 = " + c1); // c1 = a   
    		System.out.println("对应的编号是：" + (int)c1); // 表示将char类型的c1强制转换为int类型并打印   97 
    		
    		System.out.println("-------------------------------------------------------------------------");
    		// 2.声明一个char类型的变量并初始化
    		char c2 = 98;
    		System.out.println("c2 = " + c2); // c2 = b   
    		System.out.println("对应的编号是：" + (int)c2); // 98
    		
    		System.out.println("-------------------------------------------------------------------------");
    		// 3.使用Unicode字符集来表示一下我的名字   奇点  对应的编号是： \u5947\u70b9
    		char c3 = '\u5947';
    		char c4 = '\u70b9';
    		System.out.println("最终的结果是：" + c3 + c4); // 奇点
    		
    		System.out.println("-------------------------------------------------------------------------");
    		// 4.特殊字符的使用   双引号本身有2个含义：a.字符串的开头和结尾标志    b.双引号自身    \ 转义就是转换原有的含义
    		System.out.println("我想过过\"过过过过的生活！");   //  \"  - "
    		System.out.println("我想过过\'过过过过的生活！");
    		System.out.println("我想过过\\过过过过的生活！");
    		System.out.println("我想过过\t过过过过的生活！");
    		System.out.println("我想过过\n过过过过的生活！");
    	}
    }
    ```

    

#### 基本数据类型的转换

-  Java语言中基本数据类型之间的转换方式：自动类型转换和强制类型转换。 

  -  其中自动类型转换主要指从小类型到大类型之间的转换。 

    - byte ==> short/char ==> int ==> long ==> float ==> double

  -  其中强制类型转换主要指从大类型到小类型之间的转换，语法格式如下： 目标类型 变量名 = (目标类型)源类型变量名;   **强转有风险，操作需谨慎！** 

  - ```java
    /*
        编程实现基本数据类型之间转换的使用
     */
    public class TransformTest {
    	
    	public static void main(String[] args) {
    		
    		// 1.声明两个变量并初始化
    		byte b1 = 10;
    		short s1 = 20;
    		// 2.打印变量的数值
    		System.out.println("b1 = " + b1); // b1 = 10
    		System.out.println("s1 = " + s1); // s1 = 20
    		
    		System.out.println("----------------------------------------------");
    		// 3.实现自动类型转换的使用
    		// 表示将变量b1的数值赋值给变量s1，并覆盖变量s1中原来的数值，相当于从byte类型到short类型的转换，小到大  自动转换
    		s1 = b1;
    		System.out.println("b1 = " + b1); // b1 = 10
    		System.out.println("s1 = " + s1); // s1 = 10
    		
    		System.out.println("----------------------------------------------");
    		// 4.实现强制类型转换的使用
    		// 表示将变量s1的数值赋值给变量b1，并覆盖变量b1中原来的数值，相当于从short类型到byte类型的转换，大到小  强制转换
    		//b1 = s1;   // 错误: 不兼容的类型: 从short转换到byte可能会有损失
    		s1 = 128;    // 故意加该行代码      128:0000 0000 1000 0000  => 1000 0000 => 0111 1111 => 1000 0000 => 128 => -128
    		b1 = (byte)s1;
    		System.out.println("b1 = " + b1); // b1 = 10   -128 
    		System.out.println("s1 = " + s1); // s1 = 10   128
    	}
    }
    ```

    

  