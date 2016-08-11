public class SearchInRotatedSortedArray2 {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */

    // 这个版本是从1改了一点点
    // 这个讨论中的版本似乎与我的有点像
    // https://discuss.leetcode.com/topic/310/when-there-are-duplicates-the-worst-case-is-o-n-could-we-do-better/2

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]){
                if (target == nums[mid]){
                    return mid;
                } else if (target == nums[end]){
                    return end;
                } else if (target > nums[mid]){
                    start = mid + 1;
                } else if (target < nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] < nums[end]) {
                if (target == nums[end]){
                    return end;
                } else if (target == nums[mid]){
                    return mid;
                } else if (target > nums[end]){
                    end = mid - 1;
                } else if (target < nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target == nums[mid]){
                    return mid;
                } else {
                    end--;
                }
            }
        }
        return -1;
    }
}
