class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1_000_000_007;
        
        // dp[i][j][0] = # of stable arrays using i zeros, j ones, ending with 0
        // dp[i][j][1] = # of stable arrays using i zeros, j ones, ending with 1
        long[][][] dp = new long[zero + 1][one + 1][2];
        
        // Base cases
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit);  j++) dp[0][j][1] = 1;
        
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // Ending with 0: subtract streaks longer than limit
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                if (i - limit - 1 >= 0)
                    dp[i][j][0] = (dp[i][j][0] - dp[i-limit-1][j][1] + MOD) % MOD;
                else if (i == limit + 1 - 1 + 1 && j >= 1)  
                    dp[i][j][0] = (dp[i][j][0]) % MOD;
                
                // Ending with 1: subtract streaks longer than limit
                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                if (j - limit - 1 >= 0)
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-limit-1][0] + MOD) % MOD;
            }
        }
        
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}