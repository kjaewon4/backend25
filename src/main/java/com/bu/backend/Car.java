package com.bu.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("car")
public class Car {

	CarFrame frame;

	public Car()
	{
		
	}
	
	@Autowired
	public Car(CarFrame frame) {
		super();
		
		System.out.println("Car inject success Car");
		this.frame = frame;
	}

	public CarFrame getFrame() {
		return frame;
	}

	
	public void setFrame(CarFrame frame) {
		
		System.out.println("Car inject success setFrame");
		this.frame = frame;
	}
	
	
}
