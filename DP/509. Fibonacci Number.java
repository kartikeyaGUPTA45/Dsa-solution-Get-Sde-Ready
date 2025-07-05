class Solution {

    public int fib_rec(int n) {
        if (n == 0 || n == 1) return n;
        return fib_rec(n-1) + fib_rec(n-2);
    }

    public int fib_memo(int n, int dp[]) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = fib_memo(n-1,dp) + fib_memo(n-2,dp);
        return dp[n];
    }

    public int fib_tab(int n, int dp[]) {
        if (n == 0) return 0;
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int fib_space(int n) {
        if (n == 0 || n == 1) return n;

        int a = 0,b = 1;

        for(int i=2;i<=n;i++) {
            int c = a+b;
            a=b;
            b=c;
        }

        return b;
    }


    public int fib(int n) {
        // return fib_rec(n);
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

        // return fib_memo(n,dp);
        // return fib_tab(n, dp);
        return fib_space(n);
    }
}
