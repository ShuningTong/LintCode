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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */

/* 要求next()和hasNext()均为O(1) IN AVERAGE
https://discuss.leetcode.com/topic/6604/ideal-solution-using-stack-java/6
*/
public class BSTIterator {
    //@param root: The root of binary tree.

    Stack<TreeNode> stack;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        cur = root;
        while(cur != null){
            stack.push(cur); 
            cur = cur.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.empty();
    }
    
    //@return: return next node
    public TreeNode next() {
        TreeNode node = stack.pop();
        cur = node.right;
        while(cur != null){
            stack.push(cur); 
            cur = cur.left;
        }
        return node;
    }
}
