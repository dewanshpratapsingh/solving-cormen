package insertionSort;

import java.util.Random;

class Iterative {
    static void runInsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];

            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int t = 10;
        Random rand = new Random();
        while (t-- > 0) {
            int n = rand.nextInt(100000);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(100000);
            }
            runInsertionSort(arr);

           boolean correct = true ;
           for(int i = 0 ; i < n -1 ;i++){
                if(arr[i]>arr[i+1]){
                    correct = false ;
                    break;
                }
           }
           if(correct) System.out.println("Right");
           else System.out.println("Wrong");
        }

    }
}