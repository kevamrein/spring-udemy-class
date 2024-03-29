package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDao.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing Before for add account");
	}
}
