package com.spark.miaosha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2018/2/7.
 */
@Configuration
public class RedisClusterConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return jedisPoolConfig;
    }


    @Bean
    public JedisCluster jedisClusterFactory(){

        Set<HostAndPort> nodes = new HashSet<HostAndPort>();

        nodes.add(new HostAndPort("192.168.15.31",6001));
        nodes.add(new HostAndPort("192.168.15.31",6002));
        nodes.add(new HostAndPort("192.168.15.31",6003));
        nodes.add(new HostAndPort("192.168.15.38",6004));
        nodes.add(new HostAndPort("192.168.15.38",6005));
        nodes.add(new HostAndPort("192.168.15.38",6006));

        JedisCluster jedisCluster = new JedisCluster(nodes);

        return jedisCluster;

    }

    /*@Bean
    public RedisClusterConfiguration redisClusterConfiguration(){

        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        configuration.addClusterNode(new RedisNode("192.168.15.31",6001));
        configuration.addClusterNode(new RedisNode("192.168.15.31",6002));
        configuration.addClusterNode(new RedisNode("192.168.15.31",6003));
        configuration.addClusterNode(new RedisNode("192.168.15.38",6004));
        configuration.addClusterNode(new RedisNode("192.168.15.38",6005));
        configuration.addClusterNode(new RedisNode("192.168.15.38",6006));

        return configuration;

    }*/

   /* @Bean("redisClusterConfiguration")
    public RedisSentinelConfiguration redisClusterConfiguration(){

        List<RedisNode> nodes = new ArrayList<RedisNode>();

        nodes.add(new RedisNode("192.168.15.31",6001));
        nodes.add(new RedisNode("192.168.15.31",6002));
        nodes.add(new RedisNode("192.168.15.31",6003));
        nodes.add(new RedisNode("192.168.15.38",6004));
        nodes.add(new RedisNode("192.168.15.38",6005));
        nodes.add(new RedisNode("192.168.15.38",6006));

        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        redisSentinelConfiguration.setSentinels(nodes);

        return redisSentinelConfiguration;
    }

    @Bean("jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration());
        return jedisConnectionFactory;
    }
*/



}
