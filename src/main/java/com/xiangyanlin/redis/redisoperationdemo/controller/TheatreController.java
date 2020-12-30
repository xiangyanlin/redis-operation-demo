package com.xiangyanlin.redis.redisoperationdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XiangYanLin.
 * @date 2020/12/30
 * 戏剧团重构demo
 */
@RequestMapping("/theatre")
@Controller
public class TheatreController {

    @RequestMapping("/before")
    public String before(){
        return "theatre-before";
    }

    @RequestMapping("/after")
    public String after(){
        return "theatre-after";
    }

}
