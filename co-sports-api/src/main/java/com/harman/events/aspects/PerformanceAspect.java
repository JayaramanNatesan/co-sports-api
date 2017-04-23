package com.harman.events.aspects;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
	
	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repositoryClassMethods() {
	
	};
	
	@Pointcut("within(@com.harman.events.sports.web *)")
	public void restfulServiceMethods() {
	
	};

	@Around("repositoryClassMethods()")
	public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		String methodName = joinPoint.getSignature().getName();
		System.out
				.println("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return returnValue;
	}
}