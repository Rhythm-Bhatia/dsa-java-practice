class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] rowSum = new int[m][n];

        // Row prefix sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = mat[i][j] + (j == 0 ? 0 : rowSum[i][j - 1]);
            }
        }

        // Largest → smallest
        for (int side = Math.min(m, n); side >= 1; side--) {
            for (int i = 0; i + side <= m; i++) {
                for (int j = 0; j + side <= n; j++) {

                    int sum = 0;
                    for (int k = i; k < i + side; k++) {
                        sum += rowSum[k][j + side - 1]
                             - (j == 0 ? 0 : rowSum[k][j - 1]);
                    }

                    // ✅ Correct condition
                    if (sum <= threshold) {
                        return side;
                    }
                }
            }
        }
        return 0;
    }
}
