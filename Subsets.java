import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// the problem requires all sebsets not in descending order
// so we should sort the original array first
// also, the elements in the original array are distinct


class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    public static void main(String[] args){
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++){
            nums[i] = i + 1;
        }
        // arraylist can be printed out directly
        System.out.println(subsetsRecursive(nums));
    }
    // http://www.programcreek.com/2013/01/leetcode-subsets-java/
    // S(n) stands for the number of subsets for an array of n elements
    // S(n) = S(n - 1) + S(n - 1) + 1
    // U(n) stands for the union of subsets for an array of n elements
    // U(n) = U(n - 1) + {each element in U(n - 1) + one more element} + {the additional element}
    // here, we also want the empty set, so add it at last
    // iterative runtime: 3 * (a + b + c) * 2 ^ n
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();

            for (List<Integer> a: result){
                temp.add(new ArrayList<Integer>(a));
            }

            for (List<Integer> a: temp){
                a.add(nums[i]);
            }

            List<Integer> single = new ArrayList<Integer>();
            single.add(nums[i]);
            temp.add(single);

            result.addAll(temp);
        }
        List<Integer> emptySet = new ArrayList<Integer>();
        result.add(emptySet);
        return result;
    }

    // this method is the most close one to human beings' thoughts
    // https://discuss.leetcode.com/topic/2764/my-solution-using-bit-manipulation
    // runtime: (an + 1/2*bn + c) * 2 ^ n
    public static ArrayList<ArrayList<Integer>> subsetsBit(int[] nums){
        Arrays.sort(nums);
        int length = nums.length;
        int totalNumber = 1 << length;
        ArrayList<ArrayList<Integer>> collection = new ArrayList<>(totalNumber);
        for (int i = 0; i < totalNumber; i++){
            ArrayList<Integer> set = new ArrayList<>();
            for (int j = 0; j < length; j++){
                if ((i & (1 << (length - 1 - j))) != 0){
                    set.add(nums[j]);
                }
            }
            collection.add(set);
        }
        return collection;
    }

    // the recursive method, from https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning

    // how to calculate the runtime for recursive (backtrack) method
    // recursion --> 程序的一种实现方式
    // 函数自己调用自己
    private static ArrayList<ArrayList<Integer>> subsetsRecursive(int[] nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if（nums == null){
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        // find all possible subsets, put them into result
        backtrack(result, temp, nums, 0);
        return result;

    }

    // because java pass by reference, an ArrayList for one level and another ArrayList passed in to next level are actually the same reference. 
    // we use this feature.
    // result grows in the process.
    // temp will add, remove, add, remove, until exhausting all subset possibilities.
    // 递归的三要素之一：定义
    // 把以temp开头的所有子集全部找到，并放到result里面
    public static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] nums, int start){
        // really important, reference
        // 递归三要素之二：极端小的状态
        // if (xxx){
        // return;
        //}
        result.add(new ArrayList<Integer>(temp));
        // for each subset, we need to add until the last element -- through recursion
        // [] [1] [1, 2] [1, 2, 3]
        // remove 3 -- we have finish the first for loop for i == 2
        // remove 2 -- add 3 [1, 3]-- through the for loop
        // remove 3 -- we have finish the second for loop for i = 1
        // remove 1 -- add 2 -- [2] [2, 3]
        // remove 3 -- we have finished another for loop for i = 2
        // remove 2 -- add 3 [3] -- through the for loop
        // remove 3 -- the end

        //递归三要素之三：如何变为更小的状态
        for (int i = start; i < nums.length; i++){
            // ArrayList.add(E e)
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            // 以1开头的都找到了 -- 以2开头的都找到了 -- 以3开头的都找到了 -- 结束
            // ArrayList.remove(int index)
            temp.remove(temp.size() - 1);
        }
    }
}
