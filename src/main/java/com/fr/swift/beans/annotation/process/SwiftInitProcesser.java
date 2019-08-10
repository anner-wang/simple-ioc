package com.fr.swift.beans.annotation.process;

import com.fr.swift.beans.annotation.SwiftInitMethod;
import com.fr.swift.beans.annotation.handler.AnnotationHandlerContext;
import com.fr.swift.beans.annotation.handler.SwiftInitHandler;
import com.fr.swift.beans.factory.SwiftBeanDefinition;

import java.lang.reflect.Method;

/**
 * @author anner
 * @this class created on date 2019/8/9
 * @description 初始化init注解
 */
public class SwiftInitProcesser implements BeanProcesser {
    @Override
    public void process(SwiftBeanDefinition beanDefinition) {
        Method[] methods = beanDefinition.getClazz().getMethods();
        for (Method method : methods) {
            SwiftInitMethod initMethod = method.getAnnotation(SwiftInitMethod.class);
            if (initMethod != null) {
                beanDefinition.setInitMethod(method.getName());
                AnnotationHandlerContext.getInstance().addstartHandler(new SwiftInitHandler());
                return;
            }
        }
    }
}