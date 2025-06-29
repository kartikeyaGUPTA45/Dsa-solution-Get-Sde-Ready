class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);

            if (map.containsKey(ch)) {
                int freq = map.get(ch);
                if (freq == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch,freq-1);
                }
            } else {
                return false;
            }
        }

        return map.size() == 0;
    }
}
