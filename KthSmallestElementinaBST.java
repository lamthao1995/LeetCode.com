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
  
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode p = root;
        while(true){
            while(p != null){
                stack.add(p);
                p = p.left;
            }
            
            if(stack.isEmpty()) return -1;
            
            TreeNode node = stack.pop();
            k--;
            if(k == 0)
                return node.val;
            p = node.right;
        }
        
        //return -1;
        
    }
   
}