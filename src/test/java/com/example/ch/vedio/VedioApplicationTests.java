package com.example.ch.vedio;

import com.example.ch.vedio.demos.web.mapper.VedioMapper;
import com.example.ch.vedio.demos.web.service.Base58Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
class VedioApplicationTests {
    @Autowired
    public VedioMapper vedioMapper;
    @Autowired
    public Base58Util base58Util;

    @Test
    void contextLoads() {
        System.out.println(vedioMapper.findId());
        System.out.println(Base64.getEncoder().encodeToString("10".getBytes()));
    }
    @Test
    void test1() {
        vedioMapper.update(1,base58Util.base58Encode(1));
    }


}
