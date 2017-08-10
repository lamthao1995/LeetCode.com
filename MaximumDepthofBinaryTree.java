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
    int max = 0;
    public int maxDepth(TreeNode root) {
        traversing(root, 0);
        return this.max;
    }
    public void traversing(TreeNode root, int sum){
        if(root == null) return;
        sum++;
        if(root.right == null && root.left == null){
            this.max = Math.max(this.max, sum);
        }else{
            traversing(root.right, sum);
            traversing(root.left, sum); 
        }
       
    }
}