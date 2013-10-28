package SortAlgorithm;

import java.util.Comparator;

public class QuickSort extends Sort{
	public static <T> void ToQuickSort(T[] data, Comparator<? super T> c) {
		quickSort(data,0,data.length-1,c );        
	}
	
    private static <T> void quickSort(T[] data,int i,int j, Comparator<? super T> c){
        int pivotIndex=(i+j)/2;
     
        swap(data,pivotIndex,j);
        
        int k=partition(data,i-1,j,data[j], c);
        swap(data,k,j);
        if((k-i)>1) quickSort(data,i,k-1, c);
        if((j-k)>1) quickSort(data,k+1,j, c);
    }

    private static <T> int partition(T[] data, int l, int r, T pivot, Comparator<? super T> c) {
        do{
           while(c.compare(data[++l], pivot)<0);
           while((r!=0)&&c.compare(data[--r], pivot)>0);
           swap(data,l,r);
        }
        while(l<r);
        swap(data,l,r);        
        return l;
    }
	
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToQuickSort(data, c);
	}
	
	public String getName() {
		return "快速排序";
	}	
}
