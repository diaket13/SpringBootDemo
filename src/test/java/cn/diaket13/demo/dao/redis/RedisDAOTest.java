package cn.diaket13.demo.dao.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDAOTest {
    @Test
    public void contextLoads(){

    }
    @Autowired
    RedisDAO redisDAO;
    @Test
    public void test(){
        redisDAO.set("demoTest","要你命三千",60);
        System.out.println(redisDAO.get("demoTest"));
    }
}