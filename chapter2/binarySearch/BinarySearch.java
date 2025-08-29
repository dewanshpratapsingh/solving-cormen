class BinarySearch{
    int runIterative(int [] arr, int target){
        if (arr == null || arr.length == 0) return -1;
        int start = 0 ;
        int end = arr.length - 1 ;
        while(start <= end){
            int mid = start + (end - start) /2;
            if(arr[mid] == target) return mid ;
            else if(arr[mid]>target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1 ;
    }

    int runRecursive(int [] arr, int target,int start, int end){
        //For large arrays (e.g., size 10^6), recursion may cause a StackOverflowError.
        if (arr == null || arr.length == 0) return -1;
        if(start > end) return -1;
        int mid = start + (end - start) /2 ;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid]<target)
            return runRecursive(arr,target,mid+1,end);
        else
            return runRecursive(arr,target,start,mid-1);
    }

}