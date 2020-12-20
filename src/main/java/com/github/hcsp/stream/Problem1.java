package com.github.hcsp.stream;

import java.util.*;

public class Problem1 {
    static class User {
        private String name;
        private int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    // 编写一个方法，统计"年龄大于等于60的用户中，名字是两个字的用户数量"
    public static int countUsers(List<User> users) {
        return (int) users.stream().filter(user -> user.getAge() >= 60 && user.getName().length() == 2).count();
    }


    public static int compareAge(User a, User b) {
        if (a.getAge() > b.getAge()) {
            return -1;
        } else if (a.getAge() < b.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }

    // 编写一个方法，筛选出年龄大于等于60的用户，然后将他们按照年龄从大到小排序，将他们的名字放在一个LinkedList中返回
    public static LinkedList<String> collectNames(List<User> users) {
        LinkedList<String> target = new LinkedList<>();
        users.stream().filter(user -> user.getAge() >= 60).sorted(Problem1::compareAge).forEach(user -> target.add(user.getName()));
        return target;
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
