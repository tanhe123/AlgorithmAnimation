package SortAlgorithm;

import java.util.Comparator;

abstract public class Sort {
	abstract public <T> void sort(T[] data, Comparator<? super T> c);
	abstract public String getName();
	
	protected static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
