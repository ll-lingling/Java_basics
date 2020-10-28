/*
自定义数组扩容规则，当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。
例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。
*/
import java.util.Scanner;
import java.util.Arrays; 

public class ArrayExpansion {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
       
        System.out.println("请输入一维数组的容量：");
        int input_length = sc.nextInt();   
        int[] arr = new int[input_length];
        System.out.println("数组的容量为：" + arr.length);
        for (int i=0;i<arr.length;i++){

        	System.out.println("请输入元素");
        	arr[i] = sc.nextInt();
        	if (arr.length * 0.8 <= i){
        		int[] arr_exp = Arrays.copyOf(arr, (int)(arr.length*1.5));
		System.out.println("该数组长度以扩充至" + arr_exp.length);
		break;
        	}
        }
    }
}

