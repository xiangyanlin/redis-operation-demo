package com.xiangyanlin.redis.redisoperationdemo.juc;

import com.xiangyanlin.redis.redisoperationdemo.juc.model.ShareResource;

/**
 * @author XiangYanLin
 * @date 2021/1/17
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print(shareResource.c1,shareResource.c2,5,2,1);
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print(shareResource.c2,shareResource.c3,10,3,2);
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print(shareResource.c3,shareResource.c1,15,1,3);
            }
        },"C").start();
    }
}
