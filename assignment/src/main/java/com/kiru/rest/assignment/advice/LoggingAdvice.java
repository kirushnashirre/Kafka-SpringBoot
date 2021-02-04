package com.kiru.rest.assignment.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

	@Around("pointCut()")
	public Object ApplicationLogger(ProceedingJoinPoint jp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		Object[] args = jp.getArgs();

		logger.info("Invoked Service class : " + className + " || methodName : " + methodName + " || Payload : "
				+ mapper.writeValueAsString(args));

		Object obj = jp.proceed();

		logger.info(className + " " + methodName + " " + mapper.writeValueAsString(obj));
		return obj;
	}

	@Pointcut(value = "execution(* com.kiru.rest.assignment.controller.*.*(..))")
	public void pointCut() {
	}
}
