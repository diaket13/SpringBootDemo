package cn.diaket13.demo.web;

import cn.diaket13.demo.dao.redis.RedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "redis")
public class RedisController {
    @Autowired
    RedisDAO redisDAO;

    @RequestMapping(value = "{key}",method = RequestMethod.GET)
    public String get(@PathVariable(value = "key") String key){
        return redisDAO.get(key);
    }

    @RequestMapping(value = "{key}",method = RequestMethod.POST)
    public String set(@PathVariable(value = "key") String key, @RequestBody Map<String,String> value){
        System.out.println(value.size());
        String i = value.keySet().iterator().next();
        System.out.println(i);
        redisDAO.set(key,value.get(i),60);
        return "收!";
    }
}
