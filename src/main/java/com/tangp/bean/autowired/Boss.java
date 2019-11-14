package com.tangp.bean.autowired;

import org.springframework.stereotype.Component;

import com.tangp.bean.lifecycle.Car;


//默认加在ioc容器中的组件，容器启动会调用无参构造器，创建对象，然后再进行初始化赋值等操作
@Component
public class Boss {

	private Car car;

//	@Autowired
	public Boss(Car car) {
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}

//	@  
	//标注在方法上，spring容器就会创建当前对象，就会调用方法，完成赋值
	//方法使用的参数，自定义类型的值从ioc容器中获取
	public void setCar(Car car) {
		this.car = car;
	}


	@Override
	public String toString() {
		return "Boss []";
	}
	
	
}
