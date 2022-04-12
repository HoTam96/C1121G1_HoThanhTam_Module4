package com.codegym.aspess;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class Acpect {
    private static Integer count = 0;

    @AfterReturning(pointcut = "execution(public * com.codegym.controller.*.*(..))")
    public void LogHistory(JoinPoint joinPoint) {
        count++;
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("số lần truy cập trang wep" + count);
        System.err.println("method name" + methodName);
        System.err.println("Args" + args);


    }

}
