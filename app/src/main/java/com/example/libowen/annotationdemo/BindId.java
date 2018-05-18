package com.example.libowen.annotationdemo;

import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by libowen on 18-5-18.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE})
public @interface BindId {
    int value() default View.NO_ID;
}
