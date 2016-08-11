/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/

// the requirement is: we should call isBadVersion as few as possible
// 把坏版本起始点一直保持在start和end之间(both inclusive)

class FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */

    // 找到第一个坏版本
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (!SVNRepo.isBadVersion(mid)){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)){
            return start;
        } 
        return end;
    }
}
