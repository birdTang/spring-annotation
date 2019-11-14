package com.tangp.bean.register;

import com.tangp.bean.lifecycle.Car;

public class Color {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Color [car=" + car + "]";
	}
	
	
}
