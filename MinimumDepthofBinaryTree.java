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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        minDepth(root, 1);
        return min;
    }
    public void minDepth(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
             if(level < min) min = level;
        }else{
            minDepth(root.left, level + 1);
            minDepth(root.right, level + 1);
        }
       
    }
}