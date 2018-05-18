package com.example.libowen.annotationdemo;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by libowen on 18-5-18.
 */

public class BindClick {

    public static void bindOnClick(Activity obj){
        Class<?> cls = obj.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(BindOnClick.class)){
                BindOnClick bindOnClick = method.getAnnotation(BindOnClick.class);
                int[] ids = bindOnClick.value();
                for (int i = 0; i < ids.length; i++){
                    View view = obj.findViewById(ids[i]);
                    view.setOnClickListener( v ->{
                        try {
                            method.setAccessible(true);
                            method.invoke(obj,view);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
    }
}
