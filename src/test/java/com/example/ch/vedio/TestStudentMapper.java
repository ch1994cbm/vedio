package com.example.ch.vedio;

import com.example.ch.vedio.demos.web.dto.Play;
import com.example.ch.vedio.demos.web.dto.Student;
import com.example.ch.vedio.demos.web.dto.Vedio;
import com.example.ch.vedio.demos.web.mapper.PlayMapper;
import com.example.ch.vedio.demos.web.mapper.StudentMapper;
import com.example.ch.vedio.demos.web.mapper.VedioMapper;
import com.example.ch.vedio.demos.web.service.Base58Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
public class TestStudentMapper {
    @Autowired
    public StudentMapper studentMapper;
    @Autowired
    public VedioMapper vedioMapper;
    @Autowired
    public PlayMapper playMapper;
    @Autowired
    public Base58Util base58Util;
    @Test
    public void test1(){
        List<Student> studentList = studentMapper.findAll();
        for(Student stu:studentList){
            System.out.println(stu.getId() + "," + stu.getName());
        }
    }

    @Test
    public void test2(){
        Student student = studentMapper.findById(1);
        System.out.println(student.getId() + "," + student.getName());
    }

    @Test
    public void test3(){
        int va = studentMapper.addStu(5,"陈浩");
        System.out.println(va);
    }

    @Test
    public void test4(){
        int va = studentMapper.addStuBak(new Student(6,"陈浩1"));
        System.out.println(va);
    }

    @Test
    public void test5(){
        int va = studentMapper.update(new Student(6,"陈浩3"));
        System.out.println(va);
    }

    @Test
    public void test6(){
        Vedio va = vedioMapper.findByBv("1");
        System.out.println(va.toString());
    }

    @Test
    public void test7(){
        List<Play> va = playMapper.findByBv("1");
        System.out.println(va.toString());
    }
    @Test
    public void test8() {
        Play a = new Play("P1","试试", LocalTime.parse("13:23:32"),"55.mp4");
        playMapper.insert("bvMQ==",a );
    }
}
