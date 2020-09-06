package com.lagou.mapper;

import com.lagou.pojo.Orders;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "total", column = "total"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "user", column = "uid",javaType = User.class,one = @One(select = "com.lagou.mapper.UserMapper.findUserById"))
    })
    @Select("SELECT * FROM  orders")
    public List<Orders> findUserAndOrder();

    @Select("select * from orders where uid=#{uid}")
    public List<Orders>findOrderByUid(Integer uid);

    @Insert("insert into orders (id,total)values(#{id},#{total})")
    public void addOrders(Orders orders);

}
