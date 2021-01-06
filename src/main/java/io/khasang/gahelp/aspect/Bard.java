package io.khasang.gahelp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {
    @Pointcut("execution(* io.khasang.gahelp.service.impl.KnightServiceImpl.getAchievement(..))")
    public void serviceBefore() {

    }

    @Before(value = "serviceBefore()")
    public void getSong(JoinPoint joinPoint) {
        System.err.println("Lalalal!!!");
    }
}
