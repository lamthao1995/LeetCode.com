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
    public int pathSum(TreeNode root, int sum) {
        go(root, sum);
        return this.total;
    }
    public void go(TreeNode root, int sum){
        if(root == null) return;
        traversing(root, 0, sum);
        go(root.left, sum);
        go(root.right, sum);
    }
    public void traversing(TreeNode root, int tempSum, int sum){
        if(root == null) return;
        tempSum += root.val;
      //  System.out.println(tempSum);
        if(tempSum == sum) this.total++;
        traversing(root.left, tempSum, sum);
        traversing(root.right, tempSum, sum);
        
    }
}