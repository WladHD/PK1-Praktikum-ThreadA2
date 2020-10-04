package de.wlad;

public class Main {

	public static void main(String[] args) {
		Conveyor con = new Conveyor();
		
		Thread bP = new Thread(new BottlingPlant(con));
		Thread lM = new Thread(new LabelingMachine(con));
		
		bP.start();
		lM.start();
	}

}
