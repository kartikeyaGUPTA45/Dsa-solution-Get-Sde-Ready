class Solution {

    public static int countNodes(Node root) {
        // Code here
        if (root == null) {
            return 0;
        }
        
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        
        if (lh == rh) {
            return ((1<<lh)-1);
        } 
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private static int leftHeight(Node root) {
        int ans = 0;
        
        while (root != null) {
            ans += 1;
            root = root.left;
        }
        
        return ans;
    }
    
    private static int rightHeight(Node root) {
        int ans = 0;
        
        while (root != null) {
            ans += 1;
            root = root.right;
        }
        
        return ans;
    }
}
