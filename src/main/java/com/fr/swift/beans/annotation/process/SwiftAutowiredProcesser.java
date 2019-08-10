package com.fr.swift.beans.annotation.process;

import com.fr.swift.SwiftContext;
import com.fr.swift.beans.annotation.SwiftAutoWired;
import com.fr.swift.beans.annotation.SwiftQualilifer;
import com.fr.swift.beans.annotation.handler.AnnotationHandlerContext;
import com.fr.swift.beans.annotation.handler.SwiftAutowiredHandler;
import com.fr.swift.beans.exception.NoSuchBeanException;
import com.fr.swift.beans.exception.SwiftBeanException;
import com.fr.swift.beans.factory.SwiftBeanDefinition;

import java.lang.reflect.Field;

/**
 * @author anner
 * @this class created on date 2019/8/8
 * @description autoWired初始化
 */
public class SwiftAutowiredProcesser implements BeanProcesser {
    @Override
    public void process(SwiftBeanDefinition beanDefinition) {
        SwiftAutoWired autoWired = beanDefinition.getClazz().getAnnotation(SwiftAutoWired.class);
        if (autoWired != null) {
            //判断注解在属性上的位置
            Field[] fields = beanDefinition.getClazz().getFields();
            for (Field field : fields) {
                SwiftAutoWired target = field.getAnnotation(SwiftAutoWired.class);
                if (target != null) {
                    //判断注解对象是否被托管
                    try {
                        SwiftContext.get().getBean(field.getClass());
                    } catch (NoSuchBeanException noSuchBeanException) {
                        //bean不存在,直接结束
                        throw noSuchBeanException;
                    } catch (SwiftBeanException swiftBeanException) {
                        //存在多个bean，判断注解SwiftQualilifer是否存在
                        if (field.getAnnotation(SwiftQualilifer.class) != null) {
                            beanDefinition.getAutowiredClassList().add(field.getClass());
                        } else {
                            throw swiftBeanException;
                        }
                    }
                }
            }
            //目标类存在注解对象
            if (beanDefinition.getAutowiredClassList().size() > 0) {
                beanDefinition.setAutoWired(true);
                //绑定handler
                AnnotationHandlerContext.getInstance().addstartHandler(new SwiftAutowiredHandler());
            }
        }
    }

}
