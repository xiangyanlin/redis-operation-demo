package com.xiangyanlin.redis.redisoperationdemo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XiangYanLin.
 * @date 2020/12/16
 */
@Data
public class TestEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
}
