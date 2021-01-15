package com.xiangyanlin.redis.redisoperationdemo.juc.model;

/**
 * @author XiangYanLin
 * @date 2021/1/15
 */
public class  Aircondition {
    private int number=0;

    public void increment (){
        number++;
    }

    public void  decrement(){
        number--;
    }
}
