package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProblemsTest {
    @Test
    public void test1() {
        Assertions.assertEquals(
                2,
                Problem1.countUsers(
                        Arrays.asList(
                                new Problem1.User("张三", 60),
                                new Problem1.User("李四", 61),
                                new Problem1.User("张三丰", 300),
                                new Problem1.User("王五", 12))));
    }

    @Test
    public void test2() {
        LinkedList<String> linkedList =
                Problem1.collectNames(
                        Arrays.asList(
                                new Problem1.User("张三", 60),
                                new Problem1.User("李四", 61),
                                new Problem1.User("张三丰", 300),
                                new Problem1.User("王五", 12)));
        Assertions.assertEquals(3, linkedList.size());
        Assertions.assertEquals("张三丰", linkedList.get(0));
        Assertions.assertEquals("李四", linkedList.get(1));
        Assertions.assertEquals("张三", linkedList.get(2));
    }

    @Test
    public void test3() {
        Assertions.assertTrue(
                Problem2.containsKeyword("catcatcat,boyboyboy", Arrays.asList("boy", "girl")));
        Assertions.assertFalse(Problem2.containsKeyword("I am a boy", Arrays.asList("cat", "dog")));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(6, Problem3.countUpperCaseLetters("AaBbCc1234ABC"));
    }

    @Test
    public void test5() {
        Map<String, List<Problem4.Employee>> map =
                Problem4.collect(
                        Arrays.asList(
                                new Problem4.Employee(1, "张三", 40, "技术部"),
                                new Problem4.Employee(2, "李四", 30, "技术部"),
                                new Problem4.Employee(3, "王五", 40, "市场部"),
                                new Problem4.Employee(4, "王五", 50, "市场部")));

        Assertions.assertEquals(
                Arrays.asList(2, 1),
                map.get("技术部").stream().map(Problem4.Employee::getId).collect(Collectors.toList()));
        Assertions.assertEquals(
                Arrays.asList(3, 4),
                map.get("市场部").stream().map(Problem4.Employee::getId).collect(Collectors.toList()));
    }

    @Test
    public void test6() {
        Map<Integer, Problem5.Order> map =
                Problem5.toMap(
                        Arrays.asList(new Problem5.Order(1, "A"), new Problem5.Order(2, "B")));
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals("A", map.get(1).getName());
        Assertions.assertEquals("B", map.get(2).getName());
    }

    @Test
    public void test7() {
        LinkedHashSet<String> words =
                new LinkedHashSet<>(Arrays.asList("a", "bb", "ccc", "d", "e"));
        Assertions.assertEquals("a,d,e", Problem6.filterThenConcat(words));
    }
}
