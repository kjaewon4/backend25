package com.bu.backend;

import org.springframework.stereotype.Component;

public class HDWheel implements Wheel {

	int price = 500;
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void setPrice(int a) {
		// TODO Auto-generated method stub
		this.price = a;
	}
}
