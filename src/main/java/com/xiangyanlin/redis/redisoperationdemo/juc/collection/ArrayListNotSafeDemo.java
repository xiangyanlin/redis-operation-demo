package com.xiangyanlin.redis.redisoperationdemo.juc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author XiangYanLin.
 * @date 2021/1/7
 */
public class ArrayListNotSafeDemo {
    public static void main(String[] args) {

        Map<String,Object> map=new HashMap<>(16);

//        List<String> list= Arrays.asList("1","2","3");
//        list.forEach(System.out::println);
      //  List<String> list=new ArrayList<>(10);
        //List list= Collections.synchronizedList(new ArrayList<>(10));
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();


        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        list.get(0);



    }
}
