package com.fr.swift.beans.annotation.handler;

import com.fr.swift.beans.annotation.SwiftAutoWired;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author anner
 * @this class created on date 2019/8/9
 * @description
 */
public class SwiftAutowiredHandler implements BeanHandler {
    @Override
    public void handle(Object object, Class<?> clazz) {
        Field[] fields = clazz.getFields();
        //获取autowired注解的对象
        for (Field field : fields) {
            SwiftAutoWired autoWired = field.getAnnotation(SwiftAutoWired.class);
            if (autoWired != null) {
                try {
                    //反射一个新的对象,直接通过默认构造函数构造
                    Object bean=null;
                    Constructor constructor=field.getClass().getConstructor();
                    bean=constructor.newInstance();
                    field.set(object,bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
