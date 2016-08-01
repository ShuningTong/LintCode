import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */

    public static void main(String[] args){
        int[] candidates = new int[7];
        candidates[0] = 10;
        candidates[1] = 1;
        candidates[2] = 6;
        candidates[3] = 7;
        candidates[4] = 2;
        candidates[5] = 1;
        candidates[6] = 5;
        System.out.println(combinationSum(candidates, 8));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null){
            return new ArrayList<ArrayList<Integer>>();
        }else if (candidates.length == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, temp, candidates, target, 0, candidates.length - 1);
        return result;
    }

    public static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] candidates, int target, int sum, int start){
        if (sum == target){
            result.add(new ArrayList<Integer>(temp));
        }else{
            for (int i = start; i >= 0; i--){
                if (i < start && candidates[i] == candidates[i + 1]){
                    continue;
                }
                int cur = candidates[i];
                if (sum + cur > target){
                    continue;
                }else{
                    // this is for making all combination sets sorted
                    temp.add(0, cur);
                    sum += cur;
                }
                backtrack(result, temp, candidates, target, sum, i);
                temp.remove(0);
                sum -= cur;
            }
        }
    }
}
