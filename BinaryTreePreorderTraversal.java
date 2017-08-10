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
    List<Integer> rs = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return rs;
        Stack<TreeNode> s = new Stack();
        s.push(root);
        while(s.isEmpty() == false){
           TreeNode t = s.peek();
           rs.add(t.val);
           s.pop();
           if(t.right != null){
               s.push(t.right);
           }
           if(t.left != null){
               s.push(t.left);
           }
        }
        return rs;
    }
}