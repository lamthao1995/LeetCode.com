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
    Stack<TreeNode> stack
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(0);
        temp = head;
        preOrder(root);
        root = head.right;
    }
    public void preOrder(TreeNode root){
        if(root == null) return;
        temp.left = null;
        temp.right = new TreeNode(root.val);
  
        temp = temp.right;
        preOrder(root.left);
        preOrder(root.right);
    }
}