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
    public void inorder(TreeNode root,ArrayList<Integer> li){
        if(root==null) return;
        inorder(root.left,li);
        li.add(root.val);
        inorder(root.right,li);
    }
    public TreeNode solveBst(int l,int r,ArrayList<Integer> li){
        if(l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(li.get(mid));
        root.left = solveBst(l,mid-1,li);
        root.right = solveBst(mid+1,r,li);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> li = new ArrayList<>();
        inorder(root,li);
        return solveBst(0,li.size()-1,li);
    }
}