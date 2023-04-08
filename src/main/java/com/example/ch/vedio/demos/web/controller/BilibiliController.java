package com.example.ch.vedio.demos.web.controller;

import com.example.ch.vedio.demos.web.dto.Vedio;
import com.example.ch.vedio.demos.web.service.VideoService1;
import com.example.ch.vedio.demos.web.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class BilibiliController {
    @Autowired
    VideoService1 videoService1;
    @Autowired
    VideoService2 videoService2;

    /**
     * 路径参数
     * 1.@RequestMapping("/video/{id}")
     * 2.
     *
     * @param id
     * @return
     */
    @RequestMapping("/video/{id}")
    public Vedio t1(@PathVariable String id) throws IOException {
        return videoService2.find(id);
    }
    @RequestMapping("/publish")
    public Map<String,String> publish(@RequestBody Vedio vedio){
        Map<String,String> map = new HashMap<>();
        map.put("bv",videoService2.publish(vedio));
        return map;
    }
}

