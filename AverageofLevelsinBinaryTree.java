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
    int toBePrinted = 1;
    int level = 0;
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rs = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        long sum = 0;
        int count = 0;
        while(q.size() > 0){
            TreeNode top = q.poll();
            sum += (long)top.val;
            count++;
            if(top.left != null){
                level++;
                q.add(top.left);
            }
            if(top.right != null){
                level++;
                q.add(top.right);
            }
            toBePrinted--;
            if(toBePrinted == 0){
                rs.add((double) sum / count);
                toBePrinted = level;
                level = 0;
                sum = 0;
                count = 0;
            }
        }
        return rs;
    }
}