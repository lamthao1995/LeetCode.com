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
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        findLeaveHelper(root);
        return rs;
    }
    public int findLeaveHelper(TreeNode root){
        if(root == null)
            return -1;
        int left = findLeaveHelper(root.left);
        int right = findLeaveHelper(root.right);
        
        int level = Math.max(right, left) + 1;
        if(rs.size() == level){
            rs.add(new ArrayList<Integer>());
        }
        rs.get(level).add(root.val);
        root.right = root.left = null;
        return level;
    }
}