class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if (s.length () < p.length()) {
            return ans;
        }

        int windowSize = p.length();
        for(int i=0;i<windowSize;i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<windowSize;i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<=s.length()- windowSize;i++) {
            if (pMap.equals(sMap)) {
                ans.add(i);
            }

            if (i +windowSize < s.length()) {
                char removeChar = s.charAt(i);
                char addChar = s.charAt(i+windowSize);
                sMap.put(removeChar, sMap.get(removeChar)-1);
                if (sMap.get(removeChar) == 0) {
                    sMap.remove(removeChar);
                }    

                sMap.put(addChar , sMap.getOrDefault(addChar,0)+1);
            }
        }

        return ans;


    }
}
