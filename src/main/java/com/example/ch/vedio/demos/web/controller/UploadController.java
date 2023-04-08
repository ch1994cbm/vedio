package com.example.ch.vedio.demos.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class UploadController {
    private static final String PART = ".part";
    @Value("${video-path}")
    private String videoPath;
    @RequestMapping("/upload")
    public Map<String, String> uploadSp(int i, int chunks, MultipartFile data, String url) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put(url, (i * 100.0 / chunks + "%"));
        String path = videoPath + url + PART + i;
        data.transferTo(Paths.get(path));
        return map;
    }
    @RequestMapping("/finish")
    public void finish(int chunks,String url) throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(videoPath + url);
            for(int i=1;i<=chunks;i++){
                Path path = Paths.get(videoPath + url + PART + i);
                Files.copy(path,os);
                path.toFile().delete();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            os.close();
        }
    }

    @RequestMapping("/uploadCover")
    public Map<String,String> uploadCover(MultipartFile data,String cover) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        String path = videoPath + cover;
        data.transferTo(Paths.get(path));
        map.put("cover",cover);
        return map;
    }
}
