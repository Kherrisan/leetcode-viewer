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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        visit(res,root,0);
        return res;
    }

    void visit(List<List<Integer>> res,TreeNode node,int depth){
        if(node==null){
            return;
        }
        if(depth>=res.size()){
            res.add(new ArrayList());
        }
        res.get(depth).add(node.val);
        visit(res,node.left,depth+1);
        visit(res,node.right,depth+1);
    }
}