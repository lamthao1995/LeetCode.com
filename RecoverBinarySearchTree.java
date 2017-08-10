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
    TreeNode first, second;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        //
        if(first == null){
            if(pre.val >= root.val){
                first = pre;
            }
        }
        if(first != null && pre.val >= root.val)
            second = root;
        pre = root;
        //
        traverse(root.right);
    }
}