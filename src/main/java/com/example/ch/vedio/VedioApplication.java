package com.example.ch.vedio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VedioApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        System.out.println("启动1");
        SpringApplication.run(VedioApplication.class, args);
    }

    /**
     * 静态资源映射
     * url路径和磁盘路径做映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("启动2");
        //设置url路径  磁盘路径
        registry.addResourceHandler("/play/**").addResourceLocations("file:"+ videoPath);
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+ imgPath);

    }
    @Value("${video-path}")
    private String videoPath;
    @Value("${img-path}")
    private String imgPath;
}
