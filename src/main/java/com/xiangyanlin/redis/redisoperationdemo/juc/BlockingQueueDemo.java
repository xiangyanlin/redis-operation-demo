package com.xiangyanlin.redis.redisoperationdemo.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/1/18
 */
public class BlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

      /*  System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));*/
        //System.out.println(blockingQueue.add("x"));
//        System.out.println(blockingQueue.element());
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x"));
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
        //blockingQueue.put("x");
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("x",3L, TimeUnit.SECONDS));

    }


}
