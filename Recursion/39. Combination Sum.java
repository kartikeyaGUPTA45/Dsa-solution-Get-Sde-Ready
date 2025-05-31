class Solution {

    public void helper(int idx, int arr[], int tar, List<Integer> subAns, List<List<Integer>> ans) {

        if (idx == arr.length) {
            if (tar == 0) {
                ans.add(new ArrayList<>(subAns));
            }
            return;
        }

        // Part of Answer
        if (arr[idx] <= tar) {
            subAns.add(arr[idx]);
            helper(idx,arr, tar-arr[idx],subAns,ans);
            subAns.remove(subAns.size()-1);
        }    

        // Not part of Answer
        helper(idx+1,arr,tar,subAns,ans);
    }

    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();

        helper(0,arr,tar,subAns,ans);

        return ans;
    }
}
