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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> st1 = new Stack(); // predecessor
        Stack<Integer> st2 = new Stack(); // successor
        inorder(root, false, st1, target);
        inorder(root, true, st2, target);
        List<Integer> rs = new LinkedList();
        while(k-- > 0){
            if(st1.isEmpty()){
                rs.add(st2.pop());
            }else if(st2.isEmpty()){
                rs.add(st1.pop());
            }else if(Math.abs(st1.peek() - target) < Math.abs(st2.peek() - target)){
                rs.add(st1.pop());
            }else{
                rs.add(st2.pop());
            }
        }
        return rs;
        
    }
    public void inorder(TreeNode root, boolean reverse, Stack<Integer> st, double target){
        if(root == null)
            return;
      
        inorder(reverse ? root.right : root.left, reverse, st, target);
        if((!reverse && root.val > target) || (reverse && root.val <= target))
            return;
        st.push(root.val);
        inorder(reverse ? root.left : root.right, reverse, st, target);
    }
}