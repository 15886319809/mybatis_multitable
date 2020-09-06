package com.lagou.mapper;

import com.lagou.pojo.User;
import org.apache.ibatis.annotations.*;

import org.mybatis.caches.redis.RedisCache;

import java.util.List;
@CacheNamespace(implementation = RedisCache.class)
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "orders",column = "id",many = @Many(select = "com.lagou.mapper.OrderMapper.findOrderByUid"))
    })
    public List<User>findAllUser();

    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.lagou.mapper.IRoleMapper.findAllOrderByUid"))
    })
    public List<User>findAllUserAndRole();

    @Insert("insert into user values (#{id},#{username})")
    public void addUser(User user);

    @Update("update user set username=#{username} where id=#{id}")
    public void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);

    @Select("select * from user")
    public List<User>findUser();


    @Select("select * from user where id=#{id}")
    public User findUserById(Integer id);
}
