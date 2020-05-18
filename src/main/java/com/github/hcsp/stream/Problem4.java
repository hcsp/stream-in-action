package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem4 {
    // 再用流的方法把之前的题目做一遍吧：
    // 请编写一个方法，对传入的List<Employee>进行如下处理：
    // 返回一个从部门名到这个部门的所有用户的映射。同一个部门的用户按照年龄进行从小到大排序。
    // 例如，传入的employees是[{name=张三, department=技术部, age=40 }, {name=李四, department=技术部, age=30 },
    // {name=王五, department=市场部, age=40 }]
    // 返回如下映射：
    //    技术部 -> [{name=李四, department=技术部, age=30 }, {name=张三, department=技术部, age=40 }]
    //    市场部 -> [{name=王五, department=市场部, age=40 }]
    public static Map<String, List<Employee>> collect(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        System.out.println(
                collect(
                        Arrays.asList(
                                new Employee(1, "张三", 40, "技术部"),
                                new Employee(2, "李四", 30, "技术部"),
                                new Employee(3, "王五", 40, "市场部"))));
    }

    static class Employee {
        // 用户的id
        private final Integer id;
        // 用户的姓名
        private final String name;
        // 用户的年龄
        private final int age;
        // 用户的部门，例如"技术部"/"市场部"
        private final String department;

        Employee(Integer id, String name, int age, String department) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Employee person = (Employee) o;
            return Objects.equals(id, person.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
