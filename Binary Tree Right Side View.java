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
    int level = 0, toBePrinted = 1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root == null)
            return rs;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int first = Integer.MAX_VALUE;
        while(queue.isEmpty() == false){
            TreeNode tmp = queue.poll();
            if(first == Integer.MAX_VALUE){
                first = tmp.val;
            }
            if(tmp.right != null){
                queue.add(tmp.right);
                level++;
            }
            if(tmp.left != null){
                queue.add(tmp.left);
                level++;
            }
            toBePrinted--;
            if(toBePrinted == 0){
                toBePrinted = level;
                level = 0;
                rs.add(first);
                first = Integer.MAX_VALUE;
            }
        }
        return rs;
    }
}