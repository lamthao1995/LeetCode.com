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
    static boolean check = false;
    public boolean isBalanced(TreeNode root) {
        check = true;
        height(root);
        return check;
    }
    
    public int height(TreeNode node){
        if(node == null) return 0;
      int leftHeight = height(node.left);
      int rightHeight = height(node.right);
      if(Math.abs(leftHeight - rightHeight) >= 2) check = false;
      return Math.max(leftHeight, rightHeight) + 1;
    }
}