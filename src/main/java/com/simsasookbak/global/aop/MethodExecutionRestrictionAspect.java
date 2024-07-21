package com.simsasookbak.global.aop;

import com.simsasookbak.global.exception.MethodInvocationLimitException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class MethodExecutionRestrictionAspect {

    private final Map<String, Boolean> methodExecutionFlags = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.simsasookbak.global.aop.MethodInvocationLimit)")
    private void methodInvocationLimit() {}

    @Before("methodInvocationLimit()")
    public void beforeMethodInvocationLimit(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        String username = request.getUserPrincipal().getName();
        String methodName = joinPoint.getSignature().getName();
        String key = username + ":" + methodName;

        Boolean isMethodRunning = methodExecutionFlags.get(key);

        if (Boolean.TRUE.equals(isMethodRunning)) {
            throw new MethodInvocationLimitException("같은 사용자가 아직 처리중인 메서드를 반복 호출하였습니다");
        }

        // 메서드 실행 상태 플래그 설정
        methodExecutionFlags.put(key, true);
    }

    @After("methodInvocationLimit()")
    public void afterMethodInvocationLimit(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        String username = request.getUserPrincipal().getName();
        String methodName = joinPoint.getSignature().getName();
        String key = username + ":" + methodName;

        // 메서드 실행 상태 플래그 해제
        methodExecutionFlags.put(key, false);
    }
}
