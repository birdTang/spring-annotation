package com.tangp.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import com.tangp.bean.lifecycle.Car;

@Component
public class MyBeanDefinitionRegistryPostProcessor
		implements
			BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanFactory");
		System.out.println("bean的数据量："+ beanFactory.getBeanDefinitionCount());

	}

	@Override
	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("postProcessBeanDefinitionRegistry");
		System.out.println("bean的数据量："+ registry.getBeanDefinitionCount());

//		RootBeanDefinition beanDefinition = new RootBeanDefinition(Car.class);
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class).getBeanDefinition();
		registry.registerBeanDefinition("hello", beanDefinition);

	}

}
