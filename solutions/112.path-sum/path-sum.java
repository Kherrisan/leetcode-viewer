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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return dfs(root,sum);
    }

    boolean dfs(TreeNode node,int sum){
        if(node.left==null&&node.right==null){
            return node.val==sum;
        }
        
        boolean res=false;
        if(node.left!=null){
            res=res||dfs(node.left,sum-node.val);
        }
        if(node.right!=null){
            res=res||dfs(node.right,sum-node.val);
        }
        return res;
    }
}