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
    boolean stop = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        traversing(root, 0, sum);
        return stop;
    }
    public void traversing(TreeNode root, int temp, int sum){
        if(root == null || stop == true) return;
        temp += root.val;
        if(temp == sum && root.right == null && root.left == null){
            this.stop = true;
            return;
        }else{
            traversing(root.left, temp, sum);
            traversing(root.right, temp, sum);
        }
        
    }
}