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
public class BinaryTreeMaximumPathSum2 {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    // path必须包括root，但另一端可以是树中任何一点，path至少包括一点

    // 得到该点出发的最大pathSum
    public int maxPathSum2(TreeNode cur) {
        // 极小值
        if (cur == null){
            return 0;
        }
        // 缩窄
        return Math.max(Math.max(maxPathSum2(cur.left), maxPathSum2(cur.right)) + cur.val, cur.val);
    }
}
