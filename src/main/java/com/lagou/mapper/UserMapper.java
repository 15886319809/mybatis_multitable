package com.lagou.mapper;

import com.lagou.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    public List<User>findAllUser();
    public List<User>findAllUserAndRole();

    @Insert("insert into user values (#{id},#{username})")
    public void addUser(User user);

    @Update("update user set username=#{username} where id=#{id}")
    public void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);

    @Select("select * from user")
    public List<User>findUser();
}
