package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
    // 判断一段文本中是否包含关键词列表中的文本，如果包含任意一个关键词，返回true，否则返回false
    // 例如，text="catcatcat,boyboyboy", keywords=["boy", "girl"]，返回true
    // 例如，text="I am a boy", keywords=["cat", "dog"]，返回false
    public static boolean containsKeyword(String text, List<String> keywords) {
        return keywords.stream().anyMatch(text::contains);
    }

    public static void main(String[] args) {
        System.out.println(containsKeyword("catcatcat,boyboyboy", Arrays.asList("boy", "girl")));
        System.out.println(containsKeyword("I am a boy", Arrays.asList("cat", "dog")));
    }
}
