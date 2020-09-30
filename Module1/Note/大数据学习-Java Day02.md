# 大数据学习-Java Day02

## 运算符

### 算术运算符

- 基本属性
  -  \+ 表示加法运算符 
  - -表示减法运算符 
  - *表示乘法运算符 
  -  / 表示除法运算符 
  -  % 表示取模/取余运算符 

```java
/*
    编程实现算术运算符的使用
 */
public class ArithmeticTest {
	
	public static void main(String[] args) {
		
		// 1.声明两个int类型的变量并初始化
		//int ia = 6, ib = 2;       // 表示声明两个int类型的变量ia和ib，不推荐使用
		int ia = 6;                 // 推荐该方式，提高了代码的可读性
		int ib = 2;
		System.out.println("ia = " + ia); // ia = 6
		System.out.println("ib = " + ib); // ib = 2
		
		System.out.println("----------------------------------------");
		// 2.使用上述变量实现算术运算符的使用   +  -  *  /  %
		// 表示声明变量ic来记录ia与ib的和
		int ic = ia + ib;
		System.out.println("ic = " + ic); // ic = 8
		// 其中ia+ib这个整体叫做表达式  ia、ib叫做操作数   +叫做操作符/运算符
		System.out.println(ia + ib);  // 8
		System.out.println(ia - ib);  // 4
		System.out.println(ia * ib);  // 12
		System.out.println(ia / ib);  // 3
		System.out.println(ia % ib);  // 0
		
		System.out.println("----------------------------------------");
		// 3.注意事项
		// 3.1 当两个整数相除时结果只保留整数部分，丢弃小数部分
		System.out.println(5 / 2); // 2
		
		System.out.println("----------------------------------------");
		// 3.2 若希望保留小数部分该如何处理？
		// 处理方式一：使用强制类型转换将其中一个操作数转换为double类型再运算即可
		System.out.println((double)5 / 2);   // 2.5
		System.out.println(5 / (double)2);   // 2.5
		System.out.println((double)5 / (double)2); // 2.5
		System.out.println((double)(5 / 2)); // 2.0
		// 处理方式二：让其中一个操作数乘以1.0即可（推荐）
		System.out.println(5*1.0 / 2); // 2.5
		System.out.println(5.0 / 2);   // 2.5   ia.0 错误的表示
		
		System.out.println("----------------------------------------");
		// 3.3 0不能作除数
		//System.out.println(5 / 0); // 编译ok，运行发生java.lang.ArithmeticException(算术异常 记住): / by zero
		System.out.println(5 / 0.0); // Infinity 无穷
 		System.out.println(0 / 0.0); // NaN Not a Number 
	}
}
```

### 字符串连接运算符

- 可以实现字符串的连接。同时可以实现字符串与其他数据类型“相连” 。

##### 案例 提示用户输入正整数类型的秒数，拆分秒数后输出x小时x分x秒。  如：输入7199，输出1小时59分59秒。 

```java
import java.util.Scanner; 
 
public class ArithmeticTimeTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个正整数的秒数并使用变量记录
		System.out.println("请输入一个正整数的秒数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.将正整数的秒数拆分为时分秒后并使用变量记录
		// 3666秒 => 1小时1分钟6秒钟
		// 3666 / 3600 = 1 小时     3666 % 3600 = 66 / 60 = 1 分钟     3666 % 60 = 6 秒钟 
		int hour = num / 3600;      // 拆分小时数
		int min = num % 3600 / 60;  // 拆分分钟数
		int sec = num % 60;         // 拆分秒数
		
		// 3.打印最终的拆分结果
		System.out.println(num + "秒转换为" + hour + "小时" + min + "分钟" + sec + "秒钟");
		
		System.out.println("---------------------------------------------------------------------");
		// 4.+既可以作为字符串连接符，又可以作为加法运算符
		// 只要+两边的操作数中有一个操作数是字符串类型，则该+就被当做字符串连接符处理，否则当做加法运算符处理
		System.out.println(hour + min + sec);       // 8
		System.out.println(hour + min + sec + "");  // 8
		System.out.println(hour + min + "" + sec);  // 26
		System.out.println(hour + "" + min + sec);  // 116
		System.out.println("" + hour + min + sec);  // 116
		System.out.println("" + (hour + min + sec));// 8
	}
}
```

### 关系/比较运算符

- 基本属性
  -  \> 表示是否大于运算符 >= 表示是否大于等于运算符 
  - < 表示是否小于运算符 <= 表示是否小于等于运算符 
  - == 表示是否等于运算符 != 表示是否不等于运算符 
  - 所有以关系运算符作为最终运算的表达式结果一定是boolean类型。 

```java
/*
    编程实现关系运算符的使用
 */
public class RelationTest {
	
	public static void main(String[] args) {
		
		// 1.声明两个int类型的变量并初始化
		int ia = 5;
		int ib = 2;
		
		// 2.使用变量实现关系运算符的使用并打印结果
		boolean b1 = ia > ib;
		System.out.println("b1 = " + b1); // b1 = true
		System.out.println(ia > ib);   // 是否大于       true
		System.out.println(ia >= ib);  // 是否大于等于   大于或者等于  true
		System.out.println(ia < ib);   // 是否小于       false
		System.out.println(ia <= ib);  // 是否小于等于   false
		System.out.println(ia == ib);  // 是否等于       false
		System.out.println(ia != ib);  // 是否不等于     true
	}
}
```

##### 案例  提示用户输入一个整数，使用关系运算符判断该整数是否为负数，若是 则打印true，若不是则打印false。 

```java
import java.util.Scanner; 
 
public class RelationJudgeTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个整数并使用变量记录
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.判断该整数是否为负数并打印
		boolean b1 = num < 0;
		System.out.println("b1 = " + b1);
		System.out.println(num < 0);
	}
}
```

### 自增减运算符

- 基本属性
  -  ++ 表示自增运算符，用于使得当前变量自身的数值加1的效果 
  - -- 表示自减运算符，用于使得当前变量自身的数值减1的效果 
  - **只能用于变量，常数不可以** 
  - **自增减运算符在前面时，是先赋值后自身加减，在后面时是先自身加减，而后赋值**
  - 自增减运算符不会改变数值的类型，若是超出会进位

```java
/*
    编程实现自增减运算符的使用
 */
public class SelfTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个int类型的变量并初始化
		int ia = 10;
		// 2.打印变量的数值
		System.out.println("ia = " + ia); // ia = 10
		
		System.out.println("---------------------------------------------");
		// 3.实现自增减运算符的使用
		// 表示让变量ia自身的数值加1，并覆盖该变量原来的数值   
		ia++;   // ia = ia + 1;
		System.out.println("ia = " + ia); // ia = 11
		
		// 表示让变量ia自身的数值加1，并覆盖该变量原来的数值  
		++ia;
		System.out.println("ia = " + ia); // ia = 12
		
		// 表示让变量ia自身的数值减1，并覆盖该变量原来的数值
		--ia;
		System.out.println("ia = " + ia); // ia = 11
		
		ia--;
		System.out.println("ia = " + ia); // ia = 10
		
		System.out.println("---------------------------------------------");
		// 4.简单的变换
		// 其中ia++这个整体叫做表达式   其中ia叫做操作数/变量       也就是ia++和ia表示不同的含义，因此所占的内存空间应该不同
		// 下面的代码是在打印表达式的结果
		// 后++表示先让变量ia的数值作为整个表达式的最终结果，然后再让ia变量自身的数值加1
		System.out.println(ia++);         // 10
		System.out.println("ia = " + ia); // 11
		// 前++表示先让变量自身的数值加1，然后再让变量的数值作为整个表达式的结果
		System.out.println(++ia);         // 12
		System.out.println("ia = " + ia); // 12
		
		System.out.println("---------------------------------------------");
		// 5.笔试考点
		int ib = ia++;
		System.out.println("ib = " + ib); // 12
		System.out.println("ia = " + ia); // 13
		int ic = ++ia;
		System.out.println("ic = " + ic); // 14
		System.out.println("ia = " + ia); // 14
		
		//                  14  + 16
		System.out.println(ia++ + ++ia);  // 30
		System.out.println("ia = " + ia); // 16
		
	}
}
```

### 逻辑运算符

-  基本属性
  - && 表示逻辑与运算符，相当于"并且"，同真为真，一假为假。 
  - || 表示逻辑或运算符，相当于"或者"，一真为真，同假为假。
  - ! 表示逻辑非运算符，相当于"取反"，真为假，假为真。 
  - 逻辑运算符的操作数均为boolean表达式。 
- 特性
  -  对于逻辑与运算符来说，若第一个表达式为假则结果为假，此时跳过第 二个表达式；  
  -  对于逻辑或运算符来说，若第一个表达式为真则结果为真，此时跳过第 二个表达式； 

```java
/*
    编程实现逻辑运算符的使用
 */
public class LogicTest {
	
	public static void main(String[] args) {
		
		// 1.声明两个boolean类型的变量并初始化
		boolean b1 = true;
		boolean b2 = false;
		// 2.打印变量的数值
		System.out.println("b1 = " + b1); // b1 = true
		System.out.println("b2 = " + b2); // b2 = false
		
		System.out.println("---------------------------------------------");
		// 3.使用上述变量实现逻辑运算符的使用
		boolean b3 = b1 && b2;
		System.out.println("b3 = " + b3); // false
		System.out.println(b1 && b2); // false   并且
		System.out.println(b1 || b2); // true    或者
		System.out.println(!b1);  // false       取反
		System.out.println(!b2);  // true
		
		System.out.println("---------------------------------------------");
		// 4.测试一下短路特性
		int ia = 3;
		int ib = 5;
		// 对于逻辑与运算符来说，若第一个条件为假则整个表达式为假，此时跳过第二个表达式不执行
		boolean b4 = (++ia == 3) && (++ib == 5);
		System.out.println("b4 = " + b4); // false
		System.out.println("ia = " + ia); // 4
		System.out.println("ib = " + ib); // 5
		
		// 对于逻辑或运算符来说，若第一个条件为真则整个表达式为真，此时跳过第二个表达式不执行
		boolean b5 = (++ia == 5) || (++ib == 5);
		System.out.println("b5 = " + b5); // true
		System.out.println("ia = " + ia); // 5
		System.out.println("ib = " + ib); // 5
	}
}
```

### 三目运算符

- 基本属性
  -  条件表达式? 表达式1: 表达式2 
  -  判断条件表达式是否成立，若成立则执行表达式1，否则执行表达式2 。 

```java
/*
    编程实现三目运算符的使用
 */
import java.util.Scanner; 
 
public class ThreeEyeTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入两个整数并使用变量记录
		System.out.println("请输入两个整数：");
		Scanner sc = new Scanner(System.in);
		int ia = sc.nextInt();
		int ib = sc.nextInt();
		
		// 2.使用三目运算符找到最大值并打印
		int max = ia > ib? ia: ib;
		System.out.println("最大值是：" + max);
		System.out.println("最大值是：" + (ia > ib? ia: ib));
	}
}
```



##### 案例  提示用户输入一个正整数，使用逻辑运算符判断该正整数是否为三位数， 若是则打印true，否则打印false。 

```java

import java.util.Scanner; 
 
public class LogicJudgeTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个正整数并使用变量记录
		System.out.println("请输入一个正整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.使用逻辑运算符判断是否为三位数并打印    >= 100   <= 999   &&
		//System.out.println(100 <= num <= 999); // 错误: 二元运算符 '<=' 的操作数类型错误
		// 逻辑运算符主要用于连接多个关系运算符作为最终运算的表达式，用于实现多条件的连接
		System.out.println(100 <= num && num <= 999);
		// 使用三目运算符来判断是否为三位数
		System.out.println(num + ((100 <= num && num <= 999)? "是三位数": "不是三位数"));
	}
}
 
```

### 赋值运算符

- 基本属性
  -  = 表示赋值运算符，用于将=右边的数据赋值给=左边的变量，覆盖变量 原来的数值。  
  -  赋值表达式本身也有值，其本身之值即为所赋之值。 
  -  +=、 -= 、 *= 、 /=、 ... 

```java
/*
    赋值运算符的使用
 */
public class AssignTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个int类型的变量并初始化
		int ia = 3;
		// 2.打印变量的数值
		System.out.println("ia = " + ia); // ia = 3
		
		System.out.println("-----------------------------------");
		// 3.简单赋值运算符的使用
		// 表示将数据5赋值给变量ia并且覆盖变量ia原来的数值
		ia = 5;
		System.out.println("ia = " + ia); // ia = 5
		// 下面的代码是在打印表达式的结果
		System.out.println( ia = 5 ); // 5
		System.out.println("ia = " + ia); // ia = 5
		int ib = ia = 6;
		System.out.println("ia = " + ia); // ia = 6
		System.out.println("ib = " + ib); // ib = 6
		int ic;
		ic = ib = ia = 8;
		System.out.println("ia = " + ia); // ia = 8
		System.out.println("ib = " + ib); // ib = 8
		System.out.println("ic = " + ic); // ic = 8
		
		System.out.println("-----------------------------------");
		// 4.复合赋值运算符的使用
		//ia = ia + 2;  目前推荐使用该方式
		ia += 2;        // 简化写法，从结果上来看是等价的
		System.out.println("ia = " + ia); // ia = 10
		
		System.out.println("-----------------------------------");
		// 5.笔试考点1
		byte b1 = 10;
		System.out.println("b1 = " + b1); // b1 = 10
		//b1 = b1 + 2; // 错误: 不兼容的类型: 从int转换到byte可能会有损失         byte + int 相加结果还是int类型
		//b1 = b1 + (byte)2; // 错误: 不兼容的类型: 从int转换到byte可能会有损失   byte + byte 相加结果还是int类型  编译器优化
		//b1 = (byte)(b1 + 2); // 强制类型转换，将int类型转换为byte
		b1 += 2; // 真正等价于b1 = (byte)(b1 + 2);
		System.out.println("b1 = " + b1); // b1 = 12
		
		System.out.println("-----------------------------------");
		// 6.笔试考点2
		//ia == 2; - 表示判断变量ia的数值是否等于2
		//2 == ia; - 表示判断2是否等于变量ia的数值，从结果上来说等价，推荐该方式
		//ia = 2;  - 表示将2赋值给变量ia，覆盖变量ia原来的数值
		//2 = ia;  //- 编译报错  错误: 意外的类型
	}
}
```

### 移位运算符

- 基本属性
  - << 左移运算符，用于将数据的二进制位向左移动，右边使用0补充 
  - \>> 右移运算符，用于将数据的二进制位向右移动，左边使用符号位补充 
  - \>>>表示逻辑右移运算符，用于将数据的二进制位向右移动，左边使用0 补充。 

```java
/*
    编程实现移位运算符的使用
 */
public class MoveBitTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个byte类型的变量并初始化
		byte b1 = 13;
		// 2.打印变量的数值
		System.out.println("b1 = " + b1); // b1 = 13
		
		System.out.println("---------------------------------------------------");
		// 3.移位运算符的使用
		// 13的二进制是：... 0000 1101  => 左移1位的结果是：... 0001 1010 => 换算为十进制整数是：26
		//byte b2 = b1 << 1; // 错误: 不兼容的类型: 从int转换到byte可能会有损失   自动提升为int类型，也就是32位二进制
		byte b2 = (byte)(b1 << 1); 
		System.out.println("b2 = " + b2); // 26
		System.out.println(b1 << 1); // 26    左移1位相当于当前整数的数值*2
		System.out.println(b1 << 2); // 52    左移2位相当于当前整数的数值*4
		
		System.out.println("---------------------------------------------------");
		// 13的二进制是：... 0000 1101 => 右移1位的结果是：... 0000 0110 => 换算为十进制整数是：6
		System.out.println(b1 >> 1); // 6     右移1位相当于当前整数的数值/2
		System.out.println(b1 >> 2); // 3     右移2位相当于当前整数的数值/4
		
		System.out.println("---------------------------------------------------");
		// 逻辑右移   对于非负数来说，逻辑右移和右移的效果一致
		System.out.println(b1 >>> 2); // 3  
	}
}
```

### 位运算符

- 基本属性
  -  & 表示按位与运算符，按照二进制位进行与运算，同1为1，一0为0. 
  - | 表示按位或运算符，按照二进制位进行或运算，一1为1，同0为0. 
  - ~ 表示按位取反运算符，按照二进制位进行取反，1为0，0为1. 
  - ^ 表示按位异或运算符，按照二进制位进行异或运算，同为0，不同为1. 

```java
/*
    编程实现位运算符的使用
 */
public class BitTest {
	
	public static void main(String[] args) {
		
		// 1.声明两个byte类型的变量并初始化
		byte b1 = 11;
		byte b2 = 13;
		// 2.打印变量的数值
		System.out.println("b1 = " + b1); // b1 = 11
		System.out.println("b2 = " + b2); // b2 = 13
		
		System.out.println("---------------------------------------------------");
		// 3.实现位运算符的使用
		// b1的二进制为： 0000 1011          
		// b2的二进制为： 0000 1101
		System.out.println( b1 & b2);  // 按位与：同1为1，一0为0      按位与后的二进制为：0000 1001  => 转为十进制是：9
		System.out.println( b1 | b2);  // 按位或：一1为1，同0为0      按位或后的二进制为：0000 1111  => 转为十进制是：15
		System.out.println( b1 ^ b2);  // 按位异或：相同为0，不同为1  按位异或的二进制为：0000 0110  => 转为十进制是：6
		System.out.println( ~ b1);     // 按位取反：1为0,0为1         按位取反的二进制为：1111 0100 
		// 二进制1111 0100转为十进制 => 先减1: 1111 0011 => 按位取反：0000 1100 => 转为十进制：12  => 添加负号：-12
	}
}
```

### 运算符的优先级

- （）的优先级极高
- = 的优先级极低
- 若无法确认优先级，则使用（）来确保即可