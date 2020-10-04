package de.wlad;

import java.util.Random;

public class Bottle {

	private static Random r = new Random();
	private static String[] types = { "Bier", "Wasser", "Apfelsaft", "Traubensaft", "Vodka" };
	private Lable lable;

	public void printLable() {
		lable = new Lable(types[r.nextInt(types.length - 1)]);
	}

	public Lable getLable() {
		return lable;
	}

}
