class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // 1. Base profit
        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        // 2. Prefix sums
        long[] origPrefix = new long[n + 1];
        long[] pricePrefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            origPrefix[i + 1] = origPrefix[i] + (long) strategy[i] * prices[i];
            pricePrefix[i + 1] = pricePrefix[i] + prices[i];
        }

        long maxGain = 0;
        int half = k / 2;

        // 3. Sliding window
        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long originalWindowProfit = origPrefix[r] - origPrefix[l];
            long newRightHalfProfit = pricePrefix[r] - pricePrefix[mid];

            long gain = newRightHalfProfit - originalWindowProfit;
            maxGain = Math.max(maxGain, gain);
        }

        return baseProfit + maxGain;
    }
}
