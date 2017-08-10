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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return res;
    }
    public int max(TreeNode root){
        if(root == null) return 0;
        int maxL = max(root.left);
        int maxR = max(root.right);
        maxL = maxL < 0 ? 0 : maxL;
        maxR = maxR < 0 ? 0 : maxR;
        if(maxL + maxR + root.val > res){
            res = maxL + maxR + root.val;
        }
        return root.val + Math.max(maxL, maxR);
        
    }
    
}