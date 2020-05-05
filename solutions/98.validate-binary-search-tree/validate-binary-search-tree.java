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
    public boolean isValidBST(TreeNode root) {
        if(root== null){
            return true;
        }
        return isValidBST(root.left,root.val,Long.MIN_VALUE)&&isValidBST(root.right,Long.MAX_VALUE,root.val);
    }

    boolean isValidBST(TreeNode node,long upper,long bound){
        if(node==null){
            return true;
        }
        return node.val<upper&&node.val>bound&&isValidBST(node.left,node.val,bound)&&isValidBST(node.right,upper,node.val);
    }

}