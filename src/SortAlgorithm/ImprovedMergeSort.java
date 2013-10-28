package SortAlgorithm;

import java.util.Comparator;

public class ImprovedMergeSort extends Sort {
	private static final int THRESHOLD = 10;
	
    public static <T> void ToImprovecMergeSort(T[] data, Comparator<? super T> c) {
        //int[] temp=new int[data.length];
    	Object[] temp = new Object[data.length];
        mergeSort(data,temp,0,data.length-1, c);
    }

    private static <T> void mergeSort(T[] data, Object[] temp, int l, int r, Comparator<? super T> c) {
        int i, j, k;
        int mid = (l + r) / 2;
        if (l == r)
            return;
        if ((mid - l) >= THRESHOLD)
            mergeSort(data, temp, l, mid, c);
        else
            insertSort(data, l, mid - l + 1, c);
        if ((r - mid) > THRESHOLD)
            mergeSort(data, temp, mid + 1, r, c);
        else
            insertSort(data, mid + 1, r - mid, c);

        for (i = l; i <= mid; i++) {
            temp[i] = data[i];
        }
        for (j = 1; j <= r - mid; j++) {
            temp[r - j + 1] = data[j + mid];
        }
        T a = (T) temp[l];
        T b = (T) temp[r];
        for (i = l, j = r, k = l; k <= r; k++) {
            if (c.compare(a, b) < 0) {
                data[k] = (T) temp[i++];
                a = (T) temp[i];
            } else {
                data[k] = (T) temp[j--];
                b = (T) temp[j];
            }
        }
    }

    private static <T> void insertSort(T[] data, int start, int len, Comparator<? super T> c) {
        for(int i=start+1;i<start+len;i++){
            for(int j=i;(j>start) && c.compare(data[j], data[j-1])<0;j--){
                swap(data,j,j-1);
            }
        }
    }
		
	@Override
	public <T> void sort(T[] data, Comparator<? super T> c) {
		ToImprovedMergeSort(data, c);
	}

	@Override
	public String getName() {
		return "改进后的归并";
	}
}
