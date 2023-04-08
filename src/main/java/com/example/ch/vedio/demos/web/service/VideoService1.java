package com.example.ch.vedio.demos.web.service;

import com.example.ch.vedio.demos.web.dto.Play;
import com.example.ch.vedio.demos.web.dto.Vedio;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 视频逻辑类
 */
@Service
public class VideoService1 {
    private static final String DH = ",";
    private static final String XHX = "_";
    private static final String CSV = ".csv";
    private static final String DZ = "e:\\\\helloword\\\\vedio\\\\src\\\\main\\\\resources\\\\static\\\\v_";
    private static final String PH = "e:\\helloword\\vedio\\src\\main\\resources\\static\\p.csv";
    public List<Vedio> vedioList = new ArrayList<Vedio>();
    public Map<String, Vedio> vedioMap = new HashMap<String, Vedio>();

    public VideoService1() {
        System.out.println("启动3");
    }

    @PostConstruct
    public void init() {//初始化方法
        System.out.println("启动4");
        try {
            List<String> arr = Files.readAllLines(Paths.get(PH));
            for (String line : arr) {
                String[] s = line.split(DH);
                vedioMap.put(s[0], new Vedio(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(s[7].split(XHX).toString()), getPlayList(s[0])));
                vedioList.add(new Vedio(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(s[7].split(XHX)), getPlayList(s[0])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Vedio find(String dv) {
        return vedioMap.get(dv);
    }

    /**
     * 获取选集列表
     *
     * @param dv
     * @return
     * @throws IOException
     */
    private List<Play> getPlayList(String dv) {
        try {
            //读取选集
            StringBuilder sb = new StringBuilder();
            sb.append(DZ).append(dv).append(CSV);
            List<String> arrXj = Files.readAllLines(Paths.get(sb.toString()));
            List<Play> playList = new ArrayList<Play>();
            for (String lineX : arrXj) {
                String[] ss = lineX.split(DH);
                playList.add(new Play(ss[0], ss[1], LocalTime.parse(ss[3]), ss[2]));
            }
            return playList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
