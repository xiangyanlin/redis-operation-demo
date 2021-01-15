package com.xiangyanlin.redis.redisoperationdemo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XiangYanLin
 * @date 2020/12/28
 */
public class TestVolatitleData {
      volatile  int number=0;

    public void addTo60(){
        this.number=60;
    }

    /**
     *自增
     */
    public  void increment() {
        number ++;
    }

    AtomicInteger atomicInteger=new AtomicInteger(0);

    public void addAtomic() {
        // 相当于 atomicInter ++
        //自旋锁
        atomicInteger.getAndIncrement();

    }
}
