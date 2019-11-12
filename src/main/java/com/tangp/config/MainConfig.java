package com.tangp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.tangp.bean.Person;
import com.tangp.service.BookService;

@Configuration
@ComponentScan(value = "com.tangp", includeFilters = {

		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }),

		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { BookService.class }),

		@Filter(type = FilterType.CUSTOM, classes = { MyTypeFilter.class }) }, useDefaultFilters = false)

//@ComponentScans(value = { @ComponentScan(value = "com.tangp", includeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }, useDefaultFilters = false) })
//@ComponentScan  指定要扫描的包
//excludeFilters  指定扫描的时候按照什么规则排除哪些组件
//includeFilters  指定扫描的时候只需要包含哪些组件，指定 useDefaultFilters = false 才能生效
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE_TYPE 安装给的的类型
//FilterType.ASPECTJ 使用ASPECTJ表达式
//FilterType.REGEX 使用正则
//FilterType.CUSTOM 使用自定义规则 ,实现 interface  TypeFilter
public class MainConfig {

	// 给容器注册一个bean,类型为返回值类型，id默认是方法名
	@Bean(name = "person")
	public Person person01() {
		return new Person("张三", 18);
	}
}
