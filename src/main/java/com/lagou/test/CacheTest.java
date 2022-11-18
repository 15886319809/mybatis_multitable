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

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
https://goerli.etherscan.io/address/0x3c0c0d5e4ce41cf55a24d3fd740b6723ea201fdb
public class CacheTest {

    private UserMapper userMapper;
    private SqlSession sqlSession;
    private OrderMapper orderMapper;
    private SqlSessionFactory build;
    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = build.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void firstLevelCache(){
        User userById = userMapper.findUserById(1);

//        User user = new User();
//        user.setId(1);
//        user.setUsername("jack");
//        userMapper.updateUser(user);
//        sqlSession.commit();

        Orders orders = new Orders();
        orders.setId(5);
        orders.setTotal(12.0);
        orderMapper.addOrders(orders);
        sqlSession.commit();
//        手动刷新一级缓存
        /*sqlSession.clearCache();*/

        User userById1 = userMapper.findUserById(1);
        System.out.println(userById == userById1);
    }

    @Test
    public void secondLevelCache(){
        SqlSession sqlSession1 = build.openSession();
        SqlSession sqlSession2 = build.openSession();
        SqlSession sqlSession3 = build.openSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        User userById = mapper1.findUserById(1);
        sqlSession1.close();
        User userById1 = mapper2.findUserById(1);
        System.out.println(userById == userById1);

//        User user = new User();
//        user.setId(1);
//        user.setUsername("jack");
//        mapper3.updateUser(user);
        User userById2 = mapper2.findUserById(1);
        System.out.println(userById2);
    }
}
