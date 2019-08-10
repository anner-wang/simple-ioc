package com.fr.swift.beans.annotation.process;

import com.fr.swift.beans.factory.SwiftBeanDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anner
 * @this class created on date 2019/8/8
 * @description
 */
public class AnntationProcesserContext {
    private final static AnntationProcesserContext INSTANCE = new AnntationProcesserContext();

    private List<BeanProcesser> processers = new ArrayList<>();


    private AnntationProcesserContext() {
        // TODO: 2019/8/9  processers 动态绑定
        processers.add(new SwiftScopeProcesser());
        processers.add(new SwiftAutowiredProcesser());
        processers.add(new SwiftInitProcesser());
        processers.add(new SwiftDestroyProcesser());
    }

    public static AnntationProcesserContext getInstance() {
        return INSTANCE;
    }

    public void process(SwiftBeanDefinition beanDefinition) {
        for (BeanProcesser processer : processers) {
            processer.process(beanDefinition);
        }
    }
}
