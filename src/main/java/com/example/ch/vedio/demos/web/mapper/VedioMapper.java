package com.example.ch.vedio.demos.web.mapper;

import com.example.ch.vedio.demos.web.dto.Vedio;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VedioMapper {
    @Select("SELECT bv, type, category, title, cover, introduction, publish_time, tags FROM video WHERE bv=#{bv}")
    Vedio findByBv(String bv);
    @Insert("INSERT INTO video(type, category, title, cover, introduction, publish_time, tags) VALUES" +
            "(#{type}, #{category}, #{title}, #{cover}, #{introduction}, #{publishTime}, #{tags})")
    void insert(Vedio e);

    @Select("select last_insert_id()")
    int findId();
    @Update("update video set bv=#{bv} where id=#{id}")
    void update(@Param("id") int id,@Param("bv") String bv);
}
