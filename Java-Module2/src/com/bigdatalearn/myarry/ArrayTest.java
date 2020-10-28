package com.bigdatalearn.myarry;




public class ArrayTest {


    public static void main(String[] args) {
        // 创建一个16X16的二位数组
        int[][] arr = new int[16][16];
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n++;
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        //行的和
        for (int i = 0; i < arr.length; i++) {
            int row_sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                row_sum += arr[i][j];
            }
            System.out.println("第" + i + "行的累加和为" + row_sum);

        }

        // 列的和
        for (int j = 0; j < arr.length; j++) {
            int col_sum = 0;
            for (int i = 0; i < arr[j].length; i++) {
                col_sum += arr[i][j];
            }
            System.out.println("第" + j + "列的累加和为" + col_sum);

        }

        // 左斜和
        int left_up = 0;
        for (int i = 0; i < 16; i++) {
            left_up += arr[i][i];
        }
        System.out.println("左上的和为" + left_up);

        // 右斜和
        int right_up = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 15; j > 0; j--) {
                right_up += arr[i][j];
                break;
            }

        }
        System.out.println("左上的和为" + right_up);


    }
}
