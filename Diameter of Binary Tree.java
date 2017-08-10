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
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        find_max(root);
        return result - 1;
    }
     public int find_max(TreeNode root){
        if(root == null) return 0;
        int max_left = find_max(root.left);
        int max_right = find_max(root.right);
        int max  = max_left + max_right + 1;
        if(max > result) result = max;
        return Math.max(max_left + 1, max_right + 1);
    }
}