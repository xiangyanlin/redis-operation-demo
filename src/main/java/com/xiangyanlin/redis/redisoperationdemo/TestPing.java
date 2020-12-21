package com.xiangyanlin.redis.redisoperationdemo;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author XiangYanLin
 * @Date 2020/12/21 21:22
 * @Description：
 */
public class TestPing {
    private static ShardedJedisPool pool;


    public static void main(String[] args) {
        Jedis jedis=new Jedis("115.29.173.51", 6379);
        jedis.auth("123456");
        String response = jedis.ping();
        System.out.println(response); // PONG
    }
}
