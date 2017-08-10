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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return helper(1, n);
    }
    public List<TreeNode> helper(int left, int right){
        List<TreeNode> arr = new ArrayList<>();
        if(left > right){
            arr.add(null);
            return arr;
        }
        for(int i = left; i <= right; i++){
            List<TreeNode> ls = helper(left, i - 1);
            List<TreeNode> rs = helper(i + 1, right);
            
            for(TreeNode l : ls){
                for(TreeNode r : rs){
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    arr.add(cur);
                }
            }
        }
        return arr;
    }
}