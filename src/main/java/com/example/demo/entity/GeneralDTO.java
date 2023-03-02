package com.example.demo.entity;

import java.lang.reflect.Field;
import java.util.List;

public abstract class GeneralDTO {


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("[");
        Field[] fields = getClass().getDeclaredFields();
        try{
            for (Field field: fields){
                field.setAccessible(true);
                sb.append(field.getName()).append("=");
                Object value = field.get(this);
                if (value == null){
                    sb.append("null, ");
                }else if (value instanceof List){
                    sb.append("[");
                    List<?> list = (List<?>) value;
                    for (Object obj : list){
                        sb.append(obj.toString()).append(", ");
                    }
                    sb.append("], " );
                }else {
                    sb.append(value.toString()).append(", ");
                }
            }
        }catch (IllegalAccessException e){
            sb.append("ERROR: ").append(e.getMessage());
        }
        sb.append("]");
        return sb.toString();
    }
}
