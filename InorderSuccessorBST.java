/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 给点的一点一定在树中
 如果该点没有inorder successor, return null
 允许O(h)的runtime，h是树的高度
 本身在BST中查找一个数值就是O(h)
 所以就两种情况：找到的点有rightchild，找到的点没有rightchild
 */


// 在指针向左移动时，用一个node来记录当前root，因为它可能就是我们要找的successor
// 这种方法只能用在BST中，而不能用在BT中

// 这里的root == null只可能当树本身是空树（root为null），p也是一个null点时才有可能
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

    /* 如果给定的一点不一定出现在树中，求比该点大的树中最小点的话
       那么只要让root == null时，返回successor即可，
       如果是本身为空树，则successor为null，
       如果已经到达目标点在树中应在的位置，那么successor为所要求的点
       如果一直都是右移，没有过左移，那么successor仍然为null
       */
}
