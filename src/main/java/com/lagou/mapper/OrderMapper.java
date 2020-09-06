package com.lagou.mapper;

import com.lagou.pojo.Orders;

import java.util.List;

public interface OrderMapper {

    public List<Orders> findUserAndOrder();
}
