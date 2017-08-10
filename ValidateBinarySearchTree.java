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
    public boolean isValidBST(TreeNode root) {
       return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    
}
  