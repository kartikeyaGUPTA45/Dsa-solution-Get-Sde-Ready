class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0, maxLen = 0,count=0;

        while(j < s.length()) {
            char ch = s.charAt(j); 
            map.put(ch,map.getOrDefault(ch,0)+1); // Acquire
            
            if (map.get(ch) == 2) count +=1;

            while(count > 0) {
                ch = s.charAt(i);
                if (map.get(ch) == 2) count-=1;
                map.put(ch, map.get(ch)-1); // release
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
        
    }
}
