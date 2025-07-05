class Solution {

    public int memo(int n, int dp[]) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int minAns = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            int subAns = memo(n-i*i,dp) + 1;
            minAns = Math.min(subAns, minAns);
        }

        dp[n] = minAns;
        return minAns;
    } // Tabulation, SC -> O(1)???


    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,n);

        return memo(n,dp);
    }
}
