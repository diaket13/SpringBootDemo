package cn.diaket13.demo.dao.redis;

public interface RedisDAO {
    void set(String key,String value,long time);

    String get(String key);
}
