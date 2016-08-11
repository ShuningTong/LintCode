public class Search2DMatrix2 {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */

    // 要求时间复杂度O(m + n)，空间复杂度O(1)

    // 这道题lintcode与leetcode的版本有一些变化，思路是一样的
    // 要求出目标数值总共出现多少次，我们只需要加一个count的变量记录
    // 之所以可以用上每次都排除掉一排或一列的方法是因为每排每列都是排好序的，而且同一排或同一列没有重复数字

    // 可以想一想如果允许每一排或每一列有重复数字会怎么样。
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(x < m && y >= 0){
            if (matrix[x][y] < target){
                x++;
            } else if (matrix[x][y] > target){
                y--;
            } else {
                count++;
                x++;
                y--;
            }
        }
        return count;
    }
}
