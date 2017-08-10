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
    public TreeNode deleteNode(TreeNode root, int key) {
       if(root == null) return null;
       if(root.val < key){
           root.right = deleteNode(root.right, key);
       }else if(root.val > key){
           root.left = deleteNode(root.left, key);
       }else{
           if(root.right == null) return root.left;
           if(root.left == null) return root.right;
           TreeNode maxLeft = getLeft(root.right);
           root.val = maxLeft.val;
           root.right = deleteNode(root.right, maxLeft.val);
       }
       return root;
       
    }
   
    public TreeNode getLeft(TreeNode x){
        while(x.left != null){
            x = x.left;
        }
        return x;
    }
}