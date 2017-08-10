/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode merge = merge(left, right);
        return merge;
    }
    public ListNode merge(ListNode r1, ListNode r2){
        if(r1 == null) return r2;
        if(r2 == null) return r1;
        ListNode root = new ListNode(0);
        ListNode tmp = root;
        while(r1 != null && r2 != null){
            if(r1.val < r2.val){
                tmp.next = r1;
                r1 = r1.next;
            }else{
                tmp.next = r2;
                r2 = r2.next;
            }
            tmp = tmp.next;
        }
        if(r1 == null)
            tmp.next = r2;
        else
            tmp.next = r1;
        return root.next;
    }
}