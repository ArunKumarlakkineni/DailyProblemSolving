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
    public int solve(TreeNode root, int current) {
        if (root == null) return 0;

        current = (current << 1) | root.val;

        if (root.left == null && root.right == null)
            return current;

        return solve(root.left, current) + 
               solve(root.right, current);
    }

    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }
}