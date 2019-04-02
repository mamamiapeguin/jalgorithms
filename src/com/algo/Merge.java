package com.algo;

public class Merge extends Sortable
{
    private static Comparable[] aux;

//    public static void sort(Comparable[] a) {
//        aux = new Comparable[a.length];
//        sort(a, 0, a.length - 1);
//    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++]; //边界
            else if (j > hi)                a[k] = aux[i++]; //边界
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else                            a[k] = aux[j++];
        }
    }
}
