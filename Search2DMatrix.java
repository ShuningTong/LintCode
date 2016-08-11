public class Search2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    // O(log(n) + log(m)) time

    public static void main(String[] args){
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[1][0] = 10;
        matrix[1][1] = 11;

        System.out.println(searchMatrix(matrix, 4));
        System.out.println(searchMatrix(matrix, 10));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m - 1;
        int row = 0;

        // 找到第一个last number大于等于目标值的行
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if (matrix[mid][n - 1] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (matrix[start][n - 1] >= target){
            row = start;
        } else if (matrix[end][n - 1] >= target){
            row = end;
        } else {
            return false;
        }

        // 普通的二分查找
        start = 0;
        end = n - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if (matrix[row][mid] < target){
                start = mid + 1;
            } else if (matrix[row][mid] > target){
                end = mid - 1;
            } else {
                return true;
            }
        }
        if (matrix[row][start] == target || matrix[row][end] == target){
            return true;
        }
        return false;
    }
}
