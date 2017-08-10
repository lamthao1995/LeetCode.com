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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfsBottomup(root, null);
    }
    private TreeNode dfsBottomup(TreeNode root, TreeNode parent){
        if(root == null) return parent;
        TreeNode tmp = dfsBottomup(root.left, root);
        root.left = (parent == null) ? parent : parent.right;
        root.right = parent;
        return tmp;
    }
}