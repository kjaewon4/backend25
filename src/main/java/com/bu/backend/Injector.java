package com.bu.backend;

public class Injector {
	
	Wheel hdw = new HDWheel();
	Wheel adw = new ADWheel();	
	
	Seat bmwS = new BMWSeat();
	Door venD = new VentzDoor();
	public Wheel getHdw() {
		return hdw;
	}
	
	public Wheel getAdw() {
		return adw;
	}
	
	public Seat getBmwS() {
		return bmwS;
	}
	
	public Door getVenD() {
		return venD;
	}
	
	
	
	
	
}
