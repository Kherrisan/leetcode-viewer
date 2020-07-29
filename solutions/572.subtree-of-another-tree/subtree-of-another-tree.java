/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null){
            return true;
        }else if(s==null){
            return false;
        }
        return equals(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    boolean equals(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }else if(s==null||t==null){
            return false;
        }else{
            return s.val==t.val && equals(s.left,t.left) && equals(s.right,t.right);
        }
    }
}