package com.bigdatalearn.answer2;

import java.security.PublicKey;

/*
编程获取两个指定字符串中的最大相同子串。

 如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"

 提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
* */
public class CompareTest {
    public static void main(String[] args) {
        String str1 = "asdafghjka";
        String str2 = "aaasdfg";
        System.out.println("最大子串为:" + findString(str1, str2));
    }

    public static String findString(String str1, String str2) {
        String max = str1.length() > str2.length() ? str1 : str2;   // 查找长的字符串
        String min = str1.length() > str2.length() ? str2 : str1;    // 查找短的字符串
        for (int i = 0; i < min.length(); i++) {
            //第一个循环是定义一共有多少轮，但不一定完全执行完才能找到，如果找到下面的return 会返回找到的子串
            for (int j = 0, n = min.length() - i; n < min.length() + 1; j++, n++) {
                //第二个循坏中的 j 是获取str2中的子串都是从0开始的,而n 是用来计算在str2中获取子串的长度,第一轮是7,就是str2的长度减去0(我们可以想象成 str的长度 - 轮数1 - 1 = 7(就是从0到7获取str2的子串),如果是第二轮就是str的长度 - 轮数2 - 1 = 6)(就是从0到6获取str2的子串),而判断条件n < min.length() + 1 是用来获取有多少个子串,比如上面的6,获取了(0到6之后,还有一个是1到7的子串,在执行完一次循坏之后j和n会自加1,在第二次循环的时候j和n就会变成1和7,就能获取长度为6的第二个子串.长度为5,4也是依次计算)
                String temp = min.substring(j, n);  //根据长度获取str2的子串,这里要注意的是,并不能获取到n,也就是说获取的长度为[]j,n),因为substring函数是左闭右开的.
                System.out.println(j + " " + n + " " + temp); //这里的打印是辅助,没用的
                if (max.contains(temp)) //对比子串是否在str1中
                    return temp;    //返回找到子串
            }
        }

        return null;    //如果没有找到return null
    }
}