class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(sum,1);
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];

            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}
