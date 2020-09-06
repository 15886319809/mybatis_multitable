package com.lagou.test;

import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.Orders;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
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

    private UserMapper userMapper;
    private OrderMapper orderMapper;
    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("测试数据");
        userMapper.addUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("修改的测试数据");
        userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userMapper.deleteUser(3);
    }

    @Test
    public void testFindUser(){
        List<User> user = userMapper.findUser();
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void oneToone(){
        List<Orders> userAndOrder = orderMapper.findUserAndOrder();
        for (Orders orders : userAndOrder) {
            System.out.println(orders);
        }
    }

    @Test
    public void oneTomany(){
        List<User> allUser = userMapper.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @Test
    public void manyToMany(){
        List<User> allUserAndRole = userMapper.findAllUserAndRole();
        for (User user : allUserAndRole) {
            System.out.println(user);
        }
    }
}
