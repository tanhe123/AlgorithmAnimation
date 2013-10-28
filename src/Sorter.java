import java.awt.Component;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

import SortAlgorithm.BubbleSort;
import SortAlgorithm.InsertSort;
import SortAlgorithm.SelectionSort;
import SortAlgorithm.ShellSort;
import SortAlgorithm.Sort;


public class Sorter implements Runnable{
	/**
	 * Construts a Sorter
	 * @param comp values the array to be sorted
	 * comp the componet on which to display the sorting progress
	 */
	public Sorter(ArrayComponent comp) {
		values = new Double[this.length];
		for (int i=0; i<values.length; i++)
			values[i] = new Double(Math.random());
				
		this.component = comp;
		this.run = false;
		this.gate = new Semaphore(1);
	}
	
	public boolean setAlgorhm(int index) {
		if(index > algorithms.length) return false;
		else {
			sortAlgorithm = algorithms[index];
			return true;
		}
	}

	public boolean setAlgorhm(String algorithmName) {
		Integer index = this.hashAlgorithm.get(algorithmName);
		if (index == null) return false;
		else return setAlgorhm(index);
	}
	
	public void stop() {
		//TODO: sflejxs
		Thread.currentThread().interrupt();
		/*values = new Double[this.length];
		for (int i=0; i<values.length; i++)
			values[i] = new Double(Math.random());
				
		this.run = false;
		this.gate = new Semaphore(1);*/
	}
	
	public void setRun() {
		run = true;
		gate.release();
	}
	
	public void setStep() {
		run = false;
		gate.release();
	}
	
	public void setLength(int length) {
		this.length = length;
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
		
		// TODO: 选择算法
		this.sortAlgorithm.sort(values, comp);
		System.out.println(sortAlgorithm.getName());
		
		component.setValues(values, null, null);
		JOptionPane.showMessageDialog(null, "排序完毕");
	}
	
	private Double[] values;
	
	private ArrayComponent component;
	private boolean run;
	private Semaphore gate;
	private static Sort sortAlgorithm;
	
	private static final int DELAY = 5;
	private static int length = 200;
	
	// 算法列表
	public static HashMap<String, Integer> hashAlgorithm = new HashMap<String, Integer>(); 
	public static Sort algorithms[] = {
			new BubbleSort(),
			new InsertSort(),
			new SelectionSort(), 
			new ShellSort()
	};
	
	static {
		sortAlgorithm = algorithms[0];
		
		hashAlgorithm.put("BubbleSort", 0);
		hashAlgorithm.put("InsertSort", 1);
		hashAlgorithm.put("SelectionSort", 2);
		hashAlgorithm.put("ShellSort", 3);
	}
}
