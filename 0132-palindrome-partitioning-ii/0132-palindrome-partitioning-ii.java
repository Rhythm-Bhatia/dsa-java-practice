class Solution {

    public int minCut(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];  // memo
        return solve(0, s, dp) - 1;
    }

    private int solve(int i, String s, Integer[] dp) {
        if (i == s.length()) return 0;

        if (dp[i] != null) return dp[i];

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + solve(j + 1, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}