package com.xiangyanlin.redis.redisoperationdemo.juc.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XiangYanLin
 * @date 2021/1/13
 * 票
 */
public class Ticket {

    private int number=30;
    Lock lock  = new ReentrantLock();
   public void sale(){
       lock.lock();
       try {
           if (number > 0){
               System.out.println(Thread.currentThread().getName()
                       +"\t卖出第："+(number--)+"\t还剩下："+number);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
   }

}
