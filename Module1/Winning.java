/*
ʵ��˫ɫ��齱��Ϸ�н���������ɣ��н������� 6 ���������� 1 �����������ɡ�
 ���к������Ҫ��������� 6 �� 1~33 ֮�䲻�ظ���������롣
 �����������Ҫ��������� 1 �� 1~16 ֮���������롣
*/

 import java.util.Scanner;
 import java.util.Random;
 import java.util.Arrays; 

 public class Winning {

 	public static void main(String[] args) {
 		
 		int[] two_color_ball = new int [7];
 		for (int i=0; i<two_color_ball.length-1;i++){
 			int read_ball = (int)(Math.random()*32+1); // ���������1-33
 			two_color_ball[i] = read_ball;
 			for  (int j=0;j<i;j++) {
 				if (two_color_ball[i] == two_color_ball[j]){
 					i--;// ������������ظ�����i-1 �������������
 					break;
 				}		
 			}
 		}
 		two_color_ball[6] = (int)(Math.random()*15+1);
 		System.out.println("����˫ɫ���н�����Ϊ"+ Arrays.toString(two_color_ball));
 	}
 }