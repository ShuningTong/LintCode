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
public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */

    TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        helper(root, a, b);
        return ancestor;
    }

    // 返回该点开始的树中是否包含a或者b
    // 如果该点左子，右子和它本身这三个要素中有两个包含a或b，那么该点就是lowest ancestor
    // 还有一种情况，就是该点就是a和b，那么该点也是lowest ancestor，很容易忽略
    private boolean helper(TreeNode cur, TreeNode a, TreeNode b){
        if (cur == null){
            return false;
        }

        boolean left = helper(cur.left, a, b);
        boolean right = helper(cur.right, a, b);

        if ((left && right) || ((left || right) && (cur.val == a || cur.val == b))){
            ancestor = cur;
            return true;
        }

        return left || right || (cur.val == a || cur.val == b);
    }

    // 分治
    // 前提是a和b一定都在树中
    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b){
        if (root == null || root == a || root == b){
            return root;
        }

        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);
        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
