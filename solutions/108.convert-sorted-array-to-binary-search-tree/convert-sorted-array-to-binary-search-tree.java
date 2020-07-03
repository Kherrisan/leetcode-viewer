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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums,0,nums.length-1);
    }

    TreeNode bst(int[] nums,int left,int right){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode n=new TreeNode(nums[mid]);
        n.left=bst(nums,left,mid-1);
        n.right=bst(nums,mid+1,right);
        return n;
    }
}