package com.xiangyanlin.redis.redisoperationdemo.juc;

import com.xiangyanlin.redis.redisoperationdemo.juc.model.Ticket;

/**
 * @author XiangYanLin
 * @date 2021/1/13
 * 买票
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{
            for (int i = 1; i <= 40; i++) {
            ticket.sale();
        }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 40; i++) {
            ticket.sale();
        }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <= 40; i++) {
            ticket.sale();
        }
        },"C").start();
    }
}
