/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int[] trace = new int[26];
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode headnew = null;
        if(fast == null){
            headnew = slow;
        }else{
            headnew = slow.next;
        }
        System.out.print(headnew.val);
        headnew = reverse(headnew);
    
        while(headnew != null){
            if(headnew.val != head.val) return false;
            headnew = headnew.next;
            head = head.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode root){
        ListNode cur = root;
        ListNode prev = null, temp;
        while(cur != null){
            temp = prev;
            prev = cur;
            cur = cur.next;
            prev.next = temp; 
        }
        root = prev;
        return root;
    }
}