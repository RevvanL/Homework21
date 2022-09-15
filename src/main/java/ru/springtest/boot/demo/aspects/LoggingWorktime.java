package ru.springtest.boot.demo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Aspect
@Slf4j
public class LoggingWorktime {
    @Around("@annotation(ru.springtest.boot.demo.annotations.WorkTime)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        Object returnedValue = point.proceed();
        long start = Instant.now().toEpochMilli();
        Thread.sleep(1000);
        String methodName = point.getSignature().getName();
        long end = Instant.now().toEpochMilli();
        long time = end - start;
        log.info("Method name: {}, Method runtime: {} ms.", methodName, time);
        return 0;
    }
}
