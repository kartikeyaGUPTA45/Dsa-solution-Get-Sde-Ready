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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(q.size() > 0) {
            // Remove the node
            TreeNode node = q.remove();

            // Print the data 
            System.out.print(node.val + " ");

            // Check for left child is not null
            if (node.left != null) {
                q.add(node.left);
            }

            // Check for the right child 
            if (node.right != null) {
                q.add(node.right);
            }

        }

        return ans;
    }
}
