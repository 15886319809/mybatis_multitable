package com.lagou.test;

import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.Orders;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {

    @Test
    public void testFindUserAndOrders() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> userAndOrder = mapper.findUserAndOrder();
        for (Orders orders : userAndOrder) {
            System.out.println(orders);
        }
    }

    @Test
    public void testFindAllUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindAllUserAndRole() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUserAndRole = mapper.findAllUserAndRole();
        for (User user : allUserAndRole) {
            System.out.println(user);
        }
    }

}
