package com.github.hcsp.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Problem3 {
    // 使用流的方法，再把之前的题目做一遍吧
    // 统计一个给定的字符串中，大写英文字母（A,B,C,...,Z）出现的次数。
    // 例如，给定字符串"AaBbCc1234ABC"，返回6，因为该字符串中出现了6次大写英文字母ABCABC
    public static int countUpperCaseLetters(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            arr.add(chars[i]);
        }
        return (int) arr.stream().filter(c -> Character.isUpperCase(c)).count();
    }

    public static void main(String[] args) {
        System.out.println(countUpperCaseLetters("AaBbCc1234ABC"));
    }
}
