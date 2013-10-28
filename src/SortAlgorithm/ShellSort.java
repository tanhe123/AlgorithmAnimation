package SortAlgorithm;

import java.util.Comparator;

public class ShellSort extends Sort {
	public static <T> void ToShellSort(T[] data, Comparator<? super T> c) {
		for(int i=data.length/2;i>2;i/=2){
			for(int j=0;j<i;j++){
				insertSort(data,j,i, c);
			}
		}
		insertSort(data,0,1, c);
	}
	
	/** 
	 * 进行shell 排序时使用的 insertSort
	 */
	private static <T> void insertSort(T[] data, int start, int inc, Comparator<? super T> c) {
		for(int i=start+inc;i<data.length;i+=inc){
			for(int j=i;(j>=inc)&&(c.compare(data[j], data[j-inc]) < 0);j-=inc){
				swap(data,j,j-inc);
			}
		}
	}
		
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToShellSort(data, c);
	}
	
	public String getName() {
		return "ShellSort";
	}
}
