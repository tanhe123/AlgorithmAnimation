package SortAlgorithm;

import java.util.Comparator;

public class MergeSort extends Sort {
	public static <T> void ToMergeSort(T[] data, Comparator<? super T> c) {
		int[] temp=new int[data.length];
		mergeSort(data,temp,0,data.length-1, c);
	}
	    
    private static <T> void mergeSort(T[] data,T[] temp,int l,int r, Comparator<? super T> c){
        int mid=(l+r)/2;
        if(l==r) return ;
        mergeSort(data,temp,l,mid, c);
        mergeSort(data,temp,mid+1,r, c);
        for(int i=l;i<=r;i++){
            temp[i]=data[i];
        }
        int i1=l;
        int i2=mid+1;
        for(int cur=l;cur<=r;cur++){
            if(i1==mid+1)
                data[cur]=temp[i2++];
            else if(i2>r)
                data[cur]=temp[i1++];
            else if(c.compare(temp[i1], temp[i2]) < 0) 
                data[cur]=temp[i1++];
            else
                data[cur]=temp[i2++];            
        }
    }

	
	@Override
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToMergeSort(data, c);
	}

	@Override
	public String getName() {
		return "归并排序";
	}

}
