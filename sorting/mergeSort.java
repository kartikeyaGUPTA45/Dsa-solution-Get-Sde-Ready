class Solution {

    void mergeSort(int arr[], int low, int high) {
        // code here
        if (low >= high) {
            return;
        }
        
        int mid = (low + high)/2;
        
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        mergeTwoSortedArray(arr,low,mid,high);
    }
    
    void mergeTwoSortedArray(int arr[], int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>(); // For storing the
        // elements in the sorted order
        
        int i = low; // i
        int j = mid+1; // j
        int n1 = mid+1;
        int n2 = high+1;
        
        while(i < n1 && j < n2) {
            if (arr[i] > arr[j]) {
                temp.add(arr[j]);
                j++;
            } else {
                temp.add(arr[i]);
                i++;
            }
        }
        
        while(i < n1) {
            temp.add(arr[i]);
            i++;
        }
        
        while(j < n2) {
            temp.add(arr[j]);
            j++;
        }
        
        int pos = low;
        for(int ele : temp) {
            arr[pos] = ele;
            pos++;
        }
  
    }
}
