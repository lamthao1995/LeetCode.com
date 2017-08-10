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
    public int longestConsecutive(TreeNode root) {
        conse(root, 0, Integer.MAX_VALUE - 100);
        return max;
    }
    public void conse(TreeNode root, int count, int parent){
        if(root == null){
            max = Math.max(count, max);
            return;
        }
            
        if(root.val == parent + 1){
            conse(root.left, count + 1, root.val);
            conse(root.right, count + 1, root.val);
        }else{
            max = Math.max(max, count);
            conse(root.left, 1, root.val);
            conse(root.right, 1, root.val);
        }
    }
}