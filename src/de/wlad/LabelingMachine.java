package de.wlad;

public class LabelingMachine implements Runnable, TimerSettings {
	
	private Conveyor con;

	public LabelingMachine(Conveyor con) {
		this.con = con;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				synchronized (con) {
					while (con.isEmpty()) {
						System.out.printf("Etikettiermaschine: Warten, da Foerderband leer (%d)%n", con.getCurrentBottles());
						con.wait();
					}
					
					Bottle b = con.withdraw();
					b.printLable();
					System.out.printf("Etikettiermaschine: %s mindestends haltbar bis %d (%d)%n", b.getLable().getType(), b.getLable().getBestBefore(), con.getCurrentBottles());
					con.notifyAll();
				}
				
				Thread.sleep(labelingTimer);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Etikettiermaschine: interrupted");
			}

		}
	}

}
