/*
�Զ����������ݹ��򣬵��Ѵ洢Ԫ�������ﵽ�������� 80%ʱ������ 1.5 ����
���磬�������� 10��������� 8 ��Ԫ��ʱ������������ݣ������� 10 �� 15��
*/
import java.util.Scanner;
import java.util.Arrays; 

public class ArrayExpansion {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
       
        System.out.println("������һά�����������");
        int input_length = sc.nextInt();   
        int[] arr = new int[input_length];
        System.out.println("���������Ϊ��" + arr.length);
        for (int i=0;i<arr.length;i++){

        	System.out.println("������Ԫ��");
        	arr[i] = sc.nextInt();
        	if (arr.length * 0.8 <= i){
        		int[] arr_exp = Arrays.copyOf(arr, (int)(arr.length*1.5));
		System.out.println("�����鳤����������" + arr_exp.length);
		break;
        	}
        }
    }
}

