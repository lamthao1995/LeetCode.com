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
    public int countNodes(TreeNode root) {
    //  if(root == null) return 0;
        int left = leftD(root);
        int right = rightD(root);
        if(left == right){
            return (1 << left) - 1;
        }else{
            return countNodes(root.right) + countNodes(root.left) + 1;
        }
    }
    public int leftD(TreeNode r){
        int dep = 0;
        while(r != null){
            dep++;
            r = r.left;
        }
        return dep;
    }
    public int rightD(TreeNode r){
        int dep = 0;
        while(r != null){
            dep++;
            r = r.right;
        }
        return dep;
    }
}