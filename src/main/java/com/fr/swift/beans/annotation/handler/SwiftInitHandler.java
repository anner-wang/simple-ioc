package com.fr.swift.beans.annotation.handler;

import com.fr.swift.beans.annotation.SwiftInitMethod;
import com.fr.swift.beans.factory.SwiftBeanDefinition;
import com.fr.swift.log.SwiftLoggers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author anner
 * @this class created on date 2019/8/9
 * @description init注解的解析
 */
public class SwiftInitHandler implements BeanHandler {

    @Override
    public void handle(Object object, Class<?> clazz) {
        if (object != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                SwiftInitMethod initMethod = method.getAnnotation(SwiftInitMethod.class);
                if (initMethod != null) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        SwiftLoggers.getLogger().debug(e);
                    } catch (InvocationTargetException e) {
                        SwiftLoggers.getLogger().debug(e);
                    }
                }
            }
        }
    }
}
