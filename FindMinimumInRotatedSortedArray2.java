public class FindMinimumInRotatedSortedArray2 {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    // the original array main contain duplicates
    // 一直把最小点保持在start和end之间(both inclusive)，直到：
    // start == end 说明已经逼到最小点
    // 不用比较nums[start]与nums[mid]，只要比较nums[mid]与nums[end]就够了
    // 当出现nums[mid] == nums[end]时，我们不知道如何缩窄，只能将end往前一步步缩窄
    // 即使nums[end]就是那个最小值，我们仍然保留有nums[mid]就够了

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]){
                start = mid + 1;
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
