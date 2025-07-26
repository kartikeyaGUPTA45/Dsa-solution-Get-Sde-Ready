/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private void helper(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) { // When the root becomes null -> return from there
            return;
        }

        helper(root.left, ans); // calling to the left child
        helper(root.right, ans); // calling to the right child
        ans.add(root.val); // store the answer the in the arraylist
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        helper(root, ans);
        return ans;
    }
}
