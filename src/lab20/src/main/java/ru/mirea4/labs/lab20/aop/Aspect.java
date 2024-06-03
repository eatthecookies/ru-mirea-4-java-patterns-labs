package ru.mirea4.labs.lab20.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Before("allServiceMethods()")
    public void logServiceMethods(JoinPoint joinPoint) {
        if (joinPoint.getArgs().length == 0){
            log.info("Вызван сервис метод {}", joinPoint.getSignature().getName());
        } else {
            log.info("Вызван сервис метод {} c сортировкой по {}", joinPoint.getSignature().getName(), joinPoint.getArgs()[0]);
        }
    }
    @Pointcut("within(ru.mirea4.labs.lab20.*.*Service)")
    public void allServiceMethods() {}
}
