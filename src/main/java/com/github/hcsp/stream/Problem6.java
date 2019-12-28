package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Problem6 {
    // 使用流的方法，把所有长度等于1的单词挑出来，然后用逗号连接起来
    // 例如，传入参数words=['a','bb','ccc','d','e']
    // 返回字符串a,d,e
    public static String filterThenConcat(Set<String> words) {
        String s = words.stream().filter(word -> word.length() == 1).reduce((first, second) -> first + ',' + second)
            .orElse("");
        return s;
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList("a", "bb", "ccc", "d", "e"));
        System.out.println(filterThenConcat(set));
    }
}
