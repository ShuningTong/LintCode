/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class LowestCommonAncestor {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        Stack<ParentTreeNode> stackForA = getPath2Root(A);
        Stack<ParentTreeNode> stackForB = getPath2Root(B);

        ParentTreeNode ancestor = null;
        while (!stackForA.empty() && !stackForB.empty()){
            ParentTreeNode a = stackForA.pop();
            ParentTreeNode b = stackForB.pop();
            if (a == b){
                ancestor = a;
            } else {
                break;
            }
        }
        return ancestor;
    }

    // 重复使用的功能单独拎出来
    private Stack<ParentTreeNode> getPath2Root(ParentTreeNode node){
        Stack<ParentTreeNode> stack = new Stack<>();
        while(node != null){
            stack.push(node);
            node = node.parent;
        }
        return stack;
    }
}
