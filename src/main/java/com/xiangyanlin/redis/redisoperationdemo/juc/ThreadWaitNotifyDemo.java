package com.xiangyanlin.redis.redisoperationdemo.juc;

import com.xiangyanlin.redis.redisoperationdemo.juc.model.Aircondition;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/1/16
 * 线程通知
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(200);
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(300);
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"B").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(400);
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(500);
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
