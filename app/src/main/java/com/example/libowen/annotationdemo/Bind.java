package com.example.libowen.annotationdemo;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by libowen on 18-5-18.
 */

public class Bind {

    public static void bindId(Activity obj){
        Class<?> clz = obj.getClass();
        //使用反射调用setContentView
        if (clz.isAnnotationPresent(BindId.class)){
            try {
                BindId bId = clz.getAnnotation(BindId.class);
                int id = bId.value();
                Method m = clz.getMethod("setContentView", int.class);
                m.setAccessible(true);
                m.invoke(obj,id);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        //findViewById
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(BindId.class)){
                BindId bindId = field.getAnnotation(BindId.class);
                int id = bindId.value();

                try {
                    Method method = clz.getMethod("findViewById", int.class);
                    method.setAccessible(true);
                    Object view = method.invoke(obj,id);
                    field.setAccessible(true);
                    field.set(obj, view);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
