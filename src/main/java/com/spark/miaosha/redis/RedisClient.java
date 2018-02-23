package com.spark.miaosha.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2018/2/7.
 */
public class RedisClient {

    public static void main(String[] args) {

        JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxWaitMillis(3);
        poolConfig.setMaxIdle(50);
        poolConfig.setMaxTotal(300);
        poolConfig.setMinIdle(5);

        Set<HostAndPort> nodes = new HashSet<HostAndPort>();

        nodes.add(new HostAndPort("192.168.15.31", 6001));
        nodes.add(new HostAndPort("192.168.15.31", 6002));
        nodes.add(new HostAndPort("192.168.15.31", 6003));
        nodes.add(new HostAndPort("192.168.15.38", 6004));
        nodes.add(new HostAndPort("192.168.15.38", 6005));
        nodes.add(new HostAndPort("192.168.15.38", 6006));

        JedisCluster jedisCluster = new JedisCluster(nodes, poolConfig);

        for(int i=0;i<100;i++){
            jedisCluster.set("key-"+i,"value-"+i);
        }

        try {
            jedisCluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
