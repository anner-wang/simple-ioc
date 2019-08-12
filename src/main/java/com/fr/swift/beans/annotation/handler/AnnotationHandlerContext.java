package com.fr.swift.beans.annotation.handler;

import java.util.LinkedList;
import java.util.List;

/**
 * @author anner
 * @this class created on date 2019/8/9
 * @description
 */
public class AnnotationHandlerContext {
    private final static AnnotationHandlerContext INSTANCE = new AnnotationHandlerContext();

    private List<BeanHandler> startHandlers = new LinkedList<>();
    private List<BeanHandler> endHandlers = new LinkedList<>();

    private AnnotationHandlerContext() {
    }

    public static AnnotationHandlerContext getInstance() {
        return INSTANCE;
    }

    //绑定初始化handler
    public boolean addstartHandler(BeanHandler beanHandler) {
        return startHandlers.add(beanHandler);
    }

    //绑定销毁handler
    public boolean addendHandler(BeanHandler beanHandler) {
        return endHandlers.add(beanHandler);
    }


    public void startProcess(Object object, Class<?> clazz) {
        for (BeanHandler beanHandler : startHandlers) {
            beanHandler.handle(object, clazz);
        }
    }

    public void endProcess(Object object, Class<?> clazz) {
        for (BeanHandler beanHandler : endHandlers) {
            beanHandler.handle(object, clazz);
        }
    }

}
