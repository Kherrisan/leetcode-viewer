/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parents=new HashMap();
        visit(root.left,root,parents);
        visit(root.right,root,parents);
        Set<TreeNode> pPath=new HashSet();
        pPath.add(p);
        while(p!=null){
            pPath.add(parents.get(p));
            p=parents.get(p);
        }
        while(q!=null&!pPath.contains(q)){
            q=parents.get(q);
        }
        return q;
    }

    void visit(TreeNode node,TreeNode parent,Map<TreeNode,TreeNode> map){
        if(node==null){
            return;
        }
        map.put(node,parent);
        visit(node.left,node,map);
        visit(node.right,node,map);
    }
}