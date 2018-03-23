package com.rain.service;

import com.rain.mapper.GoodMapper;
import com.rain.pojo.Good;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author rain
 * created on 2018/3/23
 */
@Service(value = "goodService")
public class GoodService {
    @Resource(name = "goodMapper")
    private GoodMapper goodMapper;

    /**
     * 根据商品主键查询商品
     * @param id 商品主键
     * @return 商品详情
     */
    public Good queryGoodByGoodId(Integer id) {
        return goodMapper.queryGoodByGoodId(id);
    }
}