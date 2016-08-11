class FirstPositionOfTarget {
    /**
     * @param nums: The integer array, may have duplicates
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */

    public static void main(String[] args){
        int[] nums = new int[7];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 3;
        nums[4] = 4;
        nums[5] = 5;
        nums[6] = 10;
        System.out.println(binarySearch(nums, 3));
    }
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}
