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
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while(root != null){
            if(Math.abs(root.val - target) < Math.abs(ret - target)){
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}