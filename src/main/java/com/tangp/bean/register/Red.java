package com.tangp.bean.register;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware{

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println(resolver.resolveStringValue("你好，${os.name},我是#{12*10}"));
		
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("当前bean的name："+name);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		System.out.println("传入的ioc容器："+applicationContext);
	}

}
