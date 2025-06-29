class Solution {
    public int longestConsecutive(int[] nums) { 
        HashMap<Integer,Boolean> map = new HashMap<>();
        int n = nums.length;
        if (n == 0) return 0;
        for(int i=0;i<n;i++) { // consider every element as a starting point
            map.put(nums[i], true);
        }

        for(Integer num : map.keySet()) { // Eliminate the starting point
            if (map.containsKey(num-1)) {
                map.put(num,false);
            }
        }

        int ans = Integer.MIN_VALUE;
    
        for(Integer num : map.keySet()) { // Preparing answer
            // int num = it.next();
            // System.out.println(num);
            if (map.get(num) == true) {
                int tempAns = 1;

                while(map.containsKey(num+1)) {
                    tempAns +=1;
                    num+=1;
                }

                ans = Math.max(ans,tempAns);
            }
        }

        return ans;


    }
}
