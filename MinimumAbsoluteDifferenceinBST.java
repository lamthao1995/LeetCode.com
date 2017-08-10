/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        if(prev != null){
            min = min(min, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }
    public int min(int x, int y){
        return Math.min(x, y);
    }
}