package com.xiangyanlin.redis.redisoperationdemo.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XiangYanLin.
 * @date 2021/1/5
 */
public class CASDemo {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        /**
         * 一个是期望值，一个是更新值，但期望值和原来的值相同时，才能够更改
         * 假设三秒前，我拿的是5，也就是expect为5，然后我需要更新成 2019
         */
        System.out.println(
                atomicInteger.compareAndSet(5, 2019)
                        + "\t current data: " + atomicInteger.get());

        System.out.println(
                atomicInteger.compareAndSet(5, 1024)
                        + "\t current data: " + atomicInteger.get());
    }
}
