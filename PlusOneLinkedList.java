/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode root = head, prev = null;
        int hold = 1;
        while(hold == 1){
            if(root == null){
                prev.next = new ListNode(1);
                break;
            }
            int total = hold + root.val;
            if(total >= 10){
                root.val = 0;
                hold = 1;
            }else{
                hold = 0;
                root.val = total;
            }
            prev = root;
            root = root.next;
        }
        return reverse(head);
    }
    public ListNode reverse(ListNode root){
        ListNode cur = root, prev = null, next = null;
        while(cur != null){
            next = prev;
            prev = cur;
            cur = cur.next;
            prev.next = next;
        }
        return prev;
    }
}