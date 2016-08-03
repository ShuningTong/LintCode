public class SearchInRotatedSortedArray {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */


    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
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
            } else {
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
            }
        }
        if (start != end){
            return -1;
        } else {
            if (nums[start] == target){
                return start;
            } else {
                return -1;
            }
        }
    }
}
