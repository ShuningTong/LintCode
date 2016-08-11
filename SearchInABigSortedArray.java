/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      // if you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.
 *      public int get(int index);
 * }
 */
// a big sorted array with positive integers sorted by ascending order
// we can not get the length of the whole array
// have to use an ArrayReader
// Find the first index of a target number
// should be O(logk) where k is the first index of the target numer
// return -1 if not exist
public class SearchInABigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */

    public static void main(String[] args){
        ArrayReader ar = new ArrayReader();
        System.out.println(searchBigSortedArray(ar, 6));
        System.out.println(searchBigSortedArray(ar, 15));

    }

    public static int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null){
            return -1;
        }
        int i = 1;

        // this indicates we can skip this while loop from two possible exits
        // 找到第一个右边界大于等于目标值的点
        while(reader.get(i - 1) < target){
            i *= 2;
        }

        // if loop exits when reader.get(i) == Integer.MAX_VALUE, 
        // we are still not sure if the target exists in the array
        // 这一点很容易出错

        int start = i / 2;
        int end = i;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target){
                start = mid + 1;
            } else if (reader.get(mid) > target){
                end = mid - 1;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target){
            return start;
        }
        if (reader.get(end) == target){
            return end;
        }
        return -1;
    }
}
