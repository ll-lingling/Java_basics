package com.bigdatalearn.answer1;

/*
 * 编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
 * */
public class PrintTest {
    public static void main(String[] args) {
        String str = new String("ABCD123!@#$%ab");
        printCount(str);
    }

    public static void printCount(String str) {
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int elseCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                elseCount++;
            }
        }
        System.out.println("大写字母:" + upperCount);
        System.out.println("小写字母:" + lowerCount);
        System.out.println("数字:" + digitCount);
        System.out.println("其他符号:" + elseCount);
    }
}
