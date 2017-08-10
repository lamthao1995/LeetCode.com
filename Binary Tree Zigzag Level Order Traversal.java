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
    int toPrinted = 1;
    int level = 0;
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return rs;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        List<Integer> arr = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(count % 2 == 0)
                arr.add(temp.val);
            else
                arr.add(0, temp.val);
            if(temp.left != null){
                q.add(temp.left);
                level++;
            }
            if(temp.right != null){
                q.add(temp.right);
                level++;
            }
            toPrinted--;
            if(toPrinted == 0){
                toPrinted = level;
                level = 0;
                rs.add(arr);
                arr = new ArrayList<>();
                count++;
            }
        }
       
        return rs;
    }
    
}