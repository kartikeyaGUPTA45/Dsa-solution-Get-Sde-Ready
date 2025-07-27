class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0) {
            int sz = q.size();

            for(int i=1;i<=sz;i++) {
                TreeNode node = q.remove();
                if (i == sz) {
                    ans.add(node.val);
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return ans;

    }
}
