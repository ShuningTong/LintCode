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
public class MaximumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    // parent.depth = Math.max(leftchild.depth + 1, rightchild.depth + 1)
    //递归三要素之一：定义
    //把root.depth找到
    public int maxDepth(TreeNode cur) {
        //递归三要素之二：极端小的状态
        if (cur == null){
            return 0;
        }
        //递归三要素之三：如何变为更小的状态
        return Math.max(maxDepth(cur.left) + 1, maxDepth(cur.right) + 1);
    }
}
