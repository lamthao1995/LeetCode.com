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
    int toBeprinted = 1;
    int level = 0;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        Queue<TreeNode> s = new LinkedList();
        if(root == null) return rs;
        s.add(root);
        List<Integer> arr = new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode temp = s.poll();
            arr.add(temp.val);
            if(temp.left != null){
                s.add(temp.left);
                level++;
            }
            if(temp.right != null){
                s.add(temp.right);
                level++;
            }
            toBeprinted--;
            if(toBeprinted == 0){
                toBeprinted = level;
                level = 0;
                rs.add(0, arr);
                arr = new ArrayList<>();
            }
        }
        return rs;
    }
}