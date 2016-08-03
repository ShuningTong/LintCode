/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 给点的一点一定在树中
// 如果该点没有inorder successor, return null
// 允许O(h)的runtime，h是树的高度

// 在指针向左移动时，用一个node来记录当前root，因为它可能就是我们要找的successor
// 这种方法只能用在BST中，而不能用在BT中
public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null && root != p){
            if (root.val > p.val){
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null){
            return null;
        }
        if (root.right == null){
            return successor;
        }
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
