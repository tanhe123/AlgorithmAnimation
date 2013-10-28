package SortAlgorithm;
import java.util.Comparator;


public class SortAlgorithm {

	/*
	 * 逆序冒泡
	 */
	public static <T> void BubbleSort1(T[] data, Comparator<? super T> c) {
		for(int i=0;i<data.length;i++){
			for(int j=data.length-1;j>i;j--){
				//if(data[j]<data[j-1]){
				if(c.compare(data[j], data[j-1]) < 0) {
					swap(data,j,j-1);
				}
			}
		}
	}


	/** 快排
	 */
	public static <T> void QuickSort(T[] data, Comparator<? super T> c) {
		quickSort(data,0,data.length-1,c );        
	}
	
    private static <T> void quickSort(T[] data,int i,int j, Comparator<? super T> c){
        int pivotIndex=(i+j)/2;
        //swap
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


//	//改进后的快速排序:
/*   private static int MAX_STACK_SIZE=4096;
    private static int THRESHOLD=10;
	public class ImprovedQuickSort {*/
//	    public void sort(int[] data) {
//	        int[] stack=new int[MAX_STACK_SIZE];
//	        
//	        int top=-1;
//	        int pivot;
//	        int pivotIndex,l,r;
//	        
//	        stack[++top]=0;
//	        stack[++top]=data.length-1;
//	        
//	        while(top>0){
//	            int j=stack[top--];
//	            int i=stack[top--];
//	            
//	            pivotIndex=(i+j)/2;
//	            pivot=data[pivotIndex];
//	            
//	            SortUtil.swap(data,pivotIndex,j);
//	            
//	            //partition
//	            l=i-1;
//	            r=j;
//	            do{
//	                while(data[++l]<pivot);
//	                while((r!=0)&&(data[--r]>pivot));
//	                SortUtil.swap(data,l,r);
//	            }
//	            while(l<r);
//	            SortUtil.swap(data,l,r);
//	            SortUtil.swap(data,l,j);
//	            
//	            if((l-i)>THRESHOLD){
//	                stack[++top]=i;
//	                stack[++top]=l-1;
//	            }
//	            if((j-l)>THRESHOLD){
//	                stack[++top]=l+1;
//	                stack[++top]=j;
//	            }
//	            
//	        }
//	        //new InsertSort().sort(data);
//	        insertSort(data);
//	    }
//	    /**
//	     * @param data
//	     */
//	    private void insertSort(int[] data) {
//	        int temp;
//	        for(int i=1;i<data.length;i++){
//	            for(int j=i;(j>0)&&(data[j]<data[j-1]);j--){
//	                SortUtil.swap(data,j,j-1);
//	            }
//	        }       
//	    }
//
//	}
//
//	//归并排序:
//
//	package org.rut.util.algorithm.support;
//
//	import org.rut.util.algorithm.SortUtil;
//
//	/**
//	 * @author treeroot
//	 * @since 2006-2-2
//	 * @version 1.0
//	 */
//	public class MergeSort implements SortUtil.Sort{
//
//	    /** (non-Javadoc)
//	     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
//	     */
//	    public void sort(int[] data) {
//	        int[] temp=new int[data.length];
//	        mergeSort(data,temp,0,data.length-1);
//	    }
//	    
//	    private void mergeSort(int[] data,int[] temp,int l,int r){
//	        int mid=(l+r)/2;
//	        if(l==r) return ;
//	        mergeSort(data,temp,l,mid);
//	        mergeSort(data,temp,mid+1,r);
//	        for(int i=l;i<=r;i++){
//	            temp[i]=data[i];
//	        }
//	        int i1=l;
//	        int i2=mid+1;
//	        for(int cur=l;cur<=r;cur++){
//	            if(i1==mid+1)
//	                data[cur]=temp[i2++];
//	            else if(i2>r)
//	                data[cur]=temp[i1++];
//	            else if(temp[i1]<temp[i2])
//	                data[cur]=temp[i1++];
//	            else
//	                data[cur]=temp[i2++];            
//	        }
//	    }
//
//	}
//
//	//改进后的归并排序:
//
//	package org.rut.util.algorithm.support;
//
//	import org.rut.util.algorithm.SortUtil;
//
//	/**
//	 * @author treeroot
//	 * @since 2006-2-2
//	 * @version 1.0
//	 */
//	public class ImprovedMergeSort implements SortUtil.Sort {
//
//	    private static final int THRESHOLD = 10;
//
//	    /**
//	     * (non-Javadoc)
//	     * 
//	     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
//	     */
//	    public void sort(int[] data) {
//	        int[] temp=new int[data.length];
//	        mergeSort(data,temp,0,data.length-1);
//	    }
//
//	    private void mergeSort(int[] data, int[] temp, int l, int r) {
//	        int i, j, k;
//	        int mid = (l + r) / 2;
//	        if (l == r)
//	            return;
//	        if ((mid - l) >= THRESHOLD)
//	            mergeSort(data, temp, l, mid);
//	        else
//	            insertSort(data, l, mid - l + 1);
//	        if ((r - mid) > THRESHOLD)
//	            mergeSort(data, temp, mid + 1, r);
//	        else
//	            insertSort(data, mid + 1, r - mid);
//
//	        for (i = l; i <= mid; i++) {
//	            temp[i] = data[i];
//	        }
//	        for (j = 1; j <= r - mid; j++) {
//	            temp[r - j + 1] = data[j + mid];
//	        }
//	        int a = temp[l];
//	        int b = temp[r];
//	        for (i = l, j = r, k = l; k <= r; k++) {
//	            if (a < b) {
//	                data[k] = temp[i++];
//	                a = temp[i];
//	            } else {
//	                data[k] = temp[j--];
//	                b = temp[j];
//	            }
//	        }
//	    }
//
//	    /**
//	     * @param data
//	     * @param l
//	     * @param i
//	     */
//	    private void insertSort(int[] data, int start, int len) {
//	        for(int i=start+1;i<start+len;i++){
//	            for(int j=i;(j>start) && data[j]<data[j-1];j--){
//	                SortUtil.swap(data,j,j-1);
//	            }
//	        }
//	    }
//
//	}
//	//堆排序:
//
//	package org.rut.util.algorithm.support;
//
//	import org.rut.util.algorithm.SortUtil;
//
//	/**
//	 * @author treeroot
//	 * @since 2006-2-2
//	 * @version 1.0
//	 */
//	public class HeapSort implements SortUtil.Sort{
//
//	    /** (non-Javadoc)
//	     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
//	     */
//	    public void sort(int[] data) {
//	        MaxHeap h=new MaxHeap();
//	        h.init(data);
//	        for(int i=0;i<data.length;i++)
//	            h.remove();
//	        System.arraycopy(h.queue,1,data,0,data.length);
//	    }
//
//
//	     private static class MaxHeap{
//	         
//	        
//	        void init(int[] data){
//	            this.queue=new int[data.length+1];
//	            for(int i=0;i<data.length;i++){
//	                queue[++size]=data[i];
//	                fixUp(size);
//	            }
//	        }
//	         
//	        private int size=0;
//
//	        private int[] queue;
//	                
//	        public int get() {
//	            return queue[1];
//	        }
//
//	        public void remove() {
//	            SortUtil.swap(queue,1,size--);
//	            fixDown(1);
//	        }
//	        //fixdown
//	        private void fixDown(int k) {
//	            int j;
//	            while ((j = k << 1) <= size) {
//	                if (j < size && queue[j]<queue[j+1])
//	                    j++; 
//	                if (queue[k]>queue[j]) //不用交换
//	                    break;
//	                SortUtil.swap(queue,j,k);
//	                k = j;
//	            }
//	        }
//	        private void fixUp(int k) {
//	            while (k > 1) {
//	                int j = k >> 1;
//	                if (queue[j]>queue[k])
//	                    break;
//	                SortUtil.swap(queue,j,k);
//	                k = j;
//	            }
//	        }
//
//	    }
//
//	}

	 
/*
	//SortUtil:

	package org.rut.util.algorithm;

	import org.rut.util.algorithm.support.BubbleSort;
import org.rut.util.algorithm.support.HeapSort;
import org.rut.util.algorithm.support.ImprovedMergeSort;
import org.rut.util.algorithm.support.ImprovedQuickSort;
import org.rut.util.algorithm.support.InsertSort;
import org.rut.util.algorithm.support.MergeSort;
import org.rut.util.algorithm.support.QuickSort;
import org.rut.util.algorithm.support.SelectionSort;
import org.rut.util.algorithm.support.ShellSort;
*/
	/**
	 * @author treeroot
	 * @since 2006-2-2
	 * @version 1.0
	 */
/*	public class SortUtil {
	    public final static int INSERT = 1;

	    public final static int BUBBLE = 2;

	    public final static int SELECTION = 3;

	    public final static int SHELL = 4;

	    public final static int QUICK = 5;

	    public final static int IMPROVED_QUICK = 6;

	    public final static int MERGE = 7;

	    public final static int IMPROVED_MERGE = 8;

	    public final static int HEAP = 9;

	    public static void sort(int[] data) {
	        sort(data, IMPROVED_QUICK);
	    }
	    private static String[] name={
	            "insert","bubble","selection","shell","quick","improved_quick","merge","improved_merge","heap"
	    };
	    
	    private static Sort[] impl=new Sort[]{
	            new InsertSort(),
	            new BubbleSort(),
	            new SelectionSort(),
	            new ShellSort(),
	            new QuickSort(),
	            new ImprovedQuickSort(),
	            new MergeSort(),
	            new ImprovedMergeSort(),
	            new HeapSort()
	    };

	    public static String toString(int algorithm){
	        return name[algorithm-1];
	    }
	    
	    public static void sort(int[] data, int algorithm) {
	        impl[algorithm-1].sort(data);
	    }

	    public static interface Sort {
	        public void sort(int[] data);
	    }

	    public static void swap(int[] data, int i, int j) {
	        int temp = data[i];
	        data[i] = data[j];
	        data[j] = temp;
	    }
	}
*/
}
