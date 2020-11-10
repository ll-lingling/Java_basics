package com.bigdatalearn.answer3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {

        //1.准备一个Map集合
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        //2.准备一个String类型的对象描述原始字符串
        String str1 = new String("123,456,123,789,456");
        //3.使用split方法对原始字符串按照字符串中的，拆分字符串，并在集合中查找
        String[] sArr = str1.split(",");
        for (int i = 0; i < sArr.length; i++) {
            // 4.若集合中没有该字符串，则将该字符串和1组成一个键值对放入集合中
            if (!m1.containsKey(sArr[i])) {
                m1.put(sArr[i], 1);
            }
            // 5.若集合中有该字符串，则将该字符串对应的value值+1
            else {
                m1.put(sArr[i], m1.get(sArr[i]) + 1);
            }
        }
        System.out.println("m1= " + m1);
        //6.获取Map集合中所有的映射关系组成Set集合并遍历
        Set<Map.Entry<String, Integer>> s1 = m1.entrySet();
        for (Map.Entry<String, Integer> me1 : s1) {
            System.out.println(me1);
            System.out.println(me1.getKey() + "出现了" + me1.getValue() + "次！");
        }
    }
}
