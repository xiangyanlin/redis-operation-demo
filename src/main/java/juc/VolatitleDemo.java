package juc;

/**
 * @author XiangYanLin
 * @date 2020/12/28
 */
public class VolatitleDemo {


    public static void main(String[] args) {
        testVisibility();
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
