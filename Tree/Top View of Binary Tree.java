
class Solution {
    
    public static class Pair {
        int level;
        Node node;
        
        public Pair(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }
    
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int minLevel = 0;
        
        q.add(new Pair(0,root));
        
        while(q.size() > 0) {
            Pair p = q.remove();
            
            if(!map.containsKey(p.level)) {
                map.put(p.level, p.node.data);
            }
            
            if (p.node.left != null) {
                minLevel = Math.min(minLevel, p.level-1);
                q.add(new Pair(p.level-1, p.node.left));
                
            }
            
            if (p.node.right != null) {
                q.add(new Pair(p.level+1, p.node.right));
            }
        }
        
        while(map.containsKey(minLevel)) {
            ans.add(map.get(minLevel));
            minLevel += 1;
        }
        
        return ans;
        
    }
}
