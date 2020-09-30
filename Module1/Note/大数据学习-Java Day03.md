# 大数据学习-Java Day03

## 流程控制语句

### 分支结构

- 概念
  - 当需要进行条件判断，并做出选择时，使用分支结构

#### if 分支结构

- if (条件表达式) { 语句块；}
- 判断条件是否成立
  - 若成立，则执行语句块
  - 若不成立，则跳过
  - ![image-20200929141627997](D:\code\javacode\java-note\png\image-20200929141627997.png)

```java
/*
     编程使用if分支结构模拟网吧上网的过程
 */

import java.util.Scanner; 
 
public class IfTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入年龄信息并使用变量记录
		System.out.println("请输入您的年龄：");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		// 2.使用if分支结构判断是否成年并给出对应的提示
		if(age >= 18) {
			System.out.println("开心的浏览起了网页...");
		}
		
		// 3.打印一句话
		System.out.println("美好的时光总是短暂的！");
	}
}
```

##### 案例  提示用户输入两个整数，使用if分支结构找到最大值并打印出来。 

```java
/*
    编程使用if分支结构查找两个整数中的最大值
 */

import java.util.Scanner; 
 
public class IfMaxTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入两个整数并使用变量记录
		System.out.println("请输入两个整数：");
		Scanner sc = new Scanner(System.in);
		int ia = sc.nextInt();
		int ib = sc.nextInt();
		
		// 2.使用if分支结构找到最大值并打印
		// 方式一：使用两个if分支结构可以找到最大值
		/*
		if(ia >= ib) {
			System.out.println("最大值是：" + ia);
		}
		if(ia < ib) {
			System.out.println("最大值是：" + ib);
		}
		*/
		// 方式二：假设第一个数为最大值并记录  推荐方式  通用性
		int max = ia;
		if(ib > max) {
			max = ib;
		}
		System.out.println("最大值是：" + max);
	}
}
```

#### if else 分支结构

- if (条件表达式) {语句块1；} else {语句块2；}
- 判断条件是否成立
  - 若成立，执行语句块1
  - 若不成立，执行语句块2
  - ![image-20200929143120919](D:\code\javacode\java-note\png\image-20200929143120919.png)

```java
/*
    编程使用if else分支结构来模拟考试成绩查询的过程
 */

import java.util.Scanner; 
 
public class IfElseTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入考试成绩并使用变量记录
		System.out.println("请输入您的考试成绩：");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		// 2.使用if else分支结构判断考试成绩是否及格并给出对应的提示
		if(score >= 60) {
			System.out.println("恭喜您考试通过了！");
		} else {
			System.out.println("下学期来补考吧！");
		}
		
		// 3.打印一句话
		System.out.println("世界上最遥远的距离不是生与死而是你在if我在else，似乎一直相伴却又永远分离！");
	}
}
```

##### 案例  提示用户输入一个整数，使用if else分支结构判断该整数是负数还是非负 数并打印； 使用if else分支结构判断该整数是正数、负数还是零。 

```java
/*
    编程使用if else分支结构判断是否为负数和非负数
 */

import java.util.Scanner; 
 
public class IfElseJudgeTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个整数并使用变量记录
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.使用if else分支结构判断负数和非负数并打印
		if(num < 0) {
			System.out.println(num + "是负数！");
		} else {
			//System.out.println(num + "是非负数！");
			// 针对目前的非负数再次判断是正数还是零
			if(num > 0) {
				System.out.println(num + "是正数!");
			} else {
				System.out.println(num + "是零！");
			}
		}
	}
}
```

####  if else if else分支结构 

-  if(条件表达式1) { 语句块1; } else if(条件表达式2) { 语句块2; } else { 语句块n; } 

-  判断条件表达式1是否成立
  -  若成立，则执行语句块1；
  - 若不成立，则判断条件表达式2是否成立
  - 若成立，则执行语句块2；
  - 若不成立，则执行语句块n；
  - ![image-20200929144626082](D:\code\javacode\java-note\png\image-20200929144626082.png) 

```java
/*
    编程实现if  else if  else分支结构的使用，来模拟购买火车票的过程
 */

import java.util.Scanner; 
 
public class IfElseifElseTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入身份信息并使用变量记录
		System.out.println("请输入您的身份信息：");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// 2.使用if  else if  else分支结构判断身份信息并给出对应的提示
		// 判断"军人"是否等于str，是否与str的数值相等
		if("军人".equals(str)) {
			System.out.println("请免费乘车！");
		} else if("学生".equals(str)) {
			System.out.println("请购买半价票！");
		} else {
			System.out.println("请购买全价票！");
		}
		
		// 3.打印一句话
		System.out.println("坐上了火车去拉萨，去看那美丽的布达拉！");
	}
}
```

##### 案例  根据用户输入的薪水计算个人所得税并打印出来，其中个税起征点为： 5000元，具体规则如下： ![image-20200929144816772](D:\code\javacode\java-note\png\image-20200929144816772.png)

```java

import java.util.Scanner; 
 
public class IfSalaryTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入个人的薪水并使用变量记录
		System.out.println("请输入您的薪水：");
		Scanner sc = new Scanner(System.in);
		// 局部变量：作用范围是从声明开始一直方法体结束
		int salary = sc.nextInt();
		
		// 2.使用if else if else分支结构判断薪水所在的范围并计算对应的个人所得税
		// 个人所得税公式： 本月应纳税所得额 * 对应的税率 - 速算扣除数
		double salaryPrice = 0.0;
		if(salary <= 5000) {
			System.out.println("无需纳税！");
		}
		else if(salary <= 8000) {
			// 块变量：作用范围是从声明开始一直到当前语句块结束
			//double salaryPrice = (salary - 5000) * 0.03;
			//salaryPrice = (salary - 5000) * 0.03;
			salaryPrice = (salary - 5000) * 0.03 - 0;
		}
		else if(salary <= 17000) {
			//salaryPrice = (salary - 8000) * 0.1 + (8000 - 5000) * 0.03;
			salaryPrice = (salary - 5000) * 0.1 - 210;
		}
		else if(salary <= 30000) {
			//salaryPrice = (salary - 17000) * 0.2 + (17000 - 8000) * 0.1 + (8000 - 5000) * 0.03;
			salaryPrice = (salary - 5000) * 0.2 - 1410;
		}
		// ...
		
		// 3.打印最终的计算结果
		System.out.println("最终的个人所得税是：" + salaryPrice);
	}
}
```

##### 案例  出租车计费方式：由里程钱数和等候时间钱数相加得出。里程数前3公里13元，超过3公里到15公里部分每公里2元，15公里以上部 分每公里3元。 等候时间每2分半1元，不足部分不要钱。 输入公里数和等候秒数，输出车费。例如：16公里，等候290秒，车费 = 13 +（15-3）*2 + （16-15）*3 + 1 = 41  

```java


import java.util.Scanner; 
 
public class IfTaxiTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入公里数和等待的秒数并使用变量记录
		System.out.println("请输入公里数和等待的秒数：");
		Scanner sc = new Scanner(System.in);
		int km = sc.nextInt();
		int sec = sc.nextInt();
		
		// 2.根据公里数计算对应的里程费并使用变量记录
		int kmPrice = 0;
		if(km <= 3) {
			kmPrice = 13;
		} else if(km <= 15) {
			kmPrice = 13 + (km - 3) * 2;
		} else {
			kmPrice = 13 + (15 - 3) * 2 + (km - 15) * 3;
		}
		
		// 3.根据等待的秒数来计算对应的等待费并使用变量记录
		int secPrice = sec / 150;
		
		// 4.计算总费用并打印
		int sumPrice = kmPrice + secPrice;
		System.out.println("本次出租车的总费用是：" + sumPrice);
	}
}
```

##### 案例   提示用户输入考试的成绩，使用if-else if-else分支结构判断所在等级并打印。  [90 ~ 100] 等级A [80 ~ 89] 等级B [70 ~ 79] 等级C [60 ~ 69] 等级D [0 ~ 59] 等级E 

```java
import java.util.Scanner; 
 
public class IfScoreTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入考试成绩并使用变量记录
		System.out.println("请输入您的考试成绩：");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		// 2.使用if else if else分支结构判断所在的等级并打印
		// 90 / 10 = 9;    91 / 10 = 9;  92 / 10 = 9;  99 / 10 = 9;   100 / 10 = 10;
		if(score >= 90 && score <= 100) {     // case 9:    case 10:  
			System.out.println("等级A");
		} else if(score >= 80) {              // case 8: 
			System.out.println("等级B");
		} else if(score >= 70) {              // case 7:
			System.out.println("等级C");
		} else if(score >= 60) {              // case 6:
			System.out.println("等级D");   
		} else {                              // default:
			System.out.println("等级E");
		}
	}
}
```

####  switch case分支结构  

-  switch(变量/表达式) { case 字面值1: 语句块1; break; case 字面值2: 语句块2; break; ... default:语句块n; } 

-  计算变量/表达式的数值 
  - 判断是否匹配字面值1
  - 若匹配，则执行语句块1 
    - 执行break跳出当前结构 
    - 若不匹配，则判断是否匹配字面值2
      -  若匹配，则执行语句块2 
      - 执行break跳出当前结构 
        -  若不匹配，则执行语句块n 
- 执行完case之后，如果有break，则跳出当前的switch-case结构。如果没有break，则依次执行下面的case，直到 遇到break或到程序执行结束为止
  - ![image-20200929145305377](D:\code\javacode\java-note\png\image-20200929145305377.png)

-  switch()中支持的数据类型有：byte、short、char以及int类型，从jdk1.5 开始支持枚举类型，从jdk1.7开始支持String类型。 

```java
/*
    编程使用switch case分支结构实现考试成绩的等级判断
 */

import java.util.Scanner; 
 
public class SwitchScoreTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入考试成绩并使用变量记录  0 ~ 100
		System.out.println("请输入您的考试成绩：");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		// 2.使用switch case分支结构实现考试成绩的等级判断
		switch(score / 10) {
			case 10: //System.out.println("等级A"); //break;
			case 9:  System.out.println("等级A"); break; // case穿透  
			case 8:  System.out.println("等级B"); break;
			case 7:  System.out.println("等级C"); break;
			case 6:  System.out.println("等级D"); break;
			default: System.out.println("等级E"); //break;
		}
		
		// 3.打印一句话
		System.out.println("世界上最痴情的等待就是我当case你当switch，或许永远都不会选到自己！");
	}
}
```

##### 案例 使用switch case分支结构模拟以下菜单效果

![image-20200929153510960](D:\code\javacode\java-note\png\image-20200929153510960.png)

```java
import java.util.Scanner; 
 
public class SwitchMenuTest {
	
	public static void main(String[] args) {
		
		// 1.绘制字符界面
		System.out.println("-------------------------------------");
		System.out.print(" [1]学员系统     ");
		System.out.println("[2]管理员系统");
		System.out.println(" [0]退出系统");
		System.out.println("-------------------------------------");
		System.out.println("请选择要进入的系统：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		
		// 2.使用switch case分支结构来模拟用户的选择并给出提示
		switch(choose) {
			case 1: System.out.println("正在进入学员系统..."); break;
			case 2: System.out.println("正在进入管理员系统..."); break;
			case 0: System.out.println("谢谢使用，下次再见！"); break;
			default: System.out.println("输入错误，请重新选择！");
		}
	}
}
```

### 循环结构

- 概念
  -  在程序中若希望重复执行一段代码时，就需要使用循环结构。 
  -  任何复杂的程序逻辑都可以通过顺序、分支、循环三种程序结构实现。 

#### for循环

-  for(初始化表达式; 条件表达式; 修改初始值表达式) { 循环体; } 
-  执行初始化表达式 
  - 判断条件表达式是否成立 => 成立则执行循环体 => 修改初始值表达式
    - 判断条件是否成立 => 若不成立，则循环结束
- ![image-20200929154341847](D:\code\javacode\java-note\png\image-20200929154341847.png)

```java
/*
    编程实现for循环的使用，模拟玩游戏的过程
 */
public class ForTest {
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 1; i <= 10; i++) { // i = i + 1  => i += 1  => i++
			System.out.println("今晚吃鸡，大吉大利，正在进行第" + i + "场游戏...");
			Thread.sleep(5000); // 表示模拟睡眠5秒的效果
			System.out.println("本场游戏结束！\n\n\n");
		}
		
		System.out.println("该休息了，否则明天早上就要迟到了！");
	}
}
```

##### 案例  使用for循环打印1-100的所有奇数，使用三种方式。 

```java

public class ForNumTest {
	
	public static void main(String[] args) {
		
		// 1.使用for循环打印1 ~ 100之间的所有奇数
		// 方式一：根据奇数的概念进行打印
		for(int i = 1; i <= 100; i++) {
			// 若当前i的数值是奇数时则打印，否则不打印   奇数就是不能被2整除的数，也就是对2取余的结果不为0
			if(i % 2 != 0) {
			    System.out.println("i = " + i);
			}
		}
		
		System.out.println("---------------------------------------------------");
		// 方式二：根据等差数列的概念来打印  每两个数据之间相差2
		for(int i = 1; i <= 100; i += 2) {
			System.out.println("i = " + i);
		}
		
		System.out.println("---------------------------------------------------");
		// 方式三：根据通项公式的规则来打印  2*i-1
		for(int i = 1; i <= 50; i++) {
			System.out.println("i = " + (2 * i - 1));
		}
	}
}
```

##### 案例  使用for循环实现累加：1+2+...+10000=？最后打印出来 

```java
public class ForSumTest {
	
	public static void main(String[] args) {
		
		// 2.声明一个变量负责记录累加的结果
		int sum = 0;
		
		// 1.使用for循环打印1 ~ 10000之间的所有整数
		for(int i = 1; i <= 10000; i++) {
			// 打印后不换行
			//System.out.print(i + " ");
			// 将所有i的取值都累加到变量sum中
			sum += i; // sum = sum + i;
		}
		// 专门用于换行
		//System.out.println();
		
		// 3.打印最终的累加结果
		System.out.println("sum = " + sum);
	}
}
```

##### 案例  使用for循环打印三位数中所有水仙花数。 所谓“水仙花数”即一个整数满足其值等于各个数位的立方和。 如：153是一个水仙花数，因为153=1^3+5^3+3^3。 

```java
public class ForWaterTest {
	
	public static void main(String[] args) {
	
		// 1.使用for循环打印所有的三位数
		for(int i = 100; i <= 999; i++) {
			
			// 3.拆分三位数中的各个数位上的数字
			// 123 / 100 = 1;        123 % 100 => 23 / 10 = 2;    123 % 10 = 3;
			int ia = i / 100;      // 拆分百位数
			int ib = i % 100 / 10; // 拆分十位数
			int ic = i % 10;       // 拆分个位数
			
			// 2.针对每个三位数都要判断该数是否为水仙花数，若是则打印，否则不打印
			// 判断该数是否等于各个数位的立方和
			if((ia*ia*ia + ib*ib*ib + ic*ic*ic) == i) {
				System.out.println("i = " + i);
			}
		}
	}
}
```

####  continue关键字 

-  continue语句用在循环体中，用于结束本次循环而开始下一次循环。 

##### 案例  使用for循环打印1 ~ 20之间的所有整数，若遇到5的倍数则跳过不打印。 

```java

public class ForContinueTest {
	
	public static void main(String[] args) {
		
		// 1.使用for循环打印1 ~ 20之间的所有整数
		for(int i = 1; i <= 20; i++) {
			// 若遇到5的倍数则跳过不打印该数，转而继续打印下一个数
			if(0 == i % 5) {
				continue; // 表示提前结束本次循环，继续下一次循环，也就是奔向了i++
			}
			System.out.println("i = " + i);
		}
	}
}
```

#### break 关键字 

-  break用于退出当前语句块，break用在循环体中用于退出循环。 

-  for(;;) - 这种没有循环条件的循环叫做 无限循环，俗称“死循环” 。 
-  如果再多层循环中，要退出外层循环体，需要使用标号的方式。 
  - ouder: for () {for(){ break outer; }}
  - ouder 可以为任意标识

##### 案例  不断地提示用户输入聊天内容并输出，直到用户输入”bye”结束聊天。 

```java

import java.util.Scanner; 
 
public class ForBreakTest {
	
	public static void main(String[] args) {
		
		// 5.声明一个boolean类型的变量作为发送方的标志
		boolean flag = true;
		
		// 4.使用无限循环来模拟不断地聊天
		for(;;) {
			// 1.提示用户输入要发送的聊天内容并使用变量记录
			System.out.println("请" + (flag? "张三": "李四") +"输入要发送的聊天内容：");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			
			// 2.判断用户输入的内容是否为"bye"，若是则聊天结束
			if("bye".equals(str)) {
				System.out.println("聊天结束！");
				break; // 用于跳出当前循环
			}
			// 3.若不是则打印用户输入的聊天内容
			//else {
				//System.out.println("聊天内容是：" + str);
			//}
			System.out.println((flag? "张三说：": "李四说：") + str + "\n\n\n");
			flag = !flag;
		}
		// ...
	}
}
```

##### 案例   猜数字游戏   随机生成数字n(1-100), 等待用户输入猜测数据, 根据用户的输入比较输出 猜大了，猜小了，猜对了, 如果用户猜对了就结束游戏 。 

```java
import java.util.Random; 
import java.util.Scanner;
 
public class ForGuessTest {
	
	public static void main(String[] args) {
		
		// 1.随机生成1 ~ 100之间的整数并使用变量记录
		Random ra = new Random();
		int temp = ra.nextInt(100) + 1;
		//System.out.println("temp = " + temp);
		
		// 4.声明一个int类型的变量来统计用户猜测的次数
		int cnt = 0;
		
		for(;;) {
			// 2.提示用户输入1 ~ 100之间猜测的整数并使用变量记录
			System.out.println("请输入1 ~ 100之间猜测的整数：");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			cnt++;
			
			// 3.使用用户输入的整数与随机数之间比较大小并给出对应的提示
			if(num > temp) {
				System.out.println("猜大了，再小一点吧！");
			} else if(num < temp) {
				System.out.println("猜小了，再大一点吧！");
			} else {
				System.out.println("恭喜您猜对了，游戏结束！");
				break;
			}
		}
		
		if(1 == cnt) {
			System.out.println("你果然是个大咖！");
		} else if(cnt <= 6) {
			System.out.println("水平不错，继续加油哦！");
		} else {
			System.out.println("你还可以多玩几次游戏！");
		}
		
		
	}
}
```

#### 双重for 循环的格式  

-  for(初始化表达式1; 条件表达式2; 修改初始值表达式3) { for(初始化表达式4; 条件表达式5; 修改初始值表达式6) { 循环体; } } 

-  执行表达式1 => 判断表达式2是否成立 
  - => 若成立，则执行表达式4 => 判断表达式5是否成立 
    - 若成立，则执行循环体 => 执行表达式6 => 表达式5是否成立 => 
    - 若不成立，则内层循环结束 => 表达式3 => 表达式2是否成立 
  - => 若不成立，则外层循环结束 
-  外层循环用于控制打印的行数，内层循环用于控制打印的列数，外层循 环改一下，内层循环从头到尾跑一圈。 
-  在以后的开发中若需要打印多行多列时，需要使用双重循环。 
-  多重循环不宜嵌套太多层，否则效率很低。一般到三重循环即可，最常 见的就是双重循环 

```java
/*
    编程实现双重for循环的使用
 */
public class ForForTest {
	
	public static void main(String[] args) {
		
		// 1.使用for循环打印5行字符串内容"厉害了我的哥!"
		for(int i = 1; i <= 5; i++) {
			System.out.println("厉害了我的哥！");
		}
		
		System.out.println("------------------------------------");
		// 2.使用for循环打印5列字符串内容"厉害了我的哥！"
		for(int j = 1; j <= 5; j++) {
			System.out.print("厉害了我的哥！ ");
		}
		System.out.println();
		
		System.out.println("------------------------------------");
		// 3.使用for循环打印5行5列字符串内容"厉害了我的哥！"
		// 外层循环主要用于控制打印的行数
		for(int i = 1; i <= 5; i++) {
			// 内层循环主要用于控制打印的列数
			for(int j = 1; j <= 5; j++) {
				System.out.print("厉害了我的哥！ ");
			}
			System.out.println();
		}
		
		/*
		    厉害了我的哥！厉害了我的哥！厉害了我的哥！厉害了我的哥！厉害了我的哥！
		    厉害了我的哥！厉害了我的哥！厉害了我的哥！厉害了我的哥！厉害了我的哥！
		    厉害了我的哥！ ...
		*/
	}
}
```

##### 案例  使用双重for循环分别打印以下图案![image-20200929155533546](D:\code\javacode\java-note\png\image-20200929155533546.png)

```java
public class ForForStarTest {
	
	public static void main(String[] args) {
		
		// 1.打印第一个星星图案
		// 外层循环主要用于控制打印的行数
		for(int i = 1; i <= 5; i++) {
			// 内层循环主要用于控制打印的列数
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------");
		// 2.打印第二个星星图案
		// 外层循环主要用于控制打印的行数
		for(int i = 1; i <= 5; i++) {
			// 内层循环主要用于控制打印的列数  也就是当前行的列数与当前行的行数是相等关系
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------");
		// 3.打印第三个星星图案
		// 外层循环主要用于控制打印的行数
		for(int i = 1; i <= 5; i++) {
			// 内层循环主要用于控制打印的列数  也就是当前行的列数与当前行的行数相加为6的关系
			for(int j = 1; j <= 6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------");
		// 4.打印第四个星星图案
		// 外层循环主要用于控制打印的行数
		for(int i = 1; i <= 5; i++) {
			// 控制空格的个数
			for(int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			// 内层循环主要用于控制打印的列数  也就是当前行的列数与当前行的行数为 2*i-1 的关系
			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
```

##### 案例  使用 双重for循环打印九九乘法表。 

```java
public class ForForTableTest {
	
	public static void main(String[] args) {
		
		// 1.使用外层for循环控制打印的行数，一共9行
		outer:for(int i = 1; i <= 9; i++) {
			// 2.使用内层for循环控制打印的列数，最多9列，规律是：与当前行所在的行数相等
			for(int j = 1; j <= i; j++) {
				// 3.使用两个循环变量来拼接等式
				System.out.print(j + "*" + i + "=" + j*i + " ");
				// 4.当打印完毕6*6 = 36后结束整个打印
				if(6 == j) {
					//break; // 主要用于跳出循环，但该关键字只能跳出当前所在的循环
					break outer; // 表示可以跳出外层for循环
				}
			}
			System.out.println();
		}
	}
}
```

##### 案例  使用双重for循环打印2~100之间的所有素数。 （ 当一个数只能被1和它本身整除时，这个数就叫做素数或质数。 )

```java
public class ForForPrimeTest {
	
	public static void main(String[] args) {
		
		// 1.使用for循环打印2 ~ 100之间的所有整数
		for(int i = 2; i <= 100; i++) {
			
			// 3.声明一个boolean类型的变量作为是否为素数的标记
			boolean flag = true;
			// 2.针对每一个当前的整数都要判断是否为素数，若是素数则打印，否则不打印
			// 判断一个数是否为素数的方法是：若该数不能被2到它本身-1之间的所有整数整除时，则证明该数是素数
			// 使用内层for循环用于控制2到该数自身-1之间的范围
			//for(int j = 2; j < i; j++) {
			// 只需要判断2到该数的平方根即可，因为随着除数的增大商必然减小，会造成重复的判断
			for(int j = 2; j <= Math.sqrt(i); j++) {
				// 使用当前数除以该循环中的每个数据并判断是否可以整除，只要找到一个可以整除的数据，则证明该数不是素数
				if(0 == i % j) {
					flag = false;
					break; // 跳出当前所在的内层循环，也就是不需要再继续除以下一个整数
				}
			}
			
			// 只可以打印素数
			if(flag) {
				System.out.println("i = " + i);
			}
		}
	}
}
```

#### while 循环

-  while(条件表达式) { 循环体; }  
-  • 判断条件表达式是否成立 
  - 若成立，则执行循环体 => 判断条件表达式是否成立 
  - 若不成立，则循环结束 
  - ![image-20200929160033252](D:\code\javacode\java-note\png\image-20200929160033252.png)

```java
public class WhileTest {
	
	public static void main(String[] args) {
		
		// 1.使用for循环打印1 ~ 10之间的所有整数
		// 在()或{}中声明的变量叫做块变量，作用范围是从声明开始一直到语句块结束
		for(int i = 1; i <= 10; i++) {
			System.out.println("i = " + i);
		}
		
		System.out.println("-----------------------------");
		// 2.使用while循环打印1 ~ 10之间的所有整数
		int i = 1;
		while(i <= 10) {
			System.out.println("i = " + i);
			i++;
		}
	}
}
```



##### 案例 使用while循环计算调和数列的和并打印，即： 1/1 + 1/2 + ... + 1/n。 

```java
import java.util.Scanner; 
 
public class WhileSumTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个整数并使用变量记录
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.使用while循环计算调和数列的和并使用变量记录
		double sum = 0.0;
		/*
		for(int i = 1; i <= num; i++) {
			sum += 1.0/i;
		}
		*/
		int i = 1;
		while(i <= num) {
			sum += 1.0/i;
			 i++;
		}
		
		// 3.打印最终的计算结果
		System.out.println("最终的计算结果是：" + sum);
	}
}
```

####  while循环和for循环比较 

-  while循环和for循环完全可以互换，当然推荐使用for循环。
-  while循环更适合于明确循环条件但不明确循环次数的场合中。 
- for循环更适合于明确循环次数或范围的场合中。 
- while(true) 等价于 for(;;) 都表示无限循环。 

##### 案例  提示用户输入一个任意位数的正整数然后反向输出。 

```java
import java.util.Scanner; 
 
public class WhileReverseTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个正整数并使用变量记录  123
		System.out.println("请输入一个正整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.使用while循环进行拆分并打印
		//while(num > 0) {
			//System.out.print(num % 10);  // 拆分个位数
			//num /= 10;  // 丢弃个位数
		//}
		// 2.使用while循环拆分整数中的每个数字并记录到变量中
		int res = 0;
		int temp = num;  // 指定变量作为num的替身
		while(temp > 0) {
			res = res*10 + temp % 10; // 3     32   321
			temp /= 10;               // 12    1    0
		}
		
		// 3.打印逆序后的结果
		System.out.println(num + "逆序后的结果是：" + res);
	}
}
```

#### do while循环

-  do { 循环体; } while(条件表达式); 
-  执行循环体 => 判断条件表达式是否成立 
  - 若成立，则执行循环体 => 判断条件表达式是否成立 
  - 若不成立，则循环结束 
  - ![image-20200929160423043](D:\code\javacode\java-note\png\image-20200929160423043.png)
-  do-while循环主要用于至少执行一次循环体的场合中。 

```java
/*
    编程实现do while循环的使用
 */
public class DoWhileTest {
	
	public static void main(String[] args) {
		
		// 1.使用for循环打印1 ~ 10之间的所有整数
		// 在()或{}中声明的变量叫做块变量，作用范围是从声明开始一直到语句块结束
		for(int i = 1; i <= 10; i++) {
			System.out.println("i = " + i);
		}
		
		System.out.println("-----------------------------");
		// 2.使用while循环打印1 ~ 10之间的所有整数
		//int i = 1;
		int i = 11;
		while(i <= 10) {
			System.out.println("i = " + i);
			i++;
		}
		
		System.out.println("-----------------------------");
		// 使用do while循环打印1 ~ 10之间的所有整数
		//i = 1;
		i = 11;
		do {
			System.out.println("i = " + i);
			i++;
		} while(i <= 10);
		
		
	}
}
```

##### 案例  使用do while循环来模拟学习任务是否合格的检查， 如果合格则停止， 否则就重新完成学习任务。 

```java
import java.util.Scanner; 
 
public class DoWhileCheckTest {
	
	public static void main(String[] args) throws Exception {
		
		String msg = null;  // 空 
 		do {
			System.out.println("正在疯狂学习中...");
			Thread.sleep(5000); // 模拟5秒钟
			System.out.println("是否合格？（y/n）");
			Scanner sc = new Scanner(System.in);
			msg = sc.next();
		} while(!"y".equals(msg));
		
		System.out.println("恭喜任务合格！");
		
		System.out.println("-------------------------------------------------------------");
		// 典故： 十动然拒    笔试考点：有没有分号
		int i = 1;
		while(i <= 10000) {
			;  // 空语句，啥也不干，可以用于延时
		}
		{
			System.out.println("I Love You !");
			i++;
		}
	}
}
```

