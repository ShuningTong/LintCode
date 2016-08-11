public class SearchInRotatedSortedArray {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     * You may assume no duplicate exists in the array.
     */


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]){
                if (target <= nums[mid] && target >= nums[start]){
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target < nums[start]){
                    start = mid;
                } else {
                    end = mid - 1;
                }
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
