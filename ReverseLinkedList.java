/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null, temp = null;
        while(cur != null){
            temp = prev;
            prev = cur;
            cur = cur.next;
            prev.next = temp;
        }
        return prev;
    }
}