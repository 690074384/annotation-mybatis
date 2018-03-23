package com.rain.mapper;

import com.rain.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * @author rain
 * created on 2018/3/22
 */
public interface UserMapper {

    /**
     * 根据主键获取用户信息
     * @param id 主键编号
     * @return 用户信息
     */
    @Results(id = "user", value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR)
    })
    @Select("SELECT id, name FROM tab_user where id = #{id}")
    User queryUserByUserId(Integer id);

    /**
     * 查询某用户的所有订单信息
     * @param id 用户主键
     * @return 订单列表
     */
    @Results(id = "queryOrderOfTheUser", value = {
            @Result(property = "orders", column = "id", many = @Many(select = "com.rain.mapper.OrderMapper.queryOrdersOfTheUser"))
    })
    @Select("SELECT id, name from tab_user where id = #{id}")
    User queryOrdersOfTheUser(Integer id);
}