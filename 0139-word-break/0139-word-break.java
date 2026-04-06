import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n + 1];
        return solve(s, 0, 1, set, dp);
    }

    private boolean solve(String s, int i, int j, Set<String> set, Boolean[][] dp) {

        // Base cases
        if (i == s.length()) return true;
        if (j > s.length()) return false;

        // DP check
        if (dp[i][j] != null) return dp[i][j];

        String part = s.substring(i, j);

        boolean result;

        if (set.contains(part)) {
            // TAKE or SKIP
            result = solve(s, j, j + 1, set, dp) ||
                     solve(s, i, j + 1, set, dp);
        } else {
            // only expand
            result = solve(s, i, j + 1, set, dp);
        }

        return dp[i][j] = result;
    }
}