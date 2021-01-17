package com.xiangyanlin.redis.redisoperationdemo.juc.model;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/1/17
 * 普通方法对象锁，static类锁
 * 手机
 */
public class Phone {
    public  static synchronized void sendEmail() throws Exception{
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("*******sendEmail");
    }
    public  synchronized void sendMs() throws Exception{
        //TimeUnit.SECONDS.sleep(2);
        System.out.println("*******sendMs");
    }
    public  void sayHello() throws Exception{
        TimeUnit.SECONDS.sleep(3);
        System.out.println("*****sayHello");
    }
}
