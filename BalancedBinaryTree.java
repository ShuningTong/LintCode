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
public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */

    //某一点是否balance与它两个分叉点是否balance和两个分叉点depth的差是否大于1有关系
    //递归三要素之一：定义
    //判断root是否balanced
    public boolean isBalanced(TreeNode cur) {
        //递归三要素之二：极端小的状态
        if (cur == null){
            return true;
        }
        //递归三要素之三：如何变为更小的状态
        return isBalanced(cur.left) && isBalanced(cur.right) 
                && Math.abs(helperDepth(cur.left) - helperDepth(cur.right)) <= 1;
    }

    public int helperDepth(TreeNode cur){
        if (cur == null){
            return 0;
        }
        return Math.max(helperDepth(cur.left) + 1, helperDepth(cur.right) + 1);
    }


    //继承上面的思路，可以用-1来表示某点不balance，用该点实际depth来表示balance
    public boolean isBalancedImproveRuntime(TreeNode root){
        return helperDepth2(root) != -1;
    }

    public int helperDepth2(TreeNode cur){
        if (cur == null){
            return 0;
        }
        int left = helperDepth2(cur.left);
        int right = helperDepth2(cur.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
