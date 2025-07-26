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
        if (root == null) {
            return;
        }

        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        helper(root, ans);
        return ans;
    }
}
