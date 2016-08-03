class Fibonacci {
    // 用分治法不会漏掉n == 1和n == 2的边界情况，用动态规划会很容易漏掉
    // 一般，分治法时间复杂度要大于动态规划，空间复杂度要小于动态规划
    // 这里，在实现动态规划时，可以用三个int来不断滚动得出结果，不必建立数组
    /**
     * @param n: an integer
     * @return an integer f(n)
     */

    // this is divide & conquer
    public int fibonacci(int n) {
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // this is dynamic programming
    public int fibonacci(int n){
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        int[] results = new int[n + 1];
        results[1] = 0;
        results[2] = 1;
        for (int i = 3; i < n + 1; i++){
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }
}
