package com.bu.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class CarFrame {
	Wheel wheel;
	Seat seat;
	Door door;
	
	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
		
		System.out.println("setWheel : " + String.valueOf(wheel.getPrice()));
		
	}

	public void setSeat(Seat seat) {
		// TODO Auto-generated method stub
		this.seat = seat;
	}

	public void setDoor(Door door) {
		// TODO Auto-generated method stub
		this.door = door;
	}
	
	
}
