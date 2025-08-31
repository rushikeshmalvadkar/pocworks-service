package com.rmalvadkar.pocworks.globalaopmethodlogger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "app.logging", name = "method-level", havingValue = "true", matchIfMissing = false)
public class LoggingAspect {

    private final AppCpnfigProperties appCpnfigProperties;

    @Around("@within(org.springframework.web.bind.annotation.RestController) || " +
            "@within(org.springframework.stereotype.Service) || " +
            "@within(org.springframework.stereotype.Component)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if(log.isDebugEnabled()){
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            long startTime = System.currentTimeMillis();
            log.debug("▶ Entering: {}.{}() ", methodSignature.getDeclaringType().getSimpleName(), methodSignature.getName());
            Object result = joinPoint.proceed();
            log.debug("✅ Exiting: {}.{}() | Time: {}ms", methodSignature.getDeclaringType().getSimpleName(), methodSignature.getName(), System.currentTimeMillis() - startTime);
            return result;
        }
       return joinPoint.proceed();
    }
}