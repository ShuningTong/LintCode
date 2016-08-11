/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    // 遍历了所有点，看经过它的path sum
    // 返回经过cur的最大单边path sum
    // 如果经过cur的path sum超过max的话，更新max
    private int helper(TreeNode cur){
        if (cur == null){
            return 0;
        }

        int left = helper(cur.left);
        int right = helper(cur.right);

        if (left < 0){
            left = 0;
        }
        if (right < 0){
            right = 0;
        }

        int pathCur = left + right + cur.val;
        if (pathCur > max){
            max = pathCur;
        }

        return cur.val + Math.max(left, right);
    }
}
