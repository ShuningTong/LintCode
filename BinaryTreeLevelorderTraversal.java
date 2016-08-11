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
 
 
public class BinaryTreeLevelorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */

    // version1: BFS
    //容易漏掉root == null的边界处理
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> result = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
               TreeNode cur = temp.pop();
                result.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                } 
            }
            results.add(result);
        }
        return results;
    }

    // 每一层都通过DFS来到达，最外面的大循环用一个参数记录当前层数
    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        int maxLevel = 0;
        while(true){
            ArrayList<Integer> result = new ArrayList<>();
            dfs(root, result, 0, maxLevel);
            if (result.size() == 0){
                break;
            }
            results.add(result);
            maxLevel++;
        }
        return results;
    }

    public void dfs(TreeNode cur, ArrayList<Integer> result, int curLevel, int maxLevel){
        if (cur == null){
            return;
        }
        if (curLevel == maxLevel){
            result.add(cur.val);
            return;
        }
        dfs(cur.left, result, curLevel + 1, maxLevel);
        dfs(cur.right, result, curLevel + 1, maxLevel);
    }
}
