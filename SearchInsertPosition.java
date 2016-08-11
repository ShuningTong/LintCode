public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array, no duplicates
     * param target :  an integer to be inserted
     * return : an integer
     */

    /* Given nums sorted array and nums target value, 
    return the index if the target is found. 
    If not, return the index where it would be if it were inserted in order.

    You may assume NO duplicates in the array.
    */

    public static void main(String[] args){
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 3;
        nums[2] = 5;
        nums[3] = 6;
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }

    // 找到第一个大于等于目标值的点
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            }else if (nums[mid] > target){
                end = mid;
            }else{
                // because no duplicates
                return mid;
            }
        }
        if (nums[start] >= target){
            return start;
        }
        if (nums[end] >= target){
            return end;
        }

        return end + 1;
    }
}
