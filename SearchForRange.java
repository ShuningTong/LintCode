public class SearchForRange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */

    // future improvement: https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation

    // 先找到第一个target值的index1，找不到的话就return [-1, -1]
    // 然后找到比target值大的第一个index2，return [index1, index2 - 1];
    // 第二步可能会找到最后一个target值的index，这样就直接return [index1, index2]

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

        while(start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                end = mid;
            }
        }

        if (nums[start] != target){
            return new int[]{-1, -1};
        }

        int indexFrom = start;
        end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int indexTo;
        if (nums[start] == target){
            indexTo = start;
        } else {
            indexTo = start - 1;
        }

        return new int[]{indexFrom, indexTo};
    }
}
