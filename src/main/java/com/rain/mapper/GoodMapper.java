package com.rain.mapper;

import com.rain.pojo.Good;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * @author rain
 * created on 2018/3/22
 */
public interface GoodMapper {
    /**
     * 根据主键获取用户信息
     * @param id 主键编号
     * @return 用户信息
     */
    @Results(id = "good", value = {
            @Result(id = true, property = "goodId", column = "good_id", jdbcType = JdbcType.INTEGER),
            @Result(property = "goodName", column = "good_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "price", column = "price", jdbcType = JdbcType.DECIMAL)
    })
    @Select("SELECT good_id, goog_name as good_name, price FROM tab_good where good_id = #{id}")
    Good queryGoodByGoodId(Integer id);
}