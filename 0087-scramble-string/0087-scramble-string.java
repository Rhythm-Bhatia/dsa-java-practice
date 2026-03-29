import java.util.*;

class Solution {

    Map<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    private boolean solve(String s1, String s2) {

        String key = s1 + "#" + s2;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (s1.equals(s2)) {
            dp.put(key, true);
            return true;
        }

        if (s1.length() != s2.length()) {
            dp.put(key, false);
            return false;
        }

        int n = s1.length();

        for (int index = 1; index < n; index++) {

            // NO SWAP
            boolean temp1 =
                solve(s1.substring(0, index), s2.substring(0, index)) &&
                solve(s1.substring(index), s2.substring(index));

            // SWAP
            boolean temp2 =
                solve(s1.substring(0, index), s2.substring(n - index)) &&
                solve(s1.substring(index), s2.substring(0, n - index));

            if (temp1 || temp2) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}