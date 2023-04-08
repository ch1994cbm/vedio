package com.example.ch.vedio.demos.web.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class Base58Util {
    public String base58Encode(int a){
        return "bv" + getBase64EnCoder(String.valueOf(a));
    }

    /**
     * Base64编码
     * @param str
     * @return
     */
    public static String getBase64EnCoder(String str) {
        // 将源字符串转为byte数组
        byte [] strBytes = str.getBytes();
        // 链式调用,返回结果
        return Base64.getEncoder().encodeToString(strBytes);
    }
}
