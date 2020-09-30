/*
实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
 其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
 其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
*/

 import java.util.Scanner;
 import java.util.Random;
 import java.util.Arrays; 

 public class Winning {

 	public static void main(String[] args) {
 		
 		int[] two_color_ball = new int [7];
 		for (int i=0; i<two_color_ball.length-1;i++){
 			int read_ball = (int)(Math.random()*32+1); // 生成随机数1-33
 			two_color_ball[i] = read_ball;
 			for  (int j=0;j<i;j++) {
 				if (two_color_ball[i] == two_color_ball[j]){
 					i--;// 若生成随机数重复，则i-1 重新生成随机数
 					break;
 				}		
 			}
 		}
 		two_color_ball[6] = (int)(Math.random()*15+1);
 		System.out.println("本期双色球中奖号码为"+ Arrays.toString(two_color_ball));
 	}
 }