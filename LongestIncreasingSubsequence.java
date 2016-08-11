public class LongestIncreasingSubsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */

    // 最后一个数并不一定在这个最长子序列中，因此我们要记录一个max值
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] numLIS = new int[len];
        numLIS[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++){
            numLIS[i] = 1;
            int canLISmax = Integer.MIN_VALUE;

            for (int j = i - 1; j >= 0; j--){
                if (nums[j] < nums[i] && nums[j] > canLISmax && numLIS[j] + 1 > numLIS[i]){
                    numLIS[i] = numLIS[j] + 1;
                    if (nums[j] > canLISmax){
                        canLISmax = nums[j];
                    }
                }
            }

            if (numLIS[i] > max){
                max = numLIS[i];
            }
        }

        return max;
    }
}
