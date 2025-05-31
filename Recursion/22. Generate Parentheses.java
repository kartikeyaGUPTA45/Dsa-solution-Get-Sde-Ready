class Solution {

    public void helper(int ob, int cb, String str, List<String> ans) {
        if (ob == 0 && cb == 0) {
            ans.add(str);
            return;
        }

        if (ob > 0) {
            helper(ob-1, cb, str + "(", ans);
        }

        if (cb > ob) {
            helper(ob,cb-1,str + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,n,"",ans);

        return ans;
    }
}
