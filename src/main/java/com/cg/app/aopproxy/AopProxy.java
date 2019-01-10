package com.cg.app.aopproxy;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cg.app.ValidationCalculator;

@Aspect
@Component
public class AopProxy {
	Logger logger = Logger.getLogger(ValidationCalculator.class.getName());

	@Before("execution(* com.cg.app.ValidationCalculator.*(..))")
	public void log1() {
		logger.info("Before logging the method");
	}

	@After("execution(* com.cg.app.ValidationCalculator.*(..))")
	public void log2() {
		logger.info("After logging the method");
	}

	@Around("execution(* com.cg.app.ValidationCalculator.*(..))")
	public Integer log3(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before Logging the method");
		logger.info("function name is:" + pjp.getSignature());
		logger.info("parameters are:");
		Object[] params = pjp.getArgs();
		for (int i = 0; i < params.length; i++) {
			logger.info("parameter value at index" + i + "is" + params[i]);
		}
		Object retVal = pjp.proceed();
		logger.info("After logging the method");
		return (Integer) retVal;
	}

	@AfterReturning(pointcut = "execution(* com.cg.app.ValidationCalculator.add(..))", returning = "retVal")
	public void log4(Integer retVal) {
		logger.info("" + retVal);
	}

}
