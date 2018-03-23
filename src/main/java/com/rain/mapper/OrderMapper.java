package com.rain.mapper;

import com.rain.pojo.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author rain
 * created on 2018/3/22
 */
public interface OrderMapper {

    /**
     * 查询所有的订单信息
     * @return 订单列表
     */
    @Results(id = "order", value = {
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "user", column = "user_id", one = @One(select = "com.rain.mapper.UserMapper.queryUserByUserId")),
            @Result(property = "good", column = "good_id", one = @One(select = "com.rain.mapper.GoodMapper.queryGoodByGoodId"))
    })
    @Select("SELECT o.order_id, o.user_id, o.good_id FROM tab_order o")
    List<Order> queryOrdersOfUser();

    /**
     * 查询某人的的订单信息
     * @param userId 用户主键
     * @return 订单列表
     */
    @Results(id = "query", value = {
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "user", column = "user_id", one = @One(select = "com.rain.mapper.UserMapper.queryUserByUserId")),
            @Result(property = "good", column = "good_id", one = @One(select = "com.rain.mapper.GoodMapper.queryGoodByGoodId"))
    })
    @Select("SELECT o.order_id, o.user_id, o.good_id FROM tab_order o where user_id = #{userId}")
    List<Order> queryOrdersOfTheUser(Integer userId);
}