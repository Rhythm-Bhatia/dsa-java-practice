class Solution {
    public int bestClosingTime(String c) {
        int n = c.length();

        int[] pref = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1];
            if (c.charAt(i - 1) == 'N') {
                pref[i]++;
            }
        }

        int[] suff = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = suff[i + 1];
            if (c.charAt(i) == 'Y') {
                suff[i]++;
            }
        }

        int min_p = Integer.MAX_VALUE, best = 0;
        for (int j = 0; j <= n; j++) {
            int p = pref[j] + suff[j];
            if (p < min_p) {
                min_p = p;
                best = j;
            }
        }

        return best;
    }
}