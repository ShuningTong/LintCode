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
        // this is more clear, but we can also do:
        // while(reader.get(i) < target){
        //      i *= 2;
        //}

        // this indicates we can skip this while loop from two possible exits
        while (reader.get(i) != Integer.MAX_VALUE){
            if (reader.get(i) < target){
                i *= 2;
            } else {
                break;
            }
        }

        // if loop exits when reader.get(i) == Integer.MAX_VALUE, 
        // we are still not sure if the target exists in the array

        int start = i / 2 + 1;
        int end = i;
        if (i == 1){
            start = 0;
        }

        while(start <= end){
            int mid = (start + end) / 2;
            if (reader.get(mid) == Integer.MAX_VALUE){
                end = mid - 1;
            } else {
                if (reader.get(mid) < target){
                    start = mid + 1;
                } else if (reader.get(mid) > target){
                    end = mid - 1;
                } else {
                    if (start == end){
                        return start;
                    }
                    end = mid;
                }
            }
        }
        return -1;
    }
}
