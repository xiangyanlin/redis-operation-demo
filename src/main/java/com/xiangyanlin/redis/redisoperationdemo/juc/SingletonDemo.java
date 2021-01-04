package com.xiangyanlin.redis.redisoperationdemo.juc;

/**
 * 单例模式
 * @author XiangYanLin
 * @date 2021/1/4
 */
public class SingletonDemo {


    private volatile static SingletonDemo instance=null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 构造方法");
    }

    /**
     * 双重检测机制
     * @return SingletonDemo
     */
    public static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <=10; i++) {
            new Thread(() ->{
           SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
