package com.github.hcsp.stream;

public class Problem3 {
    // 使用流的方法，再把之前的题目做一遍吧
    // 统计一个给定的字符串中，大写英文字母（A,B,C,...,Z）出现的次数。
    // 例如，给定字符串"AaBbCc1234ABC"，返回6，因为该字符串中出现了6次大写英文字母ABCABC
    public static int countUpperCaseLetters(String str) {
        return (int) str.chars().filter(Character::isUpperCase).count();
    }

    public static void main(String[] args) {
        System.out.println(countUpperCaseLetters("AaBbCc1234ABC"));
    }
}
