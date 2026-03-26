import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        Map<String, Integer> dp = new HashMap<>();
        return solve(cuts, 0, n, dp);
    }

    private int solve(int[] cuts, int i, int j, Map<String, Integer> dp) {
        String key = i + "," + j;

        if(dp.containsKey(key)) return dp.get(key);

        int min = Integer.MAX_VALUE;
        boolean found = false;

        for(int k = 0; k < cuts.length; k++) {
            if(cuts[k] > i && cuts[k] < j) {
                found = true;

                int cost = solve(cuts, i, cuts[k], dp) +
                           solve(cuts, cuts[k], j, dp) +
                           (j - i);

                min = Math.min(min, cost);
            }
        }

        int result = found ? min : 0;
        dp.put(key, result);
        return result;
    }
}