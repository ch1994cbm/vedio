package com.example.ch.vedio.demos.web.mapper;

import com.example.ch.vedio.demos.web.dto.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> findAll();
    @Select("select * from student where id=#{id}")
    Student findById(int id);
    @Insert("insert into student(id,name) values(#{id},#{name})")
    int addStu(@Param("id") int id, @Param("name") String name);
    @Insert("insert into student(id,name) values(#{id},#{name})")
    int addStuBak(Student student);
    @Update("update student set name=#{name} where id = #{id}")
    int update(Student student);
    @Update("delete from student where id = #{id}")
    int delete(int id);
}
