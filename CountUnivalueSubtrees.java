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
    int total = 0;
    public int countUnivalSubtrees(TreeNode root) {
        diff(root);
        return total;
    }
    public boolean diff(TreeNode root){
         if(root == null)
             return true;
        boolean left = diff(root.left);
        boolean right = diff(root.right);
        if(left && right && (root.left == null || root.val == root.left.val) 
                            && (root.right == null || root.val == root.right.val)){
            total++;
            return true;
        }
        return false;
        
    }
}