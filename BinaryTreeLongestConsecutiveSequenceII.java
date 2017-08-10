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
    int maxVal = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxVal;
    }
    public int[] longestPath(TreeNode root){
        if(root == null)
            return new int[]{0, 0};
        int incre = 1, decre = 1;
        if(root.left != null){
            int[] leftPath = longestPath(root.left);
            if(root.left.val + 1 == root.val){
                incre = leftPath[0] + 1;
            }else if(root.left.val - 1 == root.val){
                decre = leftPath[1] + 1;
            }
        }
        if(root.right != null){
            int[] rightPath = longestPath(root.right);
            if(root.right.val + 1 == root.val)
                incre = Math.max(rightPath[0] + 1, incre);
            else if(root.right.val - 1 == root.val)
                decre = Math.max(rightPath[1] + 1, decre);
        }
        maxVal = Math.max(maxVal, incre + decre - 1);
        return new int[]{incre, decre};
        
    }
}