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
    HashMap<String, Integer> map = new HashMap();
    List<TreeNode> rs = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null)
            return new ArrayList<TreeNode>();
        path(root);
        return rs;
    }
    public String path(TreeNode root){
        if(root == null)
            return "#";
        String temp = root.val + "," + path(root.left) + "," + path(root.right);
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        if(map.get(temp) == 2){
            rs.add(root);
        }
        return temp;
        
    }
}