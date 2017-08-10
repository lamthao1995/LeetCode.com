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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;
        while(curr != null || s.isEmpty() == false){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            rs.add(curr.val);
            curr = curr.right;
        }
        return rs;
    }
}