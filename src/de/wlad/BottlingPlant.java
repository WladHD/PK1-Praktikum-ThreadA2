package de.wlad;

public class BottlingPlant implements Runnable, TimerSettings {

	private Conveyor con;

	public BottlingPlant(Conveyor con) {
		this.con = con;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				synchronized (con) {
					while (con.isOverloaded()) {
						System.out.printf("Abfuellanlage: Warten, da Foerderband voll (%d)%n", con.getCurrentBottles());
						con.wait();
					}
					
					con.load(new Bottle());
					System.out.printf("Abfuellanlage: Neue Flasche abgefuellt (%d)%n", con.getCurrentBottles());
					con.notifyAll();
				}
				
				Thread.sleep(bottlingTimer);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Abfuellanlage: interrupted");
			}

		}
	}

}
