public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    // Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0){
            return 0;
        }
        int rows = triangle.length;
        int[] temp = new int[rows];
        for (int i = 0; i < rows; i++){
            temp[i] = triangle[rows - 1][i];
        }
        for (int j = rows - 2; j >= 0; j--){
            for (int k = 0; k <= j; k++){
                temp[k] = Math.min(temp[k], temp[k + 1]) + triangle[j][k];
            }
        }
        return temp[0];

    }
}
