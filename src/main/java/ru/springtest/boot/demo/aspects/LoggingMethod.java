package ru.springtest.boot.demo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class LoggingMethod {
    @Around("@annotation(ru.springtest.boot.demo.annotations.LogMethod)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        Object returnedValue = point.proceed();
        String methodName = point.getSignature().getName();
        List<String> args = Arrays.stream(point.getArgs())
                .map(Object::toString)
                .collect(Collectors.toList());
        log.info("Method name: {}, Method params: {}, returned Value: {}", methodName, args, returnedValue);
        return returnedValue;
    }

}
