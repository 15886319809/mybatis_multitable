package com.lagou.mapper;

import com.lagou.pojo.Orders;
import com.lagou.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleMapper {



    @Select("SELECT * FROM `sys_role` r , sys_user_role ur where r.id=ur.roleid AND ur.userid =#{uid}")
    public List<Role> findAllOrderByUid(Integer uid);
}
