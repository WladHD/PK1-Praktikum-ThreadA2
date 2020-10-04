package de.wlad;

import java.util.LinkedList;
import java.util.List;

public class Conveyor {
	private List<Bottle> con = new LinkedList<>();
	private final int maxBottles = 50;
	
	public void load(Bottle b) {
		con.add(b);
	}
	
	public Bottle withdraw() {
		return con.remove(0);
	}
	
	public boolean isEmpty() {
		return con.isEmpty();
	}
	
	public boolean isOverloaded() {
		return con.size() >= maxBottles;
	}
	
	public int getCurrentBottles() {
		return con.size();
	}
	
	
}
