public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        boolean[] temp = new boolean[len];
        temp[0] = true;
        
        for (int i = 1; i < len; i++){
            for (int j = 1; i - j >= 0; j++){
                if (temp[i - j] && nums[i - j] >= j){
                    temp[i] = true;
                    break;
                }
            }
        }
        return temp[len - 1];
    }

    // 不太清楚为什么叫做这种方法是greedy
    public boolean canJumpGreedy(int[] nums) {
        // think it as merging n intervals
        if (nums == null || nums.length == 0) {
            return false;
        }
        int farthest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= farthest && nums[i] + i >= farthest) {
                farthest = nums[i] + i;
            }
        }
        return farthest >= nums.length - 1;
    }
}
