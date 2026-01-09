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
    int maxDistance=0;
    Map<TreeNode,Integer>map=new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        deep(root,0);
        return lca(root);
    }
    private void deep(TreeNode root,int d){
        if(root==null)return;
        maxDistance=Math.max(maxDistance,d);
        map.put(root,d);
        deep(root.left,d+1);
        deep(root.right,d+1);
    }
    private TreeNode lca(TreeNode root){
        if(root==null)return null;
        if(map.get(root)==maxDistance)return root;
        TreeNode left=lca(root.left);
        TreeNode right=lca(root.right);
        if(left!=null&&right!=null)return root;
        else if(right==null)return left;
        else return right;
    }
    

}