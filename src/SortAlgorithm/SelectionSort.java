package SortAlgorithm;

import java.util.Comparator;

public class SelectionSort extends Sort{
	/**
	 * 选择排序
	 */
	public static <T> void ToSelectionSort(T[] data, Comparator<? super T> c) {
		for (int i = 0; i < data.length; i++) {
			int lowIndex = i;
			for (int j = data.length - 1; j > i; j--) {
//				if (data[j] < data[lowIndex]) {
				if (c.compare(data[j], data[lowIndex]) < 0) {
					lowIndex = j;
				}
			}
	        swap(data,i,lowIndex);
		}
	}
	
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToSelectionSort(data, c);
	}
	
	public String getName() {
		return "SelectionSort";
	}
}
