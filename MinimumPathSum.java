public class MinimumPathSum {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    // T(m, n) = Math.min(T(m - 1, n), T(m, n - 1))
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        int pathSum = 0;
        for (int i = 0; i < m; i++){
            pathSum += grid[i][0];
            matrix[i][0] = pathSum;
        }
        pathSum = matrix[0][0];
        for (int j = 1; j < n; j++){
            pathSum += grid[0][j];
            matrix[0][j] = pathSum;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + grid[i][j];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
