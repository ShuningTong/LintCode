import java.util.ArrayList;
public class Combinations {

    public static void main(String[] args){
        System.out.println(combine(4, 2));
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (k < 0 || n < 1 || k > n){
            return null;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        combineHelper(results, combination, nums, k, 0);
        return results;
    }

    private static void combineHelper(ArrayList<ArrayList<Integer>> results, 
                            ArrayList<Integer> combination, 
                            int[] nums, int k, int indexFrom){
        if (combination.size() == k){
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = indexFrom; i < nums.length; i++){
            combination.add(nums[i]);
            combineHelper(results, combination, nums, k, i + 1);
            combination.remove(combination.size() - 1);
        } 
    }

    // we should notice that S(n, k) = S(n - 1, k - 1) + S(n - 1, k)
    // this function is really useful when we want to calculate the total number of combinations
    // for this problem, we want all combinations, not the number
    // To use this function to get all combinations:
    //https://discuss.leetcode.com/topic/12537/a-short-recursive-java-solution-based-on-c-n-k-c-n-1-k-1-c-n-1-k
}
