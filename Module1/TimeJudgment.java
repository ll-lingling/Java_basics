/*
��ʾ�û�������������Ϣ���ж���һ������һ���еĵڼ��첢��ӡ��
*/
import java.util.Scanner;

public class TimeJudgment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������");
		int year = sc.nextInt();
		System.out.println("��������");
		int month = sc.nextInt();
		System.out.println("��������");
		int day = sc.nextInt();
		int sum =0;
		switch (month){
			case 1:sum=0;break;
			case 2:sum=31;break;
			case 3:sum=59;break;
			case 4:sum=90;break;
			case 5:sum=120;break;
			case 6:sum=151;break;
			case 7:sum=181;break;
			case 8:sum=212;break;
			case 9:sum=243;break;
			case 10:sum=273;break;
			case 11:sum=304;break;
			case 12:sum=334;break;
			default:System.out.println("data error");break;
		}

		sum=sum+day; 
		// �ټ���ĳ�������
		// �ж��ǲ�������
		if(year%400==0||(year%4==0&&year%100!=0)){
			// ������������·ݴ���2 ������Ӧ�ü�һ��
			if(month>2){
			sum++;
			}	
		}
		System.out.println(sum);
	}
}
