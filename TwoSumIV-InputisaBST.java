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
     boolean check = false;
    TreeNode r;
    public boolean findTarget(TreeNode root, int k) {
        r = root;
        traverse(root, k);
        return check;
    }
    public void traverse(TreeNode root, int k){
        if(root == null || check == true)
            return;
        traverse(root.left, k);
        if(find(r, k - root.val, root)){
            check = true;
        }
        traverse(root.right, k);
    }
    public boolean find(TreeNode root, int target, TreeNode p){
        if(root == null)
            return false;
        if(root.val == target){
            if(root == p)
                return false;
            else
                return true;
        }
        else if(root.val < target)
            return find(root.right, target, p);
        else
            return find(root.left, target, p);
    }
}