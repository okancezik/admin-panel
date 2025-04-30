package com.okancezik.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("execution(* com.okancezik.service..*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		logger.info("{} method is calling - parameters: {}", methodName, args);
		Object result = null;
		long start = System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
			long duration = System.currentTimeMillis() - start;
			logger.info("{} method has been called in {}ms", methodName, duration);
			return result;
		} catch (Throwable ex) {
			logger.error("Exception in {} method. Error: {}", methodName, ex.getMessage(), ex);
			throw ex;
		}
	}
}
