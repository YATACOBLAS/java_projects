package com.repositorio;

import com.howtodoinjava.xml.school.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepository {

    private Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData(){
        Student s = new Student();
        s.setName("Andres");
        s.setAddress("Av. Magnolias");
        s.setStandard(4);
        students.put(s.getName(),s);
        s= new Student();
        s.setName("Maria");
        s.setAddress("Av. Rosales 1234-23");
        s.setStandard(1);
        students.put(s.getName(),s);

        s = new Student();
        s.setName("Lokesh");
        s.setStandard(6);
        s.setAddress("Delhi");
        students.put(s.getName(), s);

        s = new Student();
        s.setName("Sukesh");
        s.setStandard(7);
        s.setAddress("Noida");
        students.put(s.getName(), s);

    }

    public Student findStudent(String name){
        Assert.isNull(name,"The Student´s name must not be null");
       return students.get(name);
    }

}
