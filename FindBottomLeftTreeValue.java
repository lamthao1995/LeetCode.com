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
    int leftMost;
    int depth = -1;
    public int findBottomLeftValue(TreeNode root) {
        leftMost = root.val;
        traverse(root.left, 0, true);
        traverse(root.right, 0, false);
        return leftMost;
    }
    public void traverse(TreeNode root, int level, boolean isLeft){
        if(root == null) return;
        if(root.right == null && root.left == null){
            if(isLeft == true && level > depth){
                depth = level;
                leftMost =root.val;
                return;
            }
            if(isLeft == false && level > depth){
                depth = level;
                leftMost = root.val;
            }
        }else{
            
            traverse(root.left, level + 1, true);
            traverse(root.right, level + 1, false);
        }
    }
}