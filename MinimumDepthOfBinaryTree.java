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

/* The minimum depth is the number of nodes (inclusive) along the shortest path 
from the root node down to the nearest leaf node.

根节点不是一个叶子节点
如果只有根节点自己，那么最小深度为1
如果是  
  1
 / \ 
2   3
   / \
  4   5
最小深度为2

*/
public class MinimumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    // 分治
    // 分成两个方法是因为根节点为null和其他节点为null的处理情况不一样
    // Minimum depth = Math.min(leftchild.depth, rightchild.depth) + 1
    // null子的最小深度为非法值，因为我们想要的是从根节点到叶子节点的距离
    // null不是一个叶子节点
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode cur){
        if (cur == null){
            return Integer.MAX_VALUE;
        }
        if (cur.left == null && cur.right == null){
            return 1;
        }
        int left = getMin(cur.left);
        int right = getMin(cur.right);
        return Math.min(left, right) + 1;
    }
}
