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
    public int maxLevelSum(TreeNode root) {
        int res = Integer.MIN_VALUE;
        int level = 0;
        int res1 = 0;
        if(root.left==null && root.right==null) return 1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int temp = 0;
            level++;
            while(size>0){
                TreeNode curr = q.poll();
                temp+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                size--;
            }
            if(temp>res){
                res = temp;
                res1 = level;
            }
            
        }
        return res1;
    }
}