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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        left(root);
        return sum;
    }
    public void left(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            if(root.left.right == null && root.left.left == null) sum += root.left.val;
        } 
        left(root.right);
        left(root.left);
      
    }
}