/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    int count = 0;
    boolean check = false;
    public boolean checkEqualTree(TreeNode root) {
        traverse(root);
        if(Math.abs(sum) % 2 == 1 || (root == null) || (root.right == null && root.left == null))
            return false;
        postTraverse(root);
        return check;
    }
    public void traverse(TreeNode root){
        if(root == null)
            return;
        sum += root.val;
        traverse(root.left);
        traverse(root.right);
    }
    public int postTraverse(TreeNode root){
        if(root == null || check == true)
            return 0;
        int leftVal = postTraverse(root.left);
        int rightVal = postTraverse(root.right);
        int val = root.val + leftVal + rightVal;
        if((root.left != null || root.right != null) && 
            Math.abs(leftVal - rightVal) == root.val && sum == val){
            check = true;
        }
        if(val == sum / 2){
            check = true;
        }
        return val;
    }
}