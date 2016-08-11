public class ClassicalBinarySearch {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */

    /* Find any position of a target number in a sorted array. 
    Return -1 if target does not exist.
    */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target){
                start = mid + 1;
            } else {
                return mid;
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
