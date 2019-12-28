package com.github.hcsp.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {
    // 使用流的方法，再把之前的题目做一遍吧
    // 统计一个给定的字符串中，大写英文字母（A,B,C,...,Z）出现的次数。
    // 例如，给定字符串"AaBbCc1234ABC"，返回6，因为该字符串中出现了6次大写英文字母ABCABC
    public static int countUpperCaseLetters(String str) {
        // 因为没有找到Stream遍历Chars的方法(stream里面是单个的Char)所以使用了ASCII码
        Long count = str.chars().filter(Problem3::isUpperCharater).count();
        return count.intValue();
    }

    private static boolean isUpperCharater(int asciiCode){
        return asciiCode >= 65 && asciiCode <= 90;
    }





    public static void main(String[] args) {
        System.out.println(countUpperCaseLetters("AaBbCc1234ABC"));
    }
}
