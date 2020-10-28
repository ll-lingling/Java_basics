/*
使用双重循环实现五子棋游戏棋盘的绘制，棋盘界面的具体效果如下
*/

import java.util.Arrays; 

public class GoBang {

	public static void main(String[] args) {
		
		String[] arr = {"","0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
		// String[] plus = {"+","+","+","+","+","+","+","+","+","+","+","+","+","+","+"};

		for (int m=0;m<=arr.length-1;m++) {
			
			if (m<1){
				for(int i=0; i<=arr.length-1;i++){
					if (arr.length-1==i){
						System.out.print(arr[i]+"\n");
					}else{
						System.out.print(arr[i]+"\t");
					}
					
				}
			}else{
				System.out.print(arr[m]);
				for (int n=0;n<=arr.length-2; n++) {
					if (arr.length-2==n){
						System.out.print("\t"+"+"+"\n");
					}else{
						System.out.print("\t"+"+");
					}
				}
			}
		}
	}
}