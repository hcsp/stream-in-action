package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;

public class Problem6 {
    // 使用流的方法，把所有长度等于1的单词挑出来，然后用逗号连接起来
    // 例如，传入参数words=['a','bb','ccc','d','e']
    // 返回字符串a,d,e
    public static String filterThenConcat(Set<String> words) {
        Optional<String> reduce = words.stream().filter(e -> e.length() == 1).reduce(new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s+","+s2;
            }
        });
        return reduce.get();
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList("a", "bb", "ccc", "d", "e"));
        System.out.println(filterThenConcat(set));
    }
}
