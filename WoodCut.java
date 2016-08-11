public class WoodCut {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    /* 因为需要找到最大长度，又因为它属于二分法题目，所以我们先找到最小长度和木头允许的最大长度，
    然后用二分法来做，始终把我们要找到的那个最大长度放在start和end中间(both inclusive)
    一直到start和end相邻，判断这两个数字哪个满足条件即可。
    这样的思路虽然不是非常巧妙，但也节省了不少工作量，我自己并没有想到。
    */
    public int woodCut(int[] L, int k) {
        int max = 0;
        for (int i = 0; i < L.length; i++){
            max = Math.max(max, L[i]);
        }

        int start = 1; 
        int end = max;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(L, end) >= k){
            return end;
        }
        if (count(L, start) >= k){
            return start;
        }
        return 0;
    }

    public int count(int[] L, int length){
        int sum = 0;
        for (int i = 0; i < L.length; i++){
            sum += L[i] / length;
        }
        return sum;
    }
}
