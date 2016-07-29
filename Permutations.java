import java.util.ArrayList;
class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(permute(nums));
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if (nums == null){
            return new ArrayList<Integer>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(result, temp, nums);
        return result;
    }

    public static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> nums){

        if (temp.size() == nums.size()){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.size(); i++){
            if (!temp.contains(nums.get(i))){
                temp.add(nums.get(i));
                backtrack(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
