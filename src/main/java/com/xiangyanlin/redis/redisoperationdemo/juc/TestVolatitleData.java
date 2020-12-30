package com.xiangyanlin.redis.redisoperationdemo.juc;

/**
 * @author XiangYanLin
 * @date 2020/12/28
 */
public class TestVolatitleData {
    volatile int number=0;

    public void addTo60(){
        this.number=60;
    }


}
