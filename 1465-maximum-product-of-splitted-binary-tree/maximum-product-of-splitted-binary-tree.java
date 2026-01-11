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
    long ans=0;
    long MOD = 1000000007L;
    public long dfs(TreeNode root){
        if(root==null) return 0; 
        root.val += dfs(root.left) + dfs(root.right);
        return root.val;
    }
    public int maxProduct(TreeNode root) {
        long tot = dfs(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        long maxi = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            long curP = (tot-cur.val)*cur.val;
            maxi = Math.max(maxi,curP);
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
        return (int)(maxi%MOD);
    }
}