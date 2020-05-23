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
    private Map<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int N=preorder.length;
        for(int i=0;i<N;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,N-1,0,N-1);
    }

    TreeNode buildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        int root_val=preorder[preorder_left];
        int inorder_root = map.get(root_val);
        int sizeOfLeftSub=inorder_root-inorder_left;
        TreeNode node=new TreeNode(root_val);
        node.left=buildTree(preorder,inorder,preorder_left+1,preorder_left+sizeOfLeftSub,inorder_left,inorder_root-1);
        node.right=buildTree(preorder,inorder,preorder_left+sizeOfLeftSub+1,preorder_right,inorder_root+1,inorder_right);
        return node;
    }
}