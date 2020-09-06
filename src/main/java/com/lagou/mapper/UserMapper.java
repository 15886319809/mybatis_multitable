package com.lagou.mapper;

import com.lagou.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User>findAllUser();

    public List<User>findAllUserAndRole();
}
