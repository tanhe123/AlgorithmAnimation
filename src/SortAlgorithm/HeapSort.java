package SortAlgorithm;

import java.util.Comparator;

public class HeapSort extends Sort{
	public <T> void ToHeapSort(T[] data, Comparator<? super T> c){
		init(data, c);
		for(int i=0;i<data.length;i++)
			remove(c);
		System.arraycopy(queue,1,data,0,data.length);
	}

	private <T> void init(T[] data, Comparator<? super T> c){
		this.queue = new Object[data.length+1];
		for(int i=0;i<data.length;i++){
			queue[++size]=data[i];
			fixUp(size, c);
		}
	}
	         
	private int size=0;
	private Object[] queue;
	                
	public <T> T get() {
		return (T) queue[1];
	}

	public <T> void remove(Comparator<? super T> c) {
		swap(queue,1,size--);
		fixDown(1, c);
	}
	private <T> void fixDown(int k, Comparator<? super T> c) {
		int j;
		while ((j = k << 1) <= size) {
			if (j < size &&c.compare((T)queue[j], (T)queue[j+1]) < 0)
				j++; 
			if (c.compare((T)queue[k], (T)queue[j])>0)
				break;
			swap(queue,j,k);
			k = j;
		}
	}
	private <T> void fixUp(int k, Comparator<? super T> c) {
		while (k > 1) {
			int j = k >> 1;
		if (c.compare((T)queue[j], (T)queue[k]) > 0) 
			break;
		swap(queue,j,k);
		k = j;
		}
	} 
	
	@Override
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToHeapSort(data, c);
	}

	@Override
	public String getName() {
		return "堆排序";
	}

}
