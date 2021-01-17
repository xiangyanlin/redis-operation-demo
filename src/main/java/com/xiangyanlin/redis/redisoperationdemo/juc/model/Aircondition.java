package com.xiangyanlin.redis.redisoperationdemo.juc.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XiangYanLin
 * @date 2021/1/15
 */
public class  Aircondition {
    private int number=0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public  void increment () throws InterruptedException {
        lock.lock();
        try {
            while (number != 0){
                condition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3通知
        condition.signalAll();
    }

    public  void decrement() throws Exception{
        //1.判断
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        //2.干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3通知
        condition.signalAll();
    }

    /*    public synchronized void increment () throws InterruptedException {
        //1.判断
        while (number != 0){
            this.wait();
        }
        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception{
        //1.判断
        while (number == 0){
            this.wait();
        }
        //2.干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3通知
        this.notifyAll();
    }*/
}
