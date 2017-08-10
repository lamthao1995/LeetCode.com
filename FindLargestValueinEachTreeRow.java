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
    int level = 0;
    int toBePrinted = 1;
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return rs;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            max = Math.max(max, tmp.val);
            if(tmp.left != null){
                level++;
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                level++;
                queue.add(tmp.right);
            }
            toBePrinted--;
            if(toBePrinted == 0){
                toBePrinted = level;
                level = 0;
                rs.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return rs;
    }
}