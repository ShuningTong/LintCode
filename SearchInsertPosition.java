public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array, no duplicates
     * param target :  an integer to be inserted
     * return : an integer
     */

    public static void main(String[] args){
        int[] a = new int[4];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 6;
        System.out.println(searchInsert(a, 5));
        System.out.println(searchInsert(a, 2));
        System.out.println(searchInsert(a, 7));
        System.out.println(searchInsert(a, 0));
    }

    public static int searchInsert(int[] a, int target) {
        if (a == null){
            return 0;
        }
        int start = 0;
        int end = a.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if (a[mid] < target){
                start = mid + 1;
            }else if (a[mid] > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }

        return start;
    }
}
