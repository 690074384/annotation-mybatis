package com.rain.pojo;

/**
 * @@author rain
 * created on 2018/3/22
 */
public class Good {
    private Integer goodId;
    private String goodName;
    private Double price;
    public Good() {}

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", price=" + price +
                '}';
    }
}