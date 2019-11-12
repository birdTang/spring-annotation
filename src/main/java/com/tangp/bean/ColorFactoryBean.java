package com.tangp.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个Color对象，这个对象会添加到容器中
	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean getObject--------");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	//是否单例
	//true :是单例，在容器中保存一份
	//false :多实例，每次获取都会创建一个新的bean,调用getObject()
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
