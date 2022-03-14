package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {
    // 使用流的方法，把订单处理成ID->订单的映射
    // 例如，传入参数[{id=1,name='肥皂'},{id=2,name='牙刷'}]
    // 返回一个映射{1->Order(1,'肥皂'),2->Order(2,'牙刷')}
    public static Map<Integer, Order> toMap(List<Order> orders) {
        return orders.stream().reduce(new HashMap<>(), (integerOrderHashMap, order) -> {
            integerOrderHashMap.put(order.getId(), order);
            return integerOrderHashMap;
        }, (integerOrderHashMap, integerOrderHashMap2) -> {
            integerOrderHashMap.putAll(integerOrderHashMap2);
            return integerOrderHashMap;
        });
    }

    public static void main(String[] args) {
        System.out.println(toMap(Arrays.asList(new Order(1, "肥皂"), new Order(2, "牙刷"))));
    }

    static class Order {
        private Integer id;
        private String name;

        Order(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
