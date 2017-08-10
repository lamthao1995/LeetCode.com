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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rs = new ArrayList<>();
        if(root == null)
            return rs;
        if(root.left == null && root.right == null){
            rs.add(root.val + "");
            return rs;
        }
        String path = root.val + "";
        traverse(rs, root.right, path);
        traverse(rs, root.left, path);
        return rs;
    }
    public void traverse(List<String> rs, TreeNode root, String path){
        if(root == null) return;
        if(root.right == null && root.left == null){
            rs.add(path + "->" + root.val);
        }else{
            path = path + "->" + root.val;
            traverse(rs, root.right, path);
            traverse(rs, root.left, path);
        }
        
    }
}