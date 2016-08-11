public class UniquePaths2 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */

    // 注意除了在障碍格中为1的地方是不能到达的，还有一些地方也是不能到达的，比方说第一列中间有个障碍，
    // 那么该列中障碍之后的那些地方即使没有障碍，我们也无法到达。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] matrix = new int[m][n];
        boolean ob = false;
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1 || ob){
                matrix[i][0] = 0;
                ob = true;
            } else {
                matrix[i][0] = 1;
            } 
        }
        ob = false;
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1 || ob){
                matrix[0][j] = 0;
                ob = true;
            } else {
                matrix[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 0){
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix[m - 1][n - 1];
    }
}
