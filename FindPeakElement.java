class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    // 相邻的元素不相等。
    // 可能有很多个peek，我们只用找到其中一个。

    // 判断中间一段长度为1的线段的走势，
    // 如果是上升的，那么我们转而看mid2到end
    // 如果是下降的，那么转而看start到mid1
    // 不管是哪种，我们都把某一个peek保持在两点之间(both inclusive)
    // 直到逼为start == end
    public int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid1 = start + (end - start) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]){
                start = mid2;
            } else {
                end = mid1;
            }
        }
        return start;
    }
}
