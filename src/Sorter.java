import java.awt.Component;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;


public class Sorter implements Runnable{
	/**
	 * Construts a Sorter
	 * @param comp values the array to be sorted
	 * comp the componet on which to display the sorting progress
	 */
	public Sorter(ArrayComponent comp) {
		values = new Double[VALUES_LENGTH];
		for (int i=0; i<values.length; i++)
			values[i] = new Double(Math.random());
				
		this.component = comp;
		this.run = false;
		this.gate = new Semaphore(1);
	}
	
	public void setRun() {
		run = true;
		gate.release();
	}
	
	public void setStep() {
		run = false;
		gate.release();
	}
	
	public void run() {
		Comparator<Double> comp = new Comparator<Double>() {
			public int compare(Double i1, Double i2) {
				component.setValues(values, i1, i2);
				try {
					if(run) Thread.sleep(DELAY);
					else gate.acquire();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				
				return i1.compareTo(i2);
			}
		};
		
		Arrays.sort(values, comp);
		component.setValues(values, null, null);
	}
	
	private Double[] values;
	
	private ArrayComponent component;
	private boolean run;
	private Semaphore gate;
	
	private static final int DELAY = 100;
	private static final int VALUES_LENGTH = 30;
}
