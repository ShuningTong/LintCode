public class SearchForRange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */

    // future improvement: https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation

    // 先找到第一个等于target值的位置，找不到的话就return [-1, -1]
    // 然后找到最后一个等于target值的位置，return [index1, index2]

    public static void main(String[] args){
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] range = searchRange(nums, 3);
        for (int i: range){
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                end = mid;
            }
        }

        int indexFrom = 0;
        if (nums[start] == target){
            indexFrom = start;
        } else if (nums[end] == target){
            indexFrom = end;
        } else {
            return new int[]{-1, -1};
        }

        start = indexFrom;
        end = nums.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target){
            return new int[](indexFrom, end);
        }
        return new int[](indexFrom, start);
    }
}
