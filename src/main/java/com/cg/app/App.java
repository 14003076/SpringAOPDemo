package com.cg.app;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger(ValidationCalculator.class.getName());
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	ValidationCalculator calculator=context.getBean(ValidationCalculator.class);
       calculator.add(100, 200);
    }
}
