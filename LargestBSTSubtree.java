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
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }
    public Wrapper helper(TreeNode root){
        Wrapper cur = new Wrapper();
        if(root == null){
            cur.isBST = true;
            return cur;
        }
        Wrapper l = helper(root.left);
        Wrapper r = helper(root.right);
        
        cur.lower = Math.min(l.lower, root.val);
        cur.upper = Math.max(r.upper, root.val);
        if(l.isBST && r.isBST && l.upper < root.val && r.lower > root.val){
            cur.size = l.size + r.size + 1;
            cur.isBST = true;
        }else{
            cur.size = Math.max(l.size, r.size);
            cur.isBST = false;
        }
        return cur;
    }
    public class Wrapper{
        int size;
        int lower, upper;
        boolean isBST;
        public Wrapper(){
            lower = Integer.MAX_VALUE;
            upper = Integer.MIN_VALUE;
            isBST = false;
            size = 0;
        }
    }
}