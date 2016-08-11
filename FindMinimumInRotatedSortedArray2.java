public class FindMinimumInRotatedSortedArray2 {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    // the original array main contain duplicates
    // 一直把最小点保持在start和end之间(both inclusive)
    // 不用比较nums[start]与nums[mid]，只要比较nums[mid]与nums[end]就够了
    // 当出现nums[mid] == nums[end]时，我们不知道如何缩窄，只能将end往前一步步缩窄
    // 即使nums[end]就是那个最小值，我们仍然保留有nums[mid]就够了

    /*  这道题目在面试中不会让写完整的程序
        只需要知道最坏情况下 [1,1,1....,1] 里有一个0
        这种情况使得时间复杂度必须是 O(n)
        因此写一个for循环就好了。
        如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
        反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
        */

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]){
                start = mid + 1;
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else {
                end--;
            }
        }
        if (nums[start] <= nums[end]){
            return nums[start];
        }
        return nums[end];
    }
}
