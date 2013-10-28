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

	//改进后的归并排序:

	
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
