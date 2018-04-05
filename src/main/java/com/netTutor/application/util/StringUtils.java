package com.netTutor.application.util;

import com.netTutor.application.domain.UserEntity;
import org.springframework.stereotype.Component;
import sun.reflect.Reflection;

import java.lang.reflect.Field;


public class StringUtils {

    public static String trimString(UserEntity obj,Class aClass ,String untrimStr){

        try {
            Class<?> clazz  = obj.getClass();
            System.out.println(clazz.getField("username"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        return untrimStr.trim();
    }

    public static void main(String[] args){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(" mohit ");
        StringUtils.trimString(userEntity,UserEntity.class,userEntity.getUsername());
    }
}
