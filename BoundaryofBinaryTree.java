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
    boolean stop = false;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root == null)
            return rs;
        rs.add(root.val);
        if(root.left != null){
             pre(root.left, true, true, rs);
             rs.remove(rs.size() - 1);
        }
       
        // add leaves
        if(root.left != null || root.right != null)
            post(root, rs);
        if(root.right != null){
                rs.remove(rs.size() - 1);
        //
                List<Integer> helper = new ArrayList<>();
                stop = false;
                pre(root.right, false, false, helper);
                rs.addAll(helper);
        }
        
        return rs;
    }
    public void post(TreeNode root, List<Integer> rs){
        if(root == null)
            return;
        post(root.left, rs);
        post(root.right, rs);
        if(root.right == null && root.left == null){
            rs.add(root.val);
        }
    } 
    public void pre(TreeNode root, boolean isLeft, boolean isStack, List<Integer> rs){
        if(stop == true || root == null)
            return;
        if(isStack)
            rs.add(root.val);
        else
            rs.add(0, root.val);
        if(root.left == null && root.right == null){
            stop = true;
        }
        if(isLeft){
            pre(root.left, true, isStack, rs);
            pre(root.right, true, isStack, rs);
        }else{
            pre(root.right, false, isStack, rs);
            pre(root.left, false, isStack, rs);
        }
       
    }
     
}