# 大数据学习-Java Day04

## 数组

### 一维数组

- 基本概念
  -  当需要在Java程序中记录单个数据内容时，则声明一个变量即可 
  -  当需要在Java程序中记录多个类型相同的数据内容时，则声明一个一维数 组即可，一维数组本质上就是在内存空间中申请一段连续的存储单元。 
  -  数组是相同数据类型的多个元素的容器，元素按线性顺序排列，在Java语 言中体现为一种引用数据类型 

- 声明方式
  -  数据类型[] 数组名称 = new 数据类型[数组的长度]; 
  - 调用数组的length属性可以获取数组的长度： 
  - 可以通过下标的方式访问数组中的每一个元素。需要注意的是：数组的 下标从0开始，对于长度为n的数组，下标的范围是0~n-1。 

- 初始化方式
  -  基本类型的数组（数据元素为基本类型）创建后，其元素的初始值：byte、 short、char、int、long为0；float和double为0.0；boolean为false。
  - 可以在数组声明的同时进行初始化，具体如下： 数据类型[] 数组名称 = {初始值1, 初始值2, ...}; 

```java
/*
    编程实现一维数组的声明和使用
 */
public class ArrayTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个长度为2元素类型为int类型的一维数组
		// 数据类型[] 数组名称 = new 数据类型[数组的长度];
		//int arr1[] = new int[2];    // 两种方式从结果上来说是一样的，不推荐使用
		//int num = 2;                // 声明一个初始值为2的变量 
		int[] arr1 = new int[2];      // 推荐该方式，更容易与变量的声明区分，提高了代码的可读性   动态方式
		
		// 2.打印一维数组的长度以及每个元素的数值
		System.out.println("数组的长度是：" + arr1.length); // 2   下标从0 ~ 1
		System.out.println("下标为0的元素是：" + arr1[0]);  // 0  默认值
		System.out.println("下标为1的元素是：" + arr1[1]); 	// 0  
        //System.out.println("下标为2的元素是：" + arr1[2]); 	// 编译ok，运行发生ArrayIndexOutOfBoundsException数组下标越界异常

		System.out.println("------------------------------------------------");
		// 3.使用for循环打印数组中的所有元素
		for(int i = 0; i < arr1.length; i++) {
			System.out.println("下标为" + i + "的元素是：" + arr1[i]); // 全是0
		}
		// 7.直接通过数组名来打印数组中的所有元素
		System.out.println("arr1 = " + arr1); // 地址信息
		
		System.out.println("------------------------------------------------");
		// 4.声明一个长度为5元素类型为double类型的一维数组
		double[] arr2 = new double[5];
		// 打印数组中每个元素值
		for(int i = 0; i < arr2.length; i++) {
			System.out.println("下标为" + i + "的元素是：" + arr2[i]); // 全是0.0 
		}
		
		System.out.println("------------------------------------------------");
		// 5.声明数组的同时就对数组中的元素进行初始化   静态方式的简化版
		char[] arr3 = {'a', 'b', 'c', 'd'};
		// 打印数组中的每个元素值
		for(int i = 0; i < arr3.length; i++) {
			System.out.println("下标为" + i + "的元素是：" + arr3[i]); // a b c d
		}
		
		System.out.println("------------------------------------------------");
		// 6.特殊的写法   静态方式
		boolean[] arr4 = new boolean[]{true, true, false, false};
		// 打印数组中的每个元素值
		for(int i = 0; i < arr4.length; i++) {
			System.out.println("下标为" + i + "的元素是：" + arr4[i]); // true true false false
		}
	}
}
```



- 内存结构
  -  栈用于存放程序运行过程当中所有的局部变量。一个运行的Java程序从开 始到结束会有多次变量的声明。 
  -  JVM会在其内存空间中开辟一个称为“堆”的存储空间，这部分空间用于存 储使用new关键字创建的数组和对象。 

##### 案例  声明一个长度为5元素类型为int类型的一维数组，打印数组中所有元素值； 使用元素11、22、33、44分别对数组中前四个元素赋值后再次打印； 将元素55插入到下标为0的位置，原有元素向后移动，再打印所有元素值； 将元素55从数组中删除，删除方式为后续元素向前移动，最后位置置为0 并打印；查找数组中是否存在元素22，若存在则修改为220后再次打印所有元素； 

```java
public class ArrayOpTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个长度为5元素类型为int类型的一维数组
		int[] arr = new int[5];
		// 打印数组中所有元素的数值
		System.out.print("数组中的元素有：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); // 全是默认值0
		}
		System.out.println();
		
		System.out.println("-------------------------------------------------");
		// 2.将数据11 22 33 44依次对数组中前四个元素赋值
		/*
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		arr[3] = 44;
		*/
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = (i+1)*11;
		}
		// 打印数组中所有元素的数值
		System.out.print("数组中的元素有：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); // 11 22 33 44 0
		}
		System.out.println();
		
		System.out.println("-------------------------------------------------");
		// 3.将数据55插入到下标为0的位置，原有元素向后移动
		/*
		arr[4] = arr[3];
		arr[3] = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = 55;
		*/
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = 55;
		// 打印数组中所有元素的数值
		System.out.print("数组中的元素有：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); // 55 11 22 33 44
		}
		System.out.println();
		
		System.out.println("-------------------------------------------------");
		// 4.将数据55从数组中删除，删除方式为后续元素向前移动，最后一个位置置为0
		/*
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = arr[3];
		arr[3] = arr[4];
		*/
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[4] = 0;
		// 打印数组中所有元素的数值
		System.out.print("数组中的元素有：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); // 11 22 33 44 0
		}
		System.out.println();
		
		System.out.println("-------------------------------------------------");
		// 5.查找数组中是否有元素22，若有则修改为220
		for(int i = 0; i < arr.length; i++) {
			if(22 == arr[i]) {
				arr[i] = 220;
			}
		}
		// 打印数组中所有元素的数值
		System.out.print("数组中的元素有：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); // 11 220 33 44 0
		}
		System.out.println();
	}
}
```

- 优缺点
  - 可以直接通过下标(或索引)的方式访问指定位置的元素，速度很快。 
  - 数组要求所有元素的类型相同。 
  - 数组要求内存空间连续，并且长度一旦确定就不能修改。
  - 增加和删除元素时可能移动大量元素，效率低。 

##### 案例  声明一个初始值为11 22 33 44 55的一维数组并打印所有元素 ； 声明一个长度为3元素类型为int类型的一维数组并打印所有元素 ； 实现将第一个数组中间3个元素赋值到第二个数组中 ； 再次打印第二个数组中的所有元素 。

```java
public class ArrayCopyTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个初始值为11、22、33、44、55的一维数组
		int[] arr = {11, 22, 33, 44, 55};
		// 打印数组中的所有元素
		System.out.print("第一个数组中的元素有：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); // 11 22 33 44 55
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------");
		// 2.声明一个长度为3元素类型为int类型的一维数组
		int[] brr = new int[3];
		// 打印数组中的所有元素
		System.out.print("第二个数组中的元素有：");
		for(int i = 0; i < brr.length; i++) {
			System.out.print(brr[i] + " "); // 0 0 0
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------");
		// 3.将第一个数组中的中间3个元素赋值到第二个数组中
		/*
		brr[0] = arr[1];
		brr[1] = arr[2];
		brr[2] = arr[3];
		*/
		/*
		for(int i = 0; i < brr.length; i++) {
			brr[i] = arr[i+1];
		}
		*/
		// 可以直接使用Java官方提供的拷贝功能
		// 表示将数组arr中下标从1开始的3个元素拷贝到数组brr中下标从0开始的位置
		System.arraycopy(arr, 1, brr, 0, 3);
		// 打印第二个数组中的所有元素
		System.out.print("第二个数组中的元素有：");
		for(int i = 0; i < brr.length; i++) {
			System.out.print(brr[i] + " "); // 22 33 44
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------");
		// 4.笔试考点
		// 表示将变量arr的数值赋值给变量brr，覆盖变量brr中原来的数值
		// 数组名arr的内存空间中存放的是数据在堆区中的内存地址信息，赋值后让brr变量中存放了arr所指向堆区的内存地址
		// 也就是让brr和arr指向了同一块堆区空间，有本质上就是改变指向而已
		brr = arr;
		// 打印第二个数组中的所有元素
		System.out.print("第二个数组中的元素有：");
		for(int i = 0; i < brr.length; i++) {
			System.out.print(brr[i] + " "); // 22 33 44
		}
		System.out.println();	
		
	}
}
```

##### 案例  编程统计用户输入任意一个正整数中每个数字出现次数的统计并打印。  如：123123 => 1出现2次，2出现2次，3出现2次 

```java
import java.util.Scanner; 
 
public class ArrayCountTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个正整数并使用变量记录
		System.out.println("请输入一个正整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.准备一个长度为10元素类型int类型的一维数组，默认值为0
		int[] arr = new int[10];
		
		// 3.拆分正整数中的每个数字并统计到一维数组中
		int temp = num;
		while(temp > 0) {
			arr[temp%10]++;
			temp /= 10;
		}
		
		// 4.打印最终的统计结果
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				System.out.println("数字" + i + "出现了" + arr[i] + "次！");
			}
		}
	}
}
```

- 数组工具类
  -  java.util.Arrays类可以实现对数组中元素的遍历、查找、排序等操作。 

```java
import java.util.Arrays; 
 
public class ArraysTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个初始值为10、20、30、40、50的一维数组
		int[] arr1 = {10, 20, 30, 40, 50};
		// 2.使用原始方式打印数组中的所有元素，要求打印格式为：[10, 20, 30, 40, 50]
		System.out.print("第一个数组中的元素有：[");
		for(int i = 0; i < arr1.length; i++) {
			// 当打印的元素是最后一个元素时，则直接打印元素本身即可
			if(arr1.length-1 == i) {
				System.out.print(arr1[i]);
			} else {
				// 否则打印元素后打印逗号加空格
				System.out.print(arr1[i] + ", ");
			}
		}
		System.out.println("]");
		
		System.out.println("---------------------------------------------------");
		// 3.使用数组工具类实现数组中所有元素的打印
		System.out.println("第一个数组中的元素有：" + Arrays.toString(arr1));  // [10, 20, 30, 40, 50]
		
		System.out.println("---------------------------------------------------");
		// 4.声明一个长度为5元素类型为int类型的一维数组
		int[] arr2 = new int[5];
		System.out.println("第二个数组中的元素有：" + Arrays.toString(arr2)); // [0, 0, 0, 0, 0]
		// 使用数组工具类中的fill方法实现数组中元素的填充并打印
		// 表示使用10来填充数组arr中的每个元素，也就是给数组中每个元素赋值为10
		Arrays.fill(arr2, 10);
		System.out.println("第二个数组中的元素有：" + Arrays.toString(arr2)); // [10, 10, 10, 10, 10]
		
		System.out.println("---------------------------------------------------");
		// 5.声明一个长度为5元素类型为int类型的一维数组并初始化
		int[] arr3 = new int[5];
		Arrays.fill(arr3, 10);
		System.out.println("第三个数组中的元素有：" + Arrays.toString(arr3)); // [10, 10, 10, 10, 10]
		// 判断该数组是否与上述数组相等并打印，若相同则打印true，否则打印false
		System.out.println(Arrays.equals(arr2, arr3)); // true
		// 修改数组3中的元素值
		arr3[4] = 20;
		System.out.println("第三个数组中的元素有：" + Arrays.toString(arr3)); // [10, 10, 10, 10, 20]
		System.out.println(Arrays.equals(arr2, arr3)); // false  要求内容要相同
		arr2[3] = 20;
		System.out.println("第二个数组中的元素有：" + Arrays.toString(arr2)); // [10, 10, 10, 20, 10]
		System.out.println(Arrays.equals(arr2, arr3)); // false  要求顺序要相同
	}
}
```



##### 案例   • 提示用户输入学生的人数以及每个学生的考试成绩并打印出来。 计算该班级的总分和平均分并打印出来。 

 

```java

import java.util.Scanner; 
import java.util.Arrays;
 
public class ArrayScoreTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入学生的人数并使用变量记录
		System.out.println("请输入学生的人数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.根据学生的人数来声明对应长度的数组负责记录学生的考试成绩
		// 变长数组 ： 主要指变量可以作为数组的长度，但绝不是数组的长度可以发生改变
		int[] scores = new int[num];
		
		// 3.提示用户输入每个学生的考试成绩并记录一维数组中
		for(int i = 0; i < num; i++) {
			System.out.println("请输入第" + (i+1) + "个学生的考试成绩：");
			scores[i] = sc.nextInt();
		}
		
		// 4.打印所有学生的考试成绩
		System.out.print("本班学生的考试成绩分别是：");
		for(int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------------------------");
		// 5.计算本班级学生的总分以及平均分并使用变量记录
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		double avg = sum*1.0 / num;
		// 打印最终的计算结果
		System.out.println("本班级学生的总分是：" + sum + "，平均分是：" + avg);
		
		System.out.println("----------------------------------------------");
		// 6.查找本班所有学生考试成绩中的最低分和最高分并打印出来
		System.out.println("原始的考试成绩是：" + Arrays.toString(scores));
		// 调用工具类中的排序方法对所有考试成绩进行从小到大的排序
		Arrays.sort(scores);
		System.out.println("排序后的考试成绩是：" + Arrays.toString(scores));
		System.out.println("最低分是：" + scores[0] + "，最高分是：" + scores[num-1]);
		
		System.out.println("----------------------------------------------");
		// 从数组中查找指定元素所在的下标位置
		System.out.println("59分在数组中的下标位置是：" + Arrays.binarySearch(scores, 59));
		System.out.println("60分在数组中的下标位置是：" + Arrays.binarySearch(scores, 60));
	}
}
```

### 二维数组

- 概念
  -  二维数组本质上就是由多个一维数组摞在一起组成的数组，二维数组中 的每个元素都是一维数组，而一维数组中的每个元素才是数据内容。 

- 声明
  -  数据类型[][] 数组名称 = new 数据类型[行数][列数];  
- 初始化
  -  数据类型[][] 数组名称 = {{元素1, 元素2，...}, ...}; 

```java
/*
    编程实现二维数组的声明和使用
 */
public class ArrayArrayTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个具有2行3列元素类型为int类型的二维数组
		int[][] arr1 = new int[2][3];
		// 打印数组中的每个元素
		// 使用外层for循环控制打印的行数
		for(int i = 0; i < arr1.length; i++) {
			// 使用内层for循环控制打印的列数
			for(int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " "); // 全是0
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------------");
		// 2.实现二维数组中元素的赋值
		int cnt = 1;
		// 使用外层for循环控制打印的行数
		for(int i = 0; i < arr1.length; i++) {
			// 使用内层for循环控制打印的列数
			for(int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = cnt++;
			}
		}
		// 使用外层for循环控制打印的行数
		for(int i = 0; i < arr1.length; i++) {
			// 使用内层for循环控制打印的列数
			for(int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " "); // 1 2 3   4 5 6
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------------");
		// 3.二维数组元素的初始化操作
		int[][] arr2 = {{11, 22, 33, 44}, {55, 66, 77, 88}};
		// 使用外层for循环控制打印的行数
		for(int i = 0; i < arr2.length; i++) {
			// 使用内层for循环控制打印的列数
			for(int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " "); // 11 22 33 44   55 66 77 88
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------------");
		// 4.考点
        // java 二维数组 可以声明不同列数的二维数组，但是内存地址中依然是连续的
		int[][] arr3 = new int[3][];
		arr3[0] = new int[3];
		arr3[1] = new int[4];
		arr3[2] = new int[5];
	}
}
```

##### 案例  根据用户输入的行数n输出对应行数的杨辉三角

```java

import java.util.Scanner; 
 
public class ArrayArrayTriangleTest {
	
	public static void main(String[] args) {
		
		// 1.提示用户输入一个行数并使用变量记录
		System.out.println("请输入一个行数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2.根据用户输入的行数来声明对应的二维数组
		int[][] arr = new int[num][];
		
		// 3.针对二维数组中的每个元素进行初始化，使用双重for循环
		// 使用外层for循环控制二维数组的行下标
		for(int i = 0; i < num; i++) {
			// 针对二维数组中的每一行进行内存空间的申请
			arr[i] = new int[i+1];
			// 使用内层for循环控制二维数组的列下标
			for(int j = 0; j <= i; j++) {
				// 当列下标为0或者列下标与当前行的行下标相等时，则对应位置的元素就是1
				if(0 == j || i == j) {
					arr[i][j] = 1;
				} else {
					// 否则对应位置的元素就是上一行当前列的元素加上上一行前一列的元素
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
			}
		}
		
		// 4.打印最终生成的结果
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

