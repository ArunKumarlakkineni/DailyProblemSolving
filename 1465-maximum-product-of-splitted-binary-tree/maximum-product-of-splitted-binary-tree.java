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
        long total = dfs(root);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null)continue;
            long cur = (total-node.val)*node.val;
            ans = Math.max(ans,cur);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        return (int)(ans%MOD);
    }
}