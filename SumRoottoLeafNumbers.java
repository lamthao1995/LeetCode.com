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
    public int sumNumbers(TreeNode root) {
        calculate(root, 0);
        return total;
    }
    public void calculate(TreeNode root, int tempSum){
        if(root == null) return;
        tempSum = tempSum * 10 + root.val;
        if(root.left == null && root.right == null){
            this.total += tempSum;
            return;
        }
       
        calculate(root.right, tempSum);
        calculate(root.left, tempSum);
    }
}