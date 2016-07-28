import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
class Subsets2 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        System.out.println(subsetsWithDupBit(nums));
    }

    // the modified version based on the recursion method in Subsets.java
    // come from https://discuss.leetcode.com/topic/22638/very-simple-and-fast-java-solution
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(result, temp, nums, 0);
        return result;
    }

    public static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> nums, int i){
        result.add(new ArrayList<Integer>(temp));
        while(i < nums.size()){
            temp.add(nums.get(i));
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
            i++;
            // this additional statement has to be after the recursion statement
            while (i < nums.size() && nums.get(i) == nums.get(i - 1)){
                i++;
            }
        }
    }

    // the modified version based on the iterative method in Subsets.java
    // come from: https://discuss.leetcode.com/topic/5734/accepted-java-iterative-solution
    public static ArrayList<ArrayList<Integer>> subsetsWithDupIterative(ArrayList<Integer> nums){
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int nprev = 0;

        for (int i = 0; i < nums.size(); i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            if ( i > 0 && nums.get(i) != nums.get(i - 1)){
                nprev = result.size();
            }

            for (int j = result.size() - nprev; j < result.size(); j++){
                temp.add(new ArrayList<Integer>(result.get(j)));
            }

            for (ArrayList<Integer> a: temp){
                a.add(nums.get(i));
            }

            if (i == 0 || (i > 0 && nums.get(i) != nums.get(i - 1))){
                ArrayList<Integer> single = new ArrayList<Integer>();
                single.add(nums.get(i));
                temp.add(single);
            }
        
            nprev = temp.size();

            result.addAll(temp);
        }
        ArrayList<Integer> emptySet = new ArrayList<Integer>();
        result.add(emptySet);
        return result;
    }

    // the modified version based on Bit method in Subsets.java
    // https://www.zybuluo.com/Yano/note/255359#subsets-ii
    // looks like this one takes much longer time then the previous two
    // probably because we have a HashSet and copy everything from HashSet to ArrayList
    public static ArrayList<ArrayList<Integer>> subsetsWithDupBit(ArrayList<Integer> nums){
        Collections.sort(nums);
        int length = nums.size();
        int totalNumber = 1 << length;
        Set<ArrayList<Integer>> collection = new HashSet<>();
        for (int i = 0; i < totalNumber; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++){
                if ((i & (1 << (length - 1 - j))) != 0){
                    list.add(nums.get(j));
                }
            }
            collection.add(list);
        }
        return new ArrayList<ArrayList<Integer>>(collection);
    }
}
