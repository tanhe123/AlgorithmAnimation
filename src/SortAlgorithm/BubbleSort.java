package SortAlgorithm;

import java.util.Comparator;

public class BubbleSort extends Sort {
	//插入排序
	public static <T> void ToBubbleSort(T[] data, Comparator<? super T> c) {
		for(int i=1;i<data.length;i++){
			//for(int j=i;(j>0)&&(data[j]<data[j-1]);j--){
			for(int j=i;(j>0)&&c.compare(data[j], data[j-1])<0;j--){
				swap(data,j,j-1);
			}
		}        
	}
	
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToBubbleSort(data, c);
	}
	
	public String getName() {
		return "BubbleSort";
	}
}
