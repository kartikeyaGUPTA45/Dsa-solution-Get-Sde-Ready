// User function Template for Java

class Pair {
    int ele;
    int idx;

    public Pair (int ele, int idx) {
        this.ele = ele;
        this.idx = idx;
    }
}

class Solution {
    // Function to count inversions in the array.
    
    private static void mergeSortedArray(Pair p[], int low, int mid, int high, int ans[]) {
        int i = low;
        int j = mid+1;
        int n1 = mid+1;
        int n2 = high+1;

        List<Pair> temp = new ArrayList<>();
        int count = 0;

        while(i < n1 && j < n2) {
            if (p[i].ele > p[j].ele) {
                count++;
                temp.add(p[j]);
                j++;
            } else {
                ans[p[i].idx] += count;
                temp.add(p[i]);
                i++;
            }
        }

        while(i < n1) {
            ans[p[i].idx] += count;
            temp.add(p[i]);
            i++;
        }

        while (j < n2) {
            temp.add(p[j]);
            j++;
        }

        int pos = low;
        for(Pair pp : temp) {
            p[pos] = pp;
            pos++;
        }
    }

    private static void mergeSort(Pair p[], int low, int high, int ans[]) {
        if (low >= high) return;

        int mid = (low + high)/2;
        mergeSort(p,low,mid,ans);
        mergeSort(p,mid+1,high,ans);

        mergeSortedArray(p,low,mid,high,ans);
    }
    
    static int inversionCount(int nums[]) {
        // Your Code Here
        int n = nums.length;
        Pair p [] = new Pair[n];

        for(int i=0;i<n;i++) {
            p[i] = new Pair(nums[i], i); 
        }

        int ans [] = new int[n];
        mergeSort(p,0,n-1,ans);
        
        int res = 0;
        for(int ele: ans) res += ele;
        
        return res;
        
    }
}
