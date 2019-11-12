package com.tangp.selector;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.tangp.bean.Rainbow;

public class MyImportBeanDefinitionRegistrar
		implements
			ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry：BeanDefinition注册类，把所有所需要的注册到容器中的bean,调用BeanDefinitionRegistry.registerBeanDefinition手工注册
	 */
	@Override
	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry) {
		if(registry.containsBeanDefinition("com.tangp.bean.Red") && registry.containsBeanDefinition("com.tangp.bean.Bule")) {
			//指定bean名字,注册一个bean,指定bean类型
			RootBeanDefinition rainbow = new RootBeanDefinition(Rainbow.class);
			registry.registerBeanDefinition("rainbow", rainbow);
		}

	}

}
