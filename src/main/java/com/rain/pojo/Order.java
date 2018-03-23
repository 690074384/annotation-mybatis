package com.rain.pojo;

/**
 * @author rain
 * created on 2018/3/22
 */
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer goodId;
    private User user;
    private Good good;
    public Order() {}

    public Order(Integer orderId, Integer userId, Integer goodId, User user, Good good) {
        this.orderId = orderId;
        this.userId = userId;
        this.goodId = goodId;
        this.user = user;
        this.good = good;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", goodId=" + goodId +
                ", user=" + user +
                ", good=" + good +
                '}';
    }
}