package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem1 {
    static class User {
        private String name;
        private int age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    static int countUsers(List<User> users) {
        return (int) users.stream()
                .filter(getSpecificUsers())
                .count();
    }

    private static Predicate<User> getSpecificUsers() {
        return user -> user.getAge() >= 60 && user.getName().length() == 2;
    }

    // 编写一个方法，筛选出年龄大于等于60的用户，然后将他们按照年龄从大到小排序，将他们的名字放在一个LinkedList中返回
    static LinkedList<String> collectNames(List<User> users) {
        return users.stream()
                .filter(getUserOlderThanOrEqual60())
                .sorted(Comparator.comparing(User::getAge).reversed())
                .map(User::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static Predicate<User> getUserOlderThanOrEqual60() {
        return user -> user.getAge() >= 60;
    }

    public static void main(String[] args) {
        System.out.println(
                countUsers(
                        Arrays.asList(
                                new User("张三", 60),
                                new User("李四", 61),
                                new User("张三丰", 300),
                                new User("王五", 12))));

        System.out.println(
                collectNames(
                        Arrays.asList(
                                new User("张三", 60),
                                new User("李四", 61),
                                new User("张三丰", 300),
                                new User("王五", 12))));
    }
}
