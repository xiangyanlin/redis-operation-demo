package com.xiangyanlin.redis.redisoperationdemo.juc;

import com.xiangyanlin.redis.redisoperationdemo.juc.model.MyCache;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/1/18
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache =new MyCache();
        for (int i = 1; i <=5 ; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <=5 ; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }

    }
}
