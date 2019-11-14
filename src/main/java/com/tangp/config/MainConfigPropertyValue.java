package com.tangp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.tangp.bean.Person;

@Configuration
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中，加载完外部的配置文件后，使用${ }取出配置文件的值
@PropertySource(value = {"classpath:/beans.properties"})
//PropertySources指定多个配置文件，或者多个@PropertySource，效果是一样的
public class MainConfigPropertyValue {

	@Bean
	public Person person() {
		return new Person();
	}
}
