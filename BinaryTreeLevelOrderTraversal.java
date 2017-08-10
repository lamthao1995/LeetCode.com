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
    int toPrint = 1;
    int level = 0;
    List<List<Integer>> arr = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return arr;
        q.add(root);
        List<Integer> rs = new ArrayList<>();
        while(q.size() > 0){
            TreeNode temp = q.peek();
            rs.add(temp.val);
            if(temp.left != null){
                q.add(temp.left);
                level++;
            }
            if(temp.right != null){
                q.add(temp.right);
                level++;
            }
            q.poll();
            toPrint--;
            if(toPrint == 0){
                this.arr.add(rs);
                rs = new ArrayList<>();
                toPrint = level;
                level = 0;
            }
            //print
            
        }
        return arr;
    }
}