package com.example.ch.vedio.demos.web.mapper;

import com.example.ch.vedio.demos.web.dto.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayMapper {
    @Select("SELECT id, title, duration, url " +
            "FROM play " +
            "WHERE bv=#{bv}")
    List<Play> findByBv(String bv);

    @Insert("INSERT INTO play(bv, id, duration, title, url) VALUES" +
            "(#{bv}, #{p.id}, #{p.duration}, #{p.title}, #{p.url})")
    void insert(@Param("bv") String bv, @Param("p") Play play);
}
