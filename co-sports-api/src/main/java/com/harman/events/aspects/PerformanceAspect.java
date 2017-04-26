package com.harman.events.aspects;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private Log log = LogFactory.getLog(this.getClass());

	@Around("com.harman.events.aspects.SystemArchitecture.atLayerEntryPoints()")
	public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		
		log.info( String.format( 
				"Execution of method: %s.%s, took %d ms",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), 
				TimeUnit.NANOSECONDS.toMillis(end - start)));
		
		return returnValue;
	}
}