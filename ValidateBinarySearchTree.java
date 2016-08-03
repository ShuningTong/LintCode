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

// helper class
class ResultType{
    boolean is_bst;
    int maxValue, minValue;

    ResultType(boolean is_bst, int maxValue, int minValue){
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}

public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */

    // divide and conquer
    // there is another traverse method on jiuzhang which is difficult to understand
    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }

    private ResultType validateHelper(TreeNode cur){
        if (cur == null){
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultType left = validateHelper(cur.left);
        ResultType right = validateHelper(cur.right);

        if (!left.is_bst || !right.is_bst){
            return new ResultType(false, 0, 0);
        }

        if ((cur.left != null && left.maxValue >= cur.val) || (cur.right != null && right.minValue <= cur.val)){
            return new ResultType(false, 0, 0);
        }

        return new ResultType(true, Math.max(cur.val, right.maxValue), Math.min(cur.val, left.minValue));
    }
}
