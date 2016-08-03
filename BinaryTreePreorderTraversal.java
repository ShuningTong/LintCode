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
import java.util.Stack;
public class BinaryTreePreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */

    // 把一个树用preoder遍历一遍，可以分解为：
    // 先把它root值放进结果，再遍历它leftchild，再遍历它rightchild
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        helper(root, results);
        return results;
    }

    // 把所有元素用preorder的形式加入results，返回results
    // 这个方法跟搜索类题目很像，并且不属于divide & conquer
    public void helper(TreeNode cur, ArrayList<Integer> results){
        // 极小值处理
        if (cur == null){
            return;
        }
        // 如何缩窄
        results.add(cur.val);
        helper(cur.left, results);
        helper(cur.right, results);
    }

    // 这是divide & conquer
    public ArrayList<Integer> preorderTraversalDC(TreeNode cur) {
        ArrayList<Integer> results = new ArrayList<>();
        if (cur == null){
            return results;
        }
        results.add(cur.val);
        results.addAll(preorderTraversalDC(cur.left));
        results.addAll(preorderTraversalDC(cur.right));
        return results;
    }

    // https://discuss.leetcode.com/topic/6493/accepted-iterative-solution-in-java-using-stack
    // this one is even better:
    // http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/

    // Stack的push和pop方法要熟悉
    // root等于null的边界情况容易漏掉
    public ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            results.add(cur.val);
            if (cur.right != null){
                stack.push(cur.right); 
            }   
            if (cur.right != null){
                stack.push(cur.left);
            }
        }
        return results;
    }

}
