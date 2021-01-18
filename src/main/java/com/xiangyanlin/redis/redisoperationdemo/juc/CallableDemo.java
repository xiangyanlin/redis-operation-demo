package com.xiangyanlin.redis.redisoperationdemo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/1/18
 * 使用Callable创建线程
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println(Thread.currentThread().getName()+"\t计算完成");
        System.out.println(futureTask.get());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("******come in call method()");
        return 1024;
    }
}

class MyThread3 extends Thread {

    public MyThread3() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }

    }
}