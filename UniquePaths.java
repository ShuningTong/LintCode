public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */

    // T(m, n) = T(m-1, n) + T(m, n-1)
    public int uniquePaths(int m, int n) {
        if (m == 1){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public int uniquePathsDP(int m, int n){
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            matrix[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            matrix[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
