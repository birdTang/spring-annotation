package com.tangp.ext;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor....postProcessBeanFactory");
		int count = beanFactory.getBeanDefinitionCount();
		System.out.println("bean的数量："+count);
		String[] names = beanFactory.getBeanDefinitionNames();
		System.out.println(Arrays.asList(names));
		

	}

}
