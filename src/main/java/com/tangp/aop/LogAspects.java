package com.tangp.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志切面类
 * @ate 2019年11月15日
 * @author Administrator
 */
//  @Aspect,告诉spring容器，这个是切面类
@Aspect
public class LogAspects {

	/**
	 * 抽取公共切入点表达式
	 * 1.本类应用：pointCut()
	 * 2.其他的切面类应用：com.tangp.aop.LogAspects.pointCut()
	 */
	@Pointcut(value="execution(public int com.tangp.aop.MathCalculator.*(..))")
	public void pointCut() {
		
	}
	
	//@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
	////JoinPoint一定要出现在参数表的第一位
	@Before(value="pointCut()")
	public void logStart(JoinPoint joinpoint) {
		Object[] args = joinpoint.getArgs();
		System.out.println(joinpoint.getSignature().getName()+"运行----------@Before，参数列表是：{"+ Arrays.asList(args) +"}");
	}
	/**
	 * 方法结束后切入，无论是异常结束，还是 正常结束
	 */
	@After(value="com.tangp.aop.LogAspects.pointCut()")
	public void logAfter(JoinPoint joinpoint) {
		System.out.println(joinpoint.getSignature().getName()+"结束----------@After");
	}
	/**
	 * 方法正常返回
	 * 设置返回结果的接收对象：returning="result"
	 */
	@AfterReturning(value="pointCut()",returning="result")
	public void logAfterReturing(JoinPoint joinpoint,Object result) {
		System.out.println(joinpoint.getSignature().getName()+"正常返回----------	@AfterReturning，运行结果是：{"+ result +"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logAfterthrowing(JoinPoint joinpoint,Exception exception) {
		System.out.println(joinpoint.getSignature().getName()+"异常返回----------	@AfterThrowing，运行结果是：{"+ exception +"}");
	}
}
