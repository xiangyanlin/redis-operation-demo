package com.xiangyanlin.redis.redisoperationdemo.juc;

/**
 * @author XiangYanLin
 * @date 2020/12/28
 */
public class VolatitleDemo {


    public static void main(String[] args) {
        //testVisibility();
        testAtomicity();
    }

    /**
     * 测试原子性
     * 最后输出最后不是20000，没有最终一致性
     */
    public static void testAtomicity(){
        TestVolatitleData data=new TestVolatitleData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                // 里面
                for (int j = 0; j < 1000; j++) {
                    data.increment();
                    data.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while(Thread.activeCount() > 2) {
            // yield表示不执行
            Thread.yield();
        }

        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName()
                + "\t finally number value: " + data.number);
        System.out.println(Thread.currentThread().getName()
                + "\t finally atomicNumber value: " + data.atomicInteger);
    }

    /**
     * 可见性验证
     * data.numner 加volatitle前后的结果
     */
    public static void testVisibility(){

        TestVolatitleData data=new TestVolatitleData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " coming...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName() + " updated number value:"+data.number);
        },"aaa").start();

        while (data.number == 0) {
            // looping
        }
        System.out.println(Thread.currentThread().getName() + " mission is over... ,number value:"+data.number);

    }
}
