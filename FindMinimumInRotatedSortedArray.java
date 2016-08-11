public class FindMinimumInRotatedSortedArray {
    /**
     * @param num: a rotated sorted array, assume no duplicates
     * @return: the minimum number in the array
     */

    // 一直把最小点保持在start和end之间(both inclusive)，直到：
    // 1. nums[start] < nums[end] 说明该部分是从最小点开始的
    // 2. start == end 说明已经逼到最小点
    // 第一种情况如果不catch， 最后也会变成第二种

    // 找到第一个小于等于最后一个数的数
    // 注意边界处理，以及返回的是位置还是答案
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (nums[start] <= target){
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
