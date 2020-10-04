package de.wlad;

import java.time.LocalDate;

public class Lable {
	private String type;
	private int bestBefore;
	
	public Lable(String type) {
		this.type = type;
		this.bestBefore = LocalDate.now().getYear() + 1;
	}
	
	public String getType() {
		return type;
	}
	
	public int getBestBefore() {
		return bestBefore;
	}
}
