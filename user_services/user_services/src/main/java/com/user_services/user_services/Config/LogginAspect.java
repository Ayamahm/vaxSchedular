package com.user_services.user_services.Config;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    @Before("execution(* com.user_services.user_services.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("LoggingAspect: Method " + joinPoint.getSignature() + " is about to be executed.");
    }
    @After("execution(* com.user_services.user_services.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("LoggingAspect: Method " + joinPoint.getSignature() + " is executed.");
    }
    @Around("execution(* com.user_services.user_services.service.*.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("PerformanceMonitoringAspect: Method " + joinPoint.getSignature() +
                " executed in " + executionTime + " milliseconds");
        return result;
    }


}
