package com.example.service;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.webservicesoap.birthday.GetAgeResponse;
import org.webservicesoap.birthday.GetBirthdayRequest;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Service
public class BirthdayService {

    public GetAgeResponse age(GetBirthdayRequest request){
        GetAgeResponse response= new GetAgeResponse();
        if(validateDay(request) && validateMonth(request) && validateYear(request)){
            response.setAge(getAge(request.getDay(),request.getMonth(),request.getYear()));
        }
        return response;
    }

    public boolean validateDay(GetBirthdayRequest request){
         return request.getDay() > 0 && request.getDay()<=31;
    }
    public boolean validateMonth(GetBirthdayRequest request){
        return request.getMonth() > 0 && request.getMonth()<=12;
    }
    public boolean validateYear(GetBirthdayRequest request){
        return request.getYear() >1920 && request.getYear() <= LocalDate.now().getYear();
    }

    public  int getAge(int day, int month, int year){
        LocalDate today= LocalDate.now();
        LocalDate birthday = LocalDate.of(year,month,day);
        Period period=Period.between(birthday,today);
       return period.getYears();
    }

}
