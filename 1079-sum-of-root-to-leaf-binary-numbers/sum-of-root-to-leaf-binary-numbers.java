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
    public void solve(TreeNode root, List<String> nums, String temp) {
        if (root == null) return;

        temp += root.val;

        // Add only when it's a leaf
        if (root.left == null && root.right == null) {
            nums.add(temp);
            return;
        }

        solve(root.left, nums, temp);
        solve(root.right, nums, temp);
    }

    public int sumRootToLeaf(TreeNode root) {
        List<String> nums = new ArrayList<>();
        solve(root, nums, "");

        return nums.stream()
                .mapToInt(s -> Integer.parseInt(s, 2))
                .sum();
    }
}