package mergeSort;

import java.util.Random;

class MergeSort {
    void mergeSortedArrays(int[] arr, int start, int mid, int end, int[] aux) {
        int i = start;
        int l = start;
        int r = mid + 1;
        while (l <= mid && r <= end) {
            if (arr[l] <= arr[r]) {
                aux[i++] = arr[l++];
            } else {
                aux[i++] = arr[r++];
            }
        }
        while (l <= mid) {
            aux[i++] = arr[l++];
        }
        while (r <= end) {
            aux[i++] = arr[r++];
        }
        for (int m = start; m <= end; m++) {
            arr[m] = aux[m];
        }
    }

    void runMergeSort(int[] arr, int start, int end, int[] aux) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        runMergeSort(arr, start, mid, aux);
        runMergeSort(arr, mid + 1, end, aux);
        mergeSortedArrays(arr, start, mid, end, aux);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int t = 10;
        for (int i = 0; i < t; i++) {

            int n = rand.nextInt(10000) + 1;

            int arr[] = new int[n];

            for (int k = 0; k < n; k++) {
                arr[k] = rand.nextInt(10000);
            }

            MergeSort sorter = new MergeSort();
            int[] aux = new int[n];

            sorter.runMergeSort(arr, 0, n - 1, aux);
            boolean correct = true ;
            for (int m = 0; m < n - 1; m++) {
                if (arr[m] > arr[m + 1]) {
                    correct = false ;
                    break;
                }
            }
            if (correct)
                System.out.println("RIGHT");
            else
                System.out.println("WRONG");
        }
    }
}