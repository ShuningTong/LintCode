import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
class Permutations2 {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        System.out.println(permuteUnique(nums));
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        if (nums == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];
        backtrack(result, temp, nums, used);
        return result;
    }

    public static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> nums, boolean[] used){

        if (temp.size() == nums.size()){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.size(); i++){

            // this is the key point
            // and the reason why we need to sort the nums first
            if (used[i] || i > 0 && nums.get(i) == nums.get(i - 1) && !used[i - 1]){
                continue;
            }
            used[i] = true;
            temp.add(nums.get(i));
            backtrack(result, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
            
        }
    }
}
