public class Search2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */

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
        while(start <= end){
            int mid = (start + end) / 2;
            if (matrix[mid][n - 1] < target){
                start = mid + 1;
            } else if (matrix[mid][0] > target){
                end = mid - 1;
            } else {
                row = mid;
                break;
            }
        }
        if (start > end){
            return false;
        }
        start = 0;
        end = n - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if (matrix[row][mid] < target){
                start = mid + 1;
            } else if (matrix[row][mid] > target){
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
