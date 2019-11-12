package com.tangp.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WinCondition implements Condition{

	/**
	 * ConditionContext:判断条件能使用的上下文（环境）
	 * AnnotatedTypeMetadata： 注解信息
	 */
	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		// TODO 判断死不是window 环境
		//1、能获取到ioc使用的beanfactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2、获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3、获取当前环境信息
		Environment environment = context.getEnvironment();
		//4、获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//可以判断容器中bean的注册情况，也可以给容器中注册bean
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		if(environment.getProperty("os.name").contains("Windows")) 
			return true;
		return false;
	}

}
