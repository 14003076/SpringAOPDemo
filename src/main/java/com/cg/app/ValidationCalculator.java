package com.cg.app;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
@Component
public class ValidationCalculator {
   public Integer add(int number1,int number2) {
	   Logger logger = Logger.getLogger(ValidationCalculator.class.getName());
	int result=number1+number2;
	 logger.info("Addition of two numbers:"+result);
	 return result;
	   
   }
   
}
