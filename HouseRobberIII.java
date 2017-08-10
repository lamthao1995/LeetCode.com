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
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int[] rs = helper(root);
        return Math.max(rs[0], rs[1]);
    }
    public int[] helper(TreeNode root){
        if(root == null)
            return new int[]{0, 0};
        int[] rs = new int[2];
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        
        rs[0] = root.val + left[1] + right[1];
        rs[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return rs;
    }
}