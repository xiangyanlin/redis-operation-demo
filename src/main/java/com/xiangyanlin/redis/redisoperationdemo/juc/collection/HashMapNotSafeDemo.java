package com.xiangyanlin.redis.redisoperationdemo.juc.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XiangYanLin
 * @date 2021/1/11
 */
public class HashMapNotSafeDemo {
    public static void main(String[] args) {
       // Map<String,String> map= new HashMap<>(16);
       // Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>(16));
        ConcurrentHashMap map=new ConcurrentHashMap<>(16);
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();

        }
    }
}
