/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        h = head;
        int len = getLength(head);
        return convert(0, len - 1);
        
    }
    public int getLength(ListNode head){
        ListNode h = head;
        int len = 0;
        while(h != null){
            len++;
            h = h.next;
        }
        return len;
    }
    public TreeNode convert(int start, int end){
        if(start > end)
            return null;
        int mid = (start + end) >> 1;
       // TreeNode root = new TreeNode(num[mid]);
        TreeNode left = convert(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = convert(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}