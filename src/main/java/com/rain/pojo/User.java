package com.rain.pojo;

import java.util.List;

/**
 * @author rain
 * created on 2018/3/22
 */
public class User {
    private Integer id;
    private String name;
    private List<Order> orders;
    public User() {}

    public User(Integer id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}