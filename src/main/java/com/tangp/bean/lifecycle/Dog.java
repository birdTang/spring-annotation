package com.tangp.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware {

	ApplicationContext applicationContext;
	public Dog() {
		System.out.println("Dog constructor.........");
	}
	
	////对象创建并赋值之后调用
	@PostConstruct
	public void init() {
		System.out.println("Dog @PostConstruct.........");
	}
	
	//容器移除对象之前
	@PreDestroy
	public void destory() {
		System.out.println("car @PreDestroy...........");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}
}
