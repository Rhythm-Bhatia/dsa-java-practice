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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        // int max=0;
        int ans=dia(root)+1;
        return max;

    }
    public int dia(TreeNode root){
        if(root==null)return 0;
        int left=dia(root.left);
        int right=dia(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}