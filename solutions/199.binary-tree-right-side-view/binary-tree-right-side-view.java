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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList();
        visit(root,1,list);
        return list;
    }

    void visit(TreeNode node,int depth,List<Integer> res){
        if(node==null){
            return;
        }
        if(depth>res.size()){
            res.add(node.val);
        }
        visit(node.right,depth+1,res);
        visit(node.left,depth+1,res);
    }
}