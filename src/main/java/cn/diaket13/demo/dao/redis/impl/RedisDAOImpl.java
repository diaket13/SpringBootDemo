package cn.diaket13.demo.dao.redis.impl;

import cn.diaket13.demo.dao.redis.RedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDAOImpl implements RedisDAO {
    @Autowired
    private StringRedisTemplate template;

    @Override
    public void set(String key, String value, long time) {
        ValueOperations<String,String> ops = template.opsForValue();
        ops.set(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        ValueOperations<String,String> ops = template.opsForValue();
        return ops.get(key);
    }
}
