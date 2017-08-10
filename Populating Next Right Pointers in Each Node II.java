/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    int level = 0, toBePrinted = 1;
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList();
        q.add(root);
        List<TreeLinkNode> arr = new ArrayList<>();
        while(q.isEmpty() == false){
            TreeLinkNode tmp = q.poll();
            arr.add(tmp);
            if(tmp.left != null){
                level++;
                q.add(tmp.left);
            }
            if(tmp.right != null){
                level++;
                q.add(tmp.right);
            }
            toBePrinted--;
            if(toBePrinted == 0){
                TreeLinkNode head = arr.get(0);
                for(int i = 1; i < arr.size(); i++){
                    head.next = arr.get(i);
                    head = head.next;
                }
                arr.clear();
                toBePrinted = level;
                level = 0;
            }
        }
    }
}