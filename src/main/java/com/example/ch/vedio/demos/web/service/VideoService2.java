package com.example.ch.vedio.demos.web.service;

import com.example.ch.vedio.demos.web.dto.Play;
import com.example.ch.vedio.demos.web.dto.Vedio;
import com.example.ch.vedio.demos.web.mapper.PlayMapper;
import com.example.ch.vedio.demos.web.mapper.VedioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 视频逻辑类
 */
@Service
public class VideoService2 {
    @Autowired
    public VedioMapper vedioMapper;
    @Autowired
    public PlayMapper playMapper;

    /**
     * 查询视频
     * @param bv
     * @return
     */
    public Vedio find(String bv) {
        Vedio vedio = vedioMapper.findByBv(bv);
        if (vedio == null) {
            return null;
        }
        List<Play> playList = playMapper.findByBv(bv);
        vedio.setPlayList(playList);
        return vedio;
    }

    /**
     * 发布视频
     * @param vedio
     */
    public String publish(Vedio vedio){
        vedio.setPublishTime(LocalDateTime.now());
        //1插入数据
        vedioMapper.insert(vedio);
        //2生成bv号
        int id = vedioMapper.findId();
        String bv = Base58Util.getBase64EnCoder(String.valueOf(id));
        //3更新bv号
        vedioMapper.update(id,bv);
        //4插入选集
        for(Play play:vedio.getPlayList()){
            playMapper.insert(bv,play);
        }
        return bv;
    }
}
