package com.xiangyanlin.redis.redisoperationdemo.juc.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author XiangYanLin
 * @date 2021/1/11
 * HashSet线程不安全
 */
public class HashSetNotSafeDemo {
    public static void main(String[] args) {
          Set<String> set1=new HashSet<>();
        set1.add("111");
        //Set<String> set= Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet();


        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
