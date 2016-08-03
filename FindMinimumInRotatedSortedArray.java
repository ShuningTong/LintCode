public class FindMinimumInRotatedSortedArray {
    /**
     * @param num: a rotated sorted array, assume no duplicates
     * @return: the minimum number in the array
     */

    // 一直把最小点保持在start和end之间(both inclusive)，直到：
    // 1. nums[start] < nums[end] 说明该部分是从最小点开始的
    // 2. start == end 说明已经逼到最小点
    // 第一种情况如果不catch， 最后也会变成第二种

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            if (nums[start] < nums[end]){
                return nums[start];
            }
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]){
                start = mid + 1;
            } else if (nums[mid] < nums[end]){
                end = mid;
            }
        }
        return nums[start];
    }
}
