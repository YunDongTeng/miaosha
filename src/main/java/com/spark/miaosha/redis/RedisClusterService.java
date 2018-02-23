package com.spark.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * Created by admin on 2018/2/7.
 */
@Service
public class RedisClusterService {

    @Autowired
    private JedisCluster jedisCluster;

    public <T> T get(Prefix prefix, String key, Class<T> clazz) {

        String redisKey = prefix.getPrefix() + key;
        String value = jedisCluster.get(redisKey);

        T t = stringToBean(value, clazz);
        return t;

    }

    public <T> boolean set(Prefix prefix, String key, T value) {
        int expire = prefix.getExpire();
        String result;
        String redisKey = prefix.getPrefix() + key;
        String tempValue = beanToString(value);
        if (expire == 0) {
            result = jedisCluster.set(redisKey, tempValue);
        } else {
            result = jedisCluster.setex(redisKey, expire, tempValue);
        }
        if (result == null) {
            return false;
        }
        return true;
    }


    public static <T> String beanToString(T value) {

        if (value == null) {
            return null;
        } else if (value.getClass() == int.class || value.getClass() == Integer.class) {
            return String.valueOf(value);
        } else if (value.getClass() == String.class) {
            return value + "";
        } else if (value.getClass() == long.class || value.getClass() == Long.class) {
            return String.valueOf(value);
        }
        return JSON.toJSONString(value);
    }

    public static <T> T stringToBean(String value, Class<T> clazz) {

        if (value == null || value.length() == 0 || clazz == null) {
            return null;
        } else if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(value);
        } else if (clazz == String.class) {
            return (T) (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) String.valueOf(clazz);
        }
        return JSON.toJavaObject((JSON) JSON.parse(value), clazz);
    }
}
