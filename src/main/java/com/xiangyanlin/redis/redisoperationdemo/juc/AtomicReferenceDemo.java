package com.xiangyanlin.redis.redisoperationdemo.juc;

import com.xiangyanlin.redis.redisoperationdemo.model.User;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author XiangYanLin.
 * @date 2021/1/7
 * 原子应用类型使用demo
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zhangSan=new User("1","zhangSan");
        User liSi=new User("2","liSi");
        // 创建原子引用包装类
        AtomicReference<User> atomicReference = new AtomicReference<>();

        // 现在主物理内存的共享变量，为zhangSan
        atomicReference.set(zhangSan);

        // 比较并交换，如果现在主物理内存的值为zhangSan，那么交换成liSi
        System.out.println(atomicReference.compareAndSet(zhangSan, liSi)
                + "\t " + atomicReference.get().toString());

        // 比较并交换，现在主物理内存的值是liSi了，但是预期为zhangSan，因此交换失败
        System.out.println(atomicReference.compareAndSet(zhangSan, liSi)
                + "\t " + atomicReference.get().toString());
    }
}
