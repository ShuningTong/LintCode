public class JumpGame2 {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++){
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++){
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i){
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[nums.length - 1];
    }
}
