package com.xiangyanlin.redis.redisoperationdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author XiangYanLin.
 * @date 2020/12/22
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1153459461508706840L;
    private String id;
    private String userName;
}
