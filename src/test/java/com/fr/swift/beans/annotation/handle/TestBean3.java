package com.fr.swift.beans.annotation.handle;

import com.fr.swift.beans.annotation.SwiftAfter;
import com.fr.swift.beans.annotation.SwiftAspect;
import com.fr.swift.beans.annotation.SwiftBean;
import com.fr.swift.beans.annotation.SwiftBefore;
import com.fr.swift.beans.annotation.SwiftPointCut;
import com.fr.swift.beans.annotation.aop.SwiftJoinPoint;

/**
 * @author anner
 * @this class created on date 2019/8/18
 * @description
 */
@SwiftBean(name = "testBean3")
@SwiftAspect
public class TestBean3 {
    @SwiftPointCut(targets = {"com.fr.swift.beans.annotation.handle.TestBean1.run",
            "com.fr.swift.beans.annotation.handle.TestBean2.run"})
    private void test() {
    }

    @SwiftBefore
    public void before(SwiftJoinPoint joinPoint) {
        System.out.println(joinPoint);
        System.out.println("before");

    }

    @SwiftAfter
    public void after(SwiftJoinPoint joinPoint) {
        System.out.println(joinPoint);
        System.out.println("after");
    }
}
