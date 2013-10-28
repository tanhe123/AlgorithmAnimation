package SortAlgorithm;

import java.util.Comparator;

public class InsertSort extends Sort{
	/**
	 * 插入排序
	 */
	public static <T> void ToInsertSort(T[] data, Comparator<? super T> c) {
		ToInsertSort(data, 0, data.length, c);
	}

	/**
	 * 插入排序
	 */
	public static <T> void ToInsertSort(T[] data, int fromIndex, int toIndex, Comparator<? super T> c) {
		for(int i=fromIndex; i<toIndex; i++) {	
			for(int j=i+1; j<=toIndex-1; j++) {
				//if(eval(data[i]) < eval(data[j])) {
				if(c.compare(data[i], data[j]) < 0) {		
					swap(data, i, j);
				}
			}
		}	
	}
		
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToInsertSort(data, c);
	}
	
	public String getName() {
		return "插入排序";
	}
}
