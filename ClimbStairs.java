public class ClimbStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */

    public int climbStairs(int n) {
        if (n == 2){
            return 2;
        }
        if (n == 1){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 容易漏掉n == 0时候的边界处理
    public int climbStairsDP(int n){
        if (n == 0){
            return 1;
        }
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n + 1; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
